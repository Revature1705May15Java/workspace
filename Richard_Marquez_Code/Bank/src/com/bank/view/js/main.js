$(document).ready(function() {
  initScrollWatcher();
  initSections();
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

function initSections() {
  $('section').each(function() {
      //$(this).css('background-color', getRandomColor()+""+"ff");
      $(this).css('background-color', getRandomRGBA(.18));
  });
}

function getRandomRGBA(alpha) {
    var rand1 = Math.floor(Math.random() * 200) + 55;
    var rand2 = Math.floor(Math.random() * 200) + 55;
    var rand3 = Math.floor(Math.random() * 200) + 55;
    var rgba = 'rgba(' + rand1 + ',' + rand2 + ',' + rand3 + ',' + alpha + ')';

    return rgba;
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
