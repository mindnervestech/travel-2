(function( $ ) {
	$.sectionloader_options = {
		
	};
	
  $.fn.sectionloader = function() {
	 
    this.find('[data-sectionloader]').each(function(){
		var $_this = $(this);
		var _url = $_this.attr('data-loaderurl');
		var _remote = $_this.attr('data-remote');
		var _server_script = $_this.attr('data-server-script');
		var _local_script = $_this.attr('data-local-script');
		$_this.mask("Loading...");
		//if(_remote == 'true'){
			$_this.load(_url,function(){
				
				if(typeof _server_script != "undefined"){
					$.getScript(_server_script, function(scriptFromServer){
						
						if(typeof _local_script != "undefined"){
							$.getScript(_local_script,function(scriptFromLocal){
								
							});
						}
					});
				}else{
					if(typeof _local_script != "undefined"){
						$.getScript(_local_script,function(scriptFromLocal){
							
						});
					}
				}
				//$_this.unmask();
			});
		//}
	});

  };
  $(function(){
	  $('body').sectionloader(); 
  });
})( jQuery ); 