$(document).ready(function () {
    initScrollWatcher();
    initSmoothScroll();
});

// FROM W3SCHOOLS
function initSmoothScroll() {
// Add smooth scrolling to all links
    $("a").on('click', function (event) {

        // Make sure this.hash has a value before overriding default behavior
        if (this.hash !== "") {
            // Prevent default anchor click behavior
            event.preventDefault();

            // Store hash
            var hash = this.hash;

            // Using jQuery's animate() method to add smooth page scroll
            // The optional number (800) specifies the number of milliseconds it takes to scroll to the specified area
            $('html, body').animate({
                scrollTop: $(hash).offset().top
            }, 500, function () {

                // Add hash (#) to URL when done scrolling (default click behavior)
                window.location.hash = hash;
            });
        } // End if
    });
}

function initScrollWatcher() {
    $(window).scroll(function () {
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

    for (var i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }

    return color;
}
