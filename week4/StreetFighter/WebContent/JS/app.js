//is mouse on Ryu
var isHovered = false;
$(document).ready(function(){
    $('.ryu').mouseenter(function(){
        $('.ryu-still').hide();
        $('.ryu-ready').show();
        isHovered = true;
    })
    .mouseleave(function(){
        $('.ryu-still').show();
        $('.ryu-ready').hide();
        isHovered = false;
    })
    .mousedown(function(){
        playHadouken();
        $('.ryu-throwing').show();
        $('.ryu-ready').hide();
        $('.hadouken').finish().show().animate(
                {'left': '8.75rem'},
                280,
            function(){
                    $(this).hide();
                    $(this).css('left', '-10rem');
                });
        
    })
    .mouseup(function(){
        $('.ryu-throwing').hide();
        $('.ryu-ready').show();
    })
});
$(document).keydown(function(e){
    if(e.keyCode==88){
        playPose();
        $('.ryu-cool').show();
        $('.ryu-still').hide();
        $('.ryu-ready').hide();
    }
}) .keyup(function(e){
    $('#pose-sound')[0].pause();
    $('#pose-sound')[0].load();
    $('.ryu-cool').hide();
    if(isHovered){
        $('.ryu-ready').show();
    }else{
        $('.ryu-still').show();
    }
    
});
function playHadouken(){
    $('#hadouken-sound')[0].volume=0.2;
    $('#hadouken-sound')[0].load();
    $('#hadouken-sound')[0].play();
}
var playSound = false;
function playPose(){
    playSound = !playSound;
    if(playSound){
        $('#pose-sound')[0].volume=0.2;
        $('#pose-sound')[0].play();
    }
}