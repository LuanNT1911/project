var form = document.getElementById('uploadForm');
var fileSelect = document.getElementById('input_upload');
var uploadButton = document.getElementById('btn_upload');
console.log('test');
form.onsubmit = function (event) {
        event.preventDefault();
        var valueID = document.getElementById("rq_id").innerHTML;
        console.log(valueID);
        // Get the selected files from the input.
        var files = fileSelect.files;
        var formData = new FormData();
        for (var i = 0; i < files.length; i++) {
            var file = files[i];
            formData.append('file', file, file.name);
        }
        if (files.length == 0) {
            return;
        }
        else {
            fileSelect.value = "";
        }
        formData.append("_id", valueID);
        var xhr = new XMLHttpRequest();
        xhr.open('POST', form.getAttribute("action"), true);
        // Set up a handler for when the request finishes.
        startWorker();
        uploadButton.innerHTML = 'Uploading...';
        xhr.onload = function () {
            if (xhr.status === 200) {
                uploadButton.innerHTML = 'Re-upload';
                alert("Upload files successful!");
                
                new PNotify({
                    title: 'Regular Success',
                    text: 'That thing that you were trying to do worked!',
                    type: 'success',
                    styling: 'bootstrap3'
                });
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

function startWorker() {
    if (typeof (w) == 'undefined') {
        w = new Worker("/adminWeb/resources/js/worker.js");
    }
    w.postMessage("hello");
    w.onmessage = function (e) {
        console.log(e.data);
        getUpdateProgress(e.data);
        console.log('Message received from worker');
    };
};

function stopWorker() {
    w.terminate();
    w = undefined;
}

function getUpdateProgress(res) {
    var progressBarDiv = document.getElementById("progressBarHolder");
    progressBarDiv.setAttribute("style", "display:block");
    var dataObj = JSON.parse(res);
    var percent = dataObj.upload_value;
    if (percent >= 100) {
        percent = 100;
        stopWorker();
    }
    var progressBar = document.getElementById("progress_bar");
    returnValue = dataObj.upload_status;
    progressBar.setAttribute("style", "width:" + percent + "%");
    progressBar.setAttribute("aria-valuenow", percent);
    progressBar.innerHTML = percent + "%"
}

function disableProgressBar() {
    var progressBarDiv = document.getElementById("progressBarHolder");
    var progressBar = document.getElementById("progress_bar");
    progressBarDiv.setAttribute("style", "display:none");
    progressBar.setAttribute("style", "width:0%");
    progressBar.innerHTML = "0%"
}