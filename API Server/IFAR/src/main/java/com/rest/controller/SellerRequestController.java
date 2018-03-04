package com.rest.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.rest.domain.Model;
import com.rest.domain.Product;
import com.rest.domain.SellerRequest;
import com.rest.repository.ModelRepository;
import com.rest.repository.ProductRepository;
import com.rest.repository.SellerRequestRepository;
import com.rest.s3config.ConfigProperties;

@Controller
@RequestMapping(path = "IFAR")
public class SellerRequestController {
	private static final Logger logger = Logger.getLogger(SellerRequestController.class);

	// Gobal variable to keep track upload progess
			static JSONObject uploadData; 
			final static String UPLOAD_STATUS_KEY="upload_status";
			final static String UPLOAD_VALUE_KEY="upload_value";
			static{
				uploadData = new JSONObject();
				try {
					uploadData.put(UPLOAD_STATUS_KEY, "start");
					uploadData.put(UPLOAD_VALUE_KEY, "0");
				} catch (JSONException e) {
				}
				
			}
	
	
	
	// Save the uploaded file to this folder
	private static String UPLOADED_FOLDER = System.getProperty("user.dir") + "/SellerImages//";
	@Autowired
	private AmazonS3 s3client;

	@Autowired
	private SellerRequestRepository sellerRequestRepository;

	@Autowired
	private ModelRepository modelRepository;
	@Autowired
	private ProductRepository productRepository;

	@PostMapping(path = "re-upload")
	public ResponseEntity reupload(@RequestParam("file") MultipartFile[] files, @RequestParam String _id)
			throws Exception {
		
		uploadData.put(UPLOAD_STATUS_KEY, "START");
		uploadData.put(UPLOAD_VALUE_KEY, "0");
		
		
		String fileName = null;
		String msg = "";
		String bucketName = ConfigProperties.getInstance().getValue("jsa.s3.bucket");
		String s3Host = ConfigProperties.getInstance().getValue("jsa.s3.host");
		SellerRequest request = sellerRequestRepository.findOne(Integer.parseInt(_id));
		String username = request.getUserAccount().getUsername();
		String forlderName = username + "_" + _id + "_IFAR";
		String forlderS3 = username + "/" + forlderName + "/3Dmodel";
		// String link =
		// modelRepository.getLinkBySellerRequestId(Integer.parseInt(_id));
		String fileUrl = buildUrlWhenUploaded(s3Host, bucketName + "/" + forlderS3 + "/");
		if (files != null && files.length > 0) {
			for (int i = 0; i < files.length; i++) {
				try {

					fileName = files[i].getOriginalFilename().replaceAll(" ", "");
					String finalFileName = fileName;
					if (files[i].getOriginalFilename().endsWith(".obj")) {
						System.out.println(files[i].getOriginalFilename());
						fileUrl = buildUrlWhenUploaded(s3Host,
								bucketName + "/" + forlderS3 + "/" + files[i].getOriginalFilename());
					}
					System.out.println("File size: " + files[i].getSize());
					System.out.println("File name: " + fileName);
					File convFile = new File(finalFileName);
					convFile = convertMultiPartToFile(files[i]);
					uploadFile(convFile, bucketName + "/" + forlderS3, fileName);
					System.out.println(convFile.getTotalSpace());
					convFile.delete();
					msg += "You have successfully uploaded " + fileName + "\n";
					int value = uploadData.getInt(UPLOAD_VALUE_KEY);
					uploadData.put(UPLOAD_VALUE_KEY, value+=calcualateProgressPercent(files.length));
				} catch (Exception e) {
					msg= "You failed to upload " + fileName + ": " + e.getMessage() + "<br/>";
				}
			}
			
			uploadData.put(UPLOAD_STATUS_KEY, "DONE");
			
			Model model = new Model();
			model.setCreatedAt(Calendar.getInstance().getTime());
			model.setHeight(request.getHeight());
			model.setLength(request.getLength());
			model.setWidth(request.getWidth());
			model.setStatus(-1);
			model.setLink(fileUrl);
			model.setSellerRequest(request);
			modelRepository.save(model);
//			Product product = new Product();
//			product.setCreatedAt(Calendar.getInstance().getTime());
//			product.setUpdatedAt(Calendar.getInstance().getTime());
//			product.setDescribe("test");
//			product.setImage("test");
//			product.setModel(model);
//			product.setName("test");
//			product.setOrigin("test");
//			product.setPrice(1.1);
//			product.setQuantity(1);
//			product.setStatus(-1);
//			product.setWeight(1);
//			productRepository.save(product);
//			if (product.getId() > 0) {
//				model.setStatus(1);
//			}
			return new ResponseEntity("success", HttpStatus.OK);
		} else {
			return new ResponseEntity("fail", HttpStatus.OK);
		}
	}

