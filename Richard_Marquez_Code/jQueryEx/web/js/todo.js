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
    $('#todoInput').keydown(function(e) {
        if (e.keyCode === 13) {
            addItem();
        }
    });

    $('#todoInputButton').click(addItem);
}

function addItem() {
    var gList = $('#todoList');
    var g = $('#todoInput');

    var li = $('<li class="hot">' + g.val() + '</li>');

    gList.append(li);
    g.val('');

    initList();
}
