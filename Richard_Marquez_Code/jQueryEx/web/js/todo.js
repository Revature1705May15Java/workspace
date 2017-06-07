$(document).ready(function () {
    $('header').addClass('headline');

    initList();
    initButton();
});

function initList() {
    $('li.hot:lt(3)').hide().fadeIn(1500);

    $('.hot').click(function() {
        $(this).remove();
    });
}

function initButton() {
    $('#groceryInputButton').click(function() {
        var gList = $('#groceryList');
        var g = $('#groceryInput');

        var li = $('<li class="hot">' + g.val() + '</li>');

        gList.append(li);
        g.val('');

        initList();
    });
}