	@GetMapping(path = "getImages")
	public @ResponseBody List<String> listKeysInDirectory(@RequestParam("id") String id) throws Exception {
		String bucketName = ConfigProperties.getInstance().getValue("jsa.s3.bucket");
		String s3Host = ConfigProperties.getInstance().getValue("jsa.s3.host");
		final String headerUrl = s3Host + "/" + bucketName + "/";
		SellerRequest request = sellerRequestRepository.findOne(Integer.parseInt(id));
		String username = request.getUserAccount().getUsername();
		String forlderName = username + "_" + id + "_IFAR";
		String forlderS3 = username + "/" + forlderName + "/image";

		ListObjectsRequest listObjectsRequest = new ListObjectsRequest().withBucketName(bucketName)
				.withPrefix(forlderS3 + "/");
		ObjectListing objects = s3client.listObjects(listObjectsRequest);
		List<String> keys = new ArrayList<>();
		List<String> urlImage = new ArrayList<>();
		for (;;) {
			List<S3ObjectSummary> summaries = objects.getObjectSummaries();
			if (summaries.size() < 1) {
				break;
			}
			summaries.forEach(s -> keys.add(headerUrl + s.getKey()));
			objects = s3client.listNextBatchOfObjects(objects);

		}
		return keys;
	}

	@RequestMapping(value = "/uploadImages", method = RequestMethod.POST)
	public @ResponseBody String multipleSave(@RequestParam("file") MultipartFile[] files) throws Exception {
		String fileName = null;
		String msg = "";
		String bucketName = "";
		String s3Host = "";
		int reqid = 1;
		int sellerId = 1;
		int status = 1;
		String fileUrl = "";
		boolean isGenerateFileName = false;

		try {

			bucketName = ConfigProperties.getInstance().getValue("jsa.s3.bucket");
			s3Host = ConfigProperties.getInstance().getValue("jsa.s3.host");
			isGenerateFileName = Boolean.parseBoolean(ConfigProperties.getInstance().getValue("is.gennerate.new.name"));
		} catch (Exception e) {
			return "Error when readding configuration file";
		}
		if (files != null && files.length > 0) {
			for (int i = 0; i < files.length; i++) {
				try {

					fileName = files[i].getOriginalFilename();
					String finalFileName = fileName;

					// if (isGenerateFileName) {
					// // image.jsp
					// String fileNameWithOutExt =
					// FilenameUtils.removeExtension(fileName); // -> get file
					// name: image
					// String ext = FilenameUtils.getExtension(fileName); // get
					// extension: .sjp
					// Integer fileId = mediaDAO.getMaxId();
					// fileId++;
					// finalFileName = fileNameWithOutExt + "-" + fileId + "." +
					// ext;
					// } else {
					// finalFileName = fileName;
					//
					// }

					fileUrl = buildUrlWhenUploaded(s3Host, bucketName + "/abc/");

					File convFile = new File(finalFileName);
					convFile = convertMultiPartToFile(files[i]);
					uploadFile(convFile, bucketName + "/abc", finalFileName);
					System.out.println(convFile.getTotalSpace());

					// mediaDAO.createMedia(finalFileName, fileUrl);

					msg += "You have successfully uploaded " + fileName + "\n";
				} catch (Exception e) {
					return "You failed to upload " + fileName + ": " + e.getMessage() + "<br/>";
				}
			}
			SellerRequest sellerRequest = new SellerRequest();
			sellerRequest = sellerRequestRepository.findOne(reqid);
			sellerRequest.setStatus(status);
			sellerRequest.setUpdatedAt(Calendar.getInstance().getTime());
			sellerRequest.setPublicLink(fileUrl);
			sellerRequestRepository.save(sellerRequest);
			return msg;
		} else {
			return "Unable to upload. File is empty.";
		}
	}

