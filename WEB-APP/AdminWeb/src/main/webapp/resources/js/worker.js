function getUpdateProgress(){
	
	var progressBarDiv = document.getElementById("progressBarHolder");
	progressBarDiv.setAttribute("style", "display:block");
  var returnValue=0;

	$.ajax({
            url: "/adminWeb/getUpdateData",
            type: 'GET',
            success: function(res) {
                console.log(res);

                var dataObj = JSON.parse(res);
                var percent = dataObj.upload_value;
                var progressBar = document.getElementById("progress_bar");
              
                returnValue=dataObj.upload_status;
                progressBar.setAttribute("style", "width:"+percent+"%");	
                progressBar.setAttribute("aria-valuenow", percent);	
                progressBar.innerHTML=percent+"%"
                
                if(percent>=100){
                	percent=100;	
            }
              returnValue=percent;
             
            }
        });
	     return returnValue;

}

console.log("hello web worker");

this.onmessage = function(event) {
	console.log(event.data);
    postMessage("Reply from web worker");
}

