console.log("hello web worker");
onmessage = function (e) {
    console.log('Message received from main script');
    console.log('Posting message back to main script');
    postMessage("I iam work ker");
    setInterval(count, 500);
}

function count() {
    var data;
    getUpdateProgress(function (data) {
        postMessage(data);
    })
}

function getUpdateProgress(callback) {
    var returnValue = 0;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            returnValue = this.responseText;
            console.log(returnValue);
            callback(returnValue);
        }
    };
    xhttp.open("GET", "/adminWeb/getUpdateData", true);
    xhttp.send();
}