	private String buildUrlWhenReUploaded(String host, String bucketName, String fileName) throws Exception {
		return host + "/" + bucketName + "/" + fileName;

	}

	private String buildUrlWhenUploaded(String host, String bucketName) throws Exception {
		return host + "/" + bucketName;

	}

	public void uploadFile(File file, String bucketName, String fileNameInS3) {
		try {
			s3client.putObject(new PutObjectRequest(bucketName, fileNameInS3, file)
					.withCannedAcl(CannedAccessControlList.PublicReadWrite));
			logger.info("===================== Upload File - Done! =====================");

		} catch (AmazonServiceException ase) {
			logger.info("Caught an AmazonServiceException from PUT requests, rejected reasons:");
			logger.info("Error Message:    " + ase.getMessage());
			logger.info("HTTP Status Code: " + ase.getStatusCode());
			logger.info("AWS Error Code:   " + ase.getErrorCode());
			logger.info("Error Type:       " + ase.getErrorType());
			logger.info("Request ID:       " + ase.getRequestId());
		} catch (AmazonClientException ace) {
			logger.info("Caught an AmazonClientException: ");
			logger.info("Error Message: " + ace.getMessage());
		}
	}

	@GetMapping(path = "getSellerRequest")
	public @ResponseBody String getSellerRequest(@RequestParam String status,
			@RequestParam(required = false) String rejectReason) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		if (status.equalsIgnoreCase("1")) {
			List<SellerRequest> approveds = sellerRequestRepository.getApprove();
			return mapper.writeValueAsString(approveds);
		} else if (status.equalsIgnoreCase("0")) {
			List<SellerRequest> pendings = sellerRequestRepository.getPending();
			return mapper.writeValueAsString(pendings);

		} else if (status.equalsIgnoreCase("-1")) {
			List<SellerRequest> rejectss = sellerRequestRepository.getReject();
			return mapper.writeValueAsString(rejectss);
		}

		return null;
	}

	@GetMapping(path = "getModelLink")
	public @ResponseBody String modelLinkBySellerRequest(@RequestParam String id) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		String link = modelRepository.getLinkBySellerRequestId(Integer.parseInt(id));
		System.out.println(link);

		return link;
	}

	@PostMapping(path = "reject")
	public @ResponseBody String rejectSellerRequest(@RequestParam(value = "id") String id,
			@RequestParam(value = "reason") String reason) throws Exception {
		SellerRequest sellerRequest = new SellerRequest();
		sellerRequest = sellerRequestRepository.findOne(Integer.parseInt(id));
		sellerRequest.setUpdatedAt(Calendar.getInstance().getTime());
		sellerRequest.setStatus(0);
		sellerRequest.setRejectReason(reason);
		sellerRequestRepository.save(sellerRequest);
		System.out.println("api: " + reason);
		return reason;

	}

	@GetMapping(path = "approve")
	public ResponseEntity approveImage(@RequestParam String id) throws Exception {
		System.out.println("id nhan: "+id);
		// List<File> files = new LinkedList<File>();
		// listFiles(new File("G:\\picture"), files, true);
		String result = "fail";
		String msg = "";
		String bucketName = "";
		String s3Host = "";
		SellerRequest request = sellerRequestRepository.findOne(Integer.parseInt(id));
		String username = request.getUserAccount().getUsername();
		String forlderName = username + "_" + id + "_IFAR";
		String forlderS3 = username + "/" + forlderName + "/image";
		String picAvatar = username + "/" + forlderName + "/model";
		String workingDir = System.getProperty("user.dir");
		System.out.println(workingDir);
		try {
			bucketName = ConfigProperties.getInstance().getValue("jsa.s3.bucket");
			s3Host = ConfigProperties.getInstance().getValue("jsa.s3.host");
		} catch (Exception e) {
			System.out.println("Error when readding configuration file");
		}
		try {
			final File folder = new File(workingDir + "//src//picture");
			System.out.println("folder path " + folder.getAbsolutePath());
			File convFile = folder.listFiles()[0];
			// System.out.println("converfile"+convFile.getName());
			// Files.copy(convFile.toPath(), (new
			// File(workingDir+"//src//picture//picture" +
			// convFile.getName())).toPath(),
			// StandardCopyOption.REPLACE_EXISTING);
			//
			// File avatar = new File(workingDir+"//src//picture//picture" +
			// convFile.getName());
			uploadFile(convFile, bucketName + "/" + picAvatar, convFile.getName().replaceAll(" ", ""));
			// avatar.delete();
			String newName = null;
			for (final File fileEntry : folder.listFiles()) {
				System.out.println("get name file entry: " + fileEntry.getName());
				System.out.println("get length file entry: " + fileEntry.length());
				newName = fileEntry.getName().replaceAll(" ", "");
				System.out.println("get name new file : " + newName);
				uploadFile(fileEntry, bucketName + "/" + forlderS3, newName);

			}
			;

			String fileUrl = buildUrlWhenUploaded(s3Host, bucketName + "/" + forlderS3 + "/");
			SellerRequest sellerRequest = new SellerRequest();
			sellerRequest = sellerRequestRepository.findOne(Integer.parseInt(id));
			sellerRequest.setStatus(1);
			sellerRequest.setUpdatedAt(Calendar.getInstance().getTime());
			sellerRequest.setPublicLink(fileUrl);
			sellerRequest.setRejectReason(null);
			sellerRequestRepository.save(sellerRequest);
			result = "success";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return new ResponseEntity(result, HttpStatus.OK);

	}

	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

	// 3.1.2 Multiple file upload
	@PostMapping(path = "requestModel")
	public ResponseEntity<?> uploadFileMulti(@RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("files") MultipartFile[] uploadfiles) {

		System.out.println(username + " " + password);
		System.out.println("My Dir: " + System.getProperty("user.dir"));

		logger.debug("Multiple file upload!");

		// Get file name
		String uploadedFileName = Arrays.stream(uploadfiles).map(x -> x.getOriginalFilename())
				.filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining(" , "));

		System.out.println(uploadedFileName);
		if (StringUtils.isEmpty(uploadedFileName)) {
			return new ResponseEntity("please select a file!", HttpStatus.OK);
		}

		try {

			saveUploadedFiles(Arrays.asList(uploadfiles));

		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity("Successfully uploaded - " + uploadedFileName, HttpStatus.OK);

	}

	// save file
	private void saveUploadedFiles(List<MultipartFile> files) throws IOException {

		for (MultipartFile file : files) {

			if (file.isEmpty()) {
				continue; // next pls
			}

			byte[] bytes = file.getBytes();
			System.out.println(UPLOADED_FOLDER);
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);

		}

	}
	
	@RequestMapping(value = "/getUpdateData", method = RequestMethod.GET)
	public @ResponseBody String getUploadprogressData(HttpServletRequest request)
			throws Exception {
		int value = uploadData.getInt(UPLOAD_VALUE_KEY);
		
		return uploadData.toString();
	}
	
	private int calcualateProgressPercent(int fileSize){
		return Math.round(100/fileSize);
	}
	

}
