
$('.btn-loading').on('click', function() {
    var $this = $(this);
    var photoSceneName= $('#photoSceneName').val();
    if (photoSceneName == "") {
        alert('asda');
    } else {
    	 $this.button('loading');
    }
 
 //   setTimeout(function() {
//       $this.button('reset');
//   }, 8000);
});

$('#close').on('click', function() {
    $('.btn').button('reset');
});



