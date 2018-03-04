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
	startWorker();
  xhr.onload = function () {
   
  if (xhr.status === 200) {
    uploadButton.innerHTML = 'Upload';
  } else {
    alert('An error occurred!');
  }
};
// Send the Data.
xhr.send(formData);
stopWorker()


}



// upload progress bar code
var UPLOAD_STATUS_KEY="upload_status";
var UPLOAD_VALUE_KEY="upload_value";




var w;

function startWorker() {
    if(typeof(Worker) !== "undefined") {
        if(typeof(w) == "undefined") {
            w = new Worker("/adminWeb/resources/js/worker.js");
            console.log("gg");
            w.postMessage("Hello worker!");
        }
       
        
    } else {
        console.log("else nhanh");
    }
}

function stopWorker() { 
    w.terminate();
    w = undefined;
}



