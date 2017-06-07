let isHovered = false;
let playSound = false;

$(document).ready(function() {
  $('.ryu').mouseenter(function() {
    $('.ryu-still').hide();
    $('.ryu-ready').show();
    isHovered = true;
  }).mouseleave(function() {
    $('.ryu-ready').hide();
    $('.ryu-still').show();
    isHovered = false;
  }).mousedown(function() {
    playHadouken();
    $('.ryu-throwing').show();
    $('.ryu-ready').hide();
    $('.hadouken').finish().show().animate(
      {'left': '8.75rem'}, // starting location
      280, //animation time in ms
      function() {
        $(this).hide(); //hide original location
        $(this).css('left', '-10rem');
      }
    );
  }).mouseup(function() {
    $('.ryu-throwing').hide();
    $('.ryu-ready').show();
  });
});

$(window).keydown(function(e) {
  if (e.keyCode == 32) {
    playPose();
    $('.ryu-cool').show();
    $('.ryu-still').hide();
    $('.ryu-ready').hide();
    $('.ryu-throwing').hide();
  }
}).keyup(function(e) {
  if (e.keyCode == 80) {
    $('#pose-sound')[0].pause();
    $('#pose-sound')[0].load();
    $('.ryu-cool').hide();
    if (isHovered==true) {
      $('.ryu-ready').show();
    } else {
      $('.ryu-still').show();
    }
  }
});

function playHadouken() {
  $('#hadouken-sound')[0].volume = 0.2;
  $('#hadouken-sound')[0].load();
  $('#hadouken-sound')[0].play();
}

function playPose() {
  playSound = !playSound;
  if(playSound) {
    $('#pose-sound')[0].volume = 0.2;
    $('#pose-sound')[0].play();
  }
}