var form = document.getElementById('uploadForm');
var fileSelect =document.getElementById('input_upload'); 
var uploadButton =document.getElementById('btn_upload');

console.log('test');




form.onsubmit = function(event) {
  event.preventDefault();
  var valueID= document.getElementById("rq_id").innerHTML;
  console.log(valueID);
  uploadButton.innerHTML = 'Uploading...';

  // Get the selected files from the input.
var files = fileSelect.files;
var formData = new FormData();


for (var i = 0; i < files.length; i++) {
  var file = files[i];

  formData.append('file', file, file.name);
}
formData.append("_id",valueID);

	var xhr = new XMLHttpRequest();
	xhr.open('POST', form.getAttribute("action"), true);

	// Set up a handler for when the request finishes.
  xhr.onload = function () {
  if (xhr.status === 200) {
    // File(s) uploaded.
    getUpdateProgress();
getUpdateProgress();
getUpdateProgress();
getUpdateProgress();
getUpdateProgress();
getUpdateProgress();
getUpdateProgress();
getUpdateProgress();
getUpdateProgress();
getUpdateProgress();
getUpdateProgress();
getUpdateProgress();
    uploadButton.innerHTML = 'Upload';
  } else {
    alert('An error occurred!');
  }
};
// Send the Data.
xhr.send(formData);



}



// upload progress bar code
var UPLOAD_STATUS_KEY="upload_status";
var UPLOAD_VALUE_KEY="upload_value";


function getUpdateProgress(){
	
	var progressBarDiv = document.getElementById("progressBarHolder");
	progressBarDiv.setAttribute("style", "display:block");


	$.ajax({
            url: "/adminWeb/getUpdateData",
            type: 'GET',
            success: function(res) {
                console.log(res);

                var dataObj = JSON.parse(res);
                var percent = dataObj.upload_value;
                var progressBar = document.getElementById("progress_bar");
              
                
                progressBar.setAttribute("style", "width:"+percent+"%");	
                progressBar.setAttribute("aria-valuenow", percent);	
                progressBar.innerHTML=percent+"%"
                
                if(percent>=100){
                	return;	

            }
				


             
            }
        });
	

}
