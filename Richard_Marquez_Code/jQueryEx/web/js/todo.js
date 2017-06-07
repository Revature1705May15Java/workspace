$(document).ready(function () {
    $('header').addClass('headline');

    // $('li.hot:lt(3)').hide().fadeIn(1500);

    initList();
    initButton();
});

function initList() {
    //reset onclick
    $('.hot').prop('onclick',null).off('click');

    $('.hot').click(function() {
        let el = $(this);

        var li = $('<li class="hot">' + el.html() + '</li>');

        $('#todoneList').append(li);
        $(this).remove();
    });
}

function initButton() {
    $('#todoInputButton').click(function() {
        var gList = $('#todoList');
        var g = $('#todoInput');

        var li = $('<li class="hot">' + g.val() + '</li>');

        gList.append(li);
        g.val('');

        initList();
    });
}
