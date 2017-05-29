$(document).ready(function() {
  initScrollWatcher();
});

function initScrollWatcher() {
  $(window).scroll(function() {
    if ($(window).scrollTop() <= 20) {
      $('nav').css('opacity', '0');
    } else {
      $('nav').css('opacity', '1');
    }
  });
}

// Get random 6-digit hex color e.g. "#a82df1"
function getRandomColor() {
  var letters = '0123456789ABCDEF'.split('');
  var color = '#';

  for (var i = 0; i < 6; i++ ) {
    color += letters[Math.floor(Math.random() * 16)];
  }

  return color;
}
