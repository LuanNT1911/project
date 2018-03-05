var form = document.getElementById('uploadForm');
var fileSelect = document.getElementById('input_upload');
var uploadButton = document.getElementById('btn_upload');
console.log('test');
form.onsubmit = function (event) {
        event.preventDefault();
        var valueID = document.getElementById("rq_id").innerHTML;
        console.log(valueID);
        uploadButton.innerHTML = 'Uploading...';
        // Get the selected files from the input.
        var files = fileSelect.files;
        var formData = new FormData();
        for (var i = 0; i < files.length; i++) {
            var file = files[i];
            formData.append('file', file, file.name);
        }
        formData.append("_id", valueID);
        var xhr = new XMLHttpRequest();
        xhr.open('POST', form.getAttribute("action"), true);
        // Set up a handler for when the request finishes.
        startWorker();
        xhr.onload = function () {
            if (xhr.status === 200) {
                uploadButton.innerHTML = 'Upload';
                alert("Upload files successful!");
                disableProgressBar();
            }
            else {
                alert('An error occurred!');
            }
        };
        // Send the Data.
        xhr.send(formData);
//        stopWorker()
    }
    // upload progress bar code
var UPLOAD_STATUS_KEY = "upload_status";
var UPLOAD_VALUE_KEY = "upload_value";
var w;
w = new Worker("/adminWeb/resources/js/worker.js");

function startWorker() {
    w.postMessage("hello");
};

w.onmessage = function (e) {
    console.log(e.data);
    getUpdateProgress(e.data);
    console.log('Message received from worker');
};

function stopWorker() {
    w.terminate();
    w = undefined;
}


function getUpdateProgress(res){
	
	var progressBarDiv = document.getElementById("progressBarHolder");
	progressBarDiv.setAttribute("style", "display:block");


	

                var dataObj = JSON.parse(res);
                var percent = dataObj.upload_value;
                if(percent>=100){
                	percent=100;
                	stopWorker();
            }
                var progressBar = document.getElementById("progress_bar");
              
                returnValue=dataObj.upload_status;
                progressBar.setAttribute("style", "width:"+percent+"%");	
                progressBar.setAttribute("aria-valuenow", percent);	
                progressBar.innerHTML=percent+"%"
                
             
      
	  

}

function disableProgressBar(){
		var progressBarDiv = document.getElementById("progressBarHolder");
		progressBarDiv.setAttribute("style", "display:none");
	    progressBar.setAttribute("style", "width:0%");	
	    progressBar.setAttribute("aria-valuenow", percent);	
	    progressBar.innerHTML="0%"
	}
	



