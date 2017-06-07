var isHovered = false;

$(document).ready(function () {
    initHoverWatcher();
    initKeyWatcher();
    initClickWatcher();
});

function initHoverWatcher() {
    $('.ryu').mouseenter(function() {
        isHovered = true;

        $('.ryu-still').hide();
        $('.ryu-ready').show();
    }).mouseleave(function() {
        isHovered = false;

        $('.ryu-ready').hide();
        $('.ryu-still').show();
    });
}

function initClickWatcher() {
    $('.ryu').mousedown(function() {
        playHadoken();
        $('.ryu-throwing').show();
        $('.ryu-ready').hide();
        $('.hadouken').finish().show().animate(
            {'left':'8.75rem'},
            280,
            function() {
                $(this).hide();
                $(this).css('left', '-10rem');
            }
        );
    }).mouseup(function() {
        $('.ryu-throwing').hide();
        $('.ryu-ready').show();
    });
}

// pose on 'p'
// hadoken on 'h'
function initKeyWatcher() {
    $(window).keydown(function (event) {
        if (event.keyCode === 80) {
            playPose();
            $('.ryu-cool').show();
            $('.ryu-ready').hide();
            $('.ryu-still').hide();
        }
    }).keyup(function (event) {
        if (event.keyCode === 80) {
            $('#pose-sound')[0].pause();
            $('#pose-sound')[0].load();

            $('.ryu-cool').hide();
            if (isHovered) {
                $('.ryu-ready').show();
            } else {
                $('.ryu-still').show();
            }
        }
    });
}

function playHadoken() {
    $('#hadouken-sound')[0].volume=0.8;
    $('#hadouken-sound')[0].load();
    $('#hadouken-sound')[0].play();
}

var playSound = false;
function playPose() {
    playSound = !playSound;
    if (playSound) {
        $('#pose-sound')[0].volume=0.8;
        $('#pose-sound')[0].play();
    }
}
