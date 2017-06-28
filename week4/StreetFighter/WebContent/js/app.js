//is mouse over Ryu?
var isHovered=false;
$(document).ready(function(){
	
	$('.ryu').mouseenter(function(){
		$('.ryu-still.hide()');
		$('.ryu-ready').show();
		isHovered=true;
	})
	
	.mouseleave(function(){
		$('.ryu-still').show();
		$('ryu-ready').hide();
		isHovered=false;
	})
	
	.mousedown(function(){
		playHoudoken();
		$('ryu-throwing').show();
		$('ryu-ready').hide();
		$('.hadouken').finish().show().animate(
				{'left':'8.75rem'},
				280,
				function(){
					$(this).hide();
					$(this).css('left','-10rem');
				});
	});
	
	
});