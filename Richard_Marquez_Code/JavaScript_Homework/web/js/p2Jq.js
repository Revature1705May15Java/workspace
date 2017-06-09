
//     -----------------------------------------------------------------------------------
//         PART II
//     Part II will focus on Javascript's ability to manipulate the DOM.
//     Use the provided indexJs.html
//     Put your Javascript in the provided <script> element at the bottom of the page.
//         Please put the question itself as a comment above each answer.
//         NOTE: Part II will be done twice: once with Javascript and once with jQuery.
//         They should be done separately.
//         Copy the indexJs.html file and rename them to: indexJavascript.html and indexJQuery.html
//     -----------------------------------------------------------------------------------
//         1. USA
//     Define function getUSA()
//     Find the html element that contains "USA".
//         Print that element's contents.
function getUSA() {
    $('*:contains("USA")').each(function() {
        if (this.innerHTML === 'USA') {
            console.log($(this).html());
        }
    });
}
getUSA();



//     2. Sales
//     Define function getPeopleInSales()
//     Print the names of all the people in the sales department.
function getPeopleInSales() {
    $('#salesTable tr').each(function() {
        var cols = this.childNodes;
        var name = cols[1].textContent;
        var dept = cols[3].textContent;
        if (dept === 'Sales') {
            console.log(name + ' works in Sales');
        }
    });
}
getPeopleInSales();



//     3. Click Here
//     Define function getAnchorChildren()
//     Find all anchor elements with a <span> child.
//         Print the contents of <span>
function getAnchorChildren() {
    $('a').children('span').each(function() {
        console.log($(this).html());
    });
}
getAnchorChildren();



//     4. Hobbies
//     Define function getHobbies()
//     Find all checked options in the 'skills' select element.
//         Print the value and the contents.
function getHobbies() {
    console.log($('[name="skills"]')[0].value);
}
getHobbies();



//     5. Custom Attribute
//     Define function getCustomAttribute()
//     Find all elements with "data-customAttr" attribute
//     Print the value of the attribute.
//         Print the element that has the attribute.
function getCustomAttribute() {
    $('*[data-customAttr]').each(function() {
        console.log(this.getAttribute('data-customAttr'));
        }
    );
}
getCustomAttribute();




//     6. Sum Event
//     NOTE: Write unobtrusive Javascript
//     Regarding these elements:
//         <input id="num1" class="nums" type="text"/>
//         <input id="num2" class="nums" type="text"/>
//         <h3>Sum: <span id="sum"></span></h3>
//         Define onchange event handler.
//         Add <input> element values.
//         Put the sum in the <span> element.
//         If values cannot be added, put "Cannot add" in the <span> element

$('#num1').on('change', updateSum);
$('#num2').on('change', updateSum);
$('#num1').val('NUM1');
$('#num2').val('NUM2');

function updateSum() {
    var result = parseInt($('#num1').val()) + parseInt($('#num2').val());
    if (Number.isNaN(result)) {
        $('#sum').html('Cannot add');
    } else {
        $('#sum').html(result);
    }
}

//     7. Skills Event
//     NOTE: Write unobtrusive Javascript
//     When user selects a skill, create an alert with a message similar to:
//         "Are you sure CSS is one of your skills?"
//     NOTE: no alert should appear when user deselects a skill.

$('[name="skills"]').on('change', function() {
    confirm('Are you sure ' + this.value + ' is one of your skills?');
});



//     8. Favorite Color Event
//     NOTE: Write unobtrusive Javascript
//     NOTE: This is regarding the favoriteColor radio buttons.
//         When a user selects a color, create an alert with a message similar to:
//         "So you like green more than blue now?"
//     In this example, green is the new value and blue is the old value.
//         Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
var newColor = 'green';
var oldColor = 'blue';
function resetColors() {
    $('[name="favoriteColor"]').css('background-color', newColor);
    $('body').css('background-color', newColor);
}
$('[name="favoriteColor"]').click(function() {
    oldColor = newColor;
    newColor = $('input[name="favoriteColor"]:checked').val();

    alert('So you like ' + newColor + ' more than ' +
        oldColor + ' now?');

    resetColors();
});



//     9. Show/Hide Event
//     NOTE: Write unobtrusive Javascript
//     When user hovers over an employees name:
//         Hide the name if shown.
//         Show the name if hidden.
$('.empName').mouseover(function() {
    $(this).css('display', 'none');
}).mouseout(function() {
    $(this).css('display', 'block');
});



//         10. Current Time
//     Regarding this element:
//         <h5 id="currentTime"></h5>
//         Show the current time in this element in this format: 9:05:23 AM
//     The time should be accurate to the second without having to reload the page.

setInterval(function() {
    var today = new Date();
    var hours = today.getHours();
    var period = 'AM';
    if (hours > 12) {
        hours -= 12;
        period = 'PM';
    }

    var dateStr = hours + ":" + today.getMinutes() + ":" + today.getSeconds() + period;
    $('#currentTime').html(dateStr);
}, 500);



//     11. Delay
//     Regarding this element:
//         <p id="helloWorld">Hello, World!</p>
//     Three seconds after a user clicks on this element, change the text to a random color.
$('#helloWorld').click(function() {
    setTimeout(function() {
        $('#helloWorld').css('color', getRandomColor());
    }, 3000);
});



//     12. Walk the DOM
//     Define function walkTheDOM(node, func)
//     This function should traverse every node in the DOM. Use recursion.
//         On each node, call func(node).
function walkTheDOM(node, func) {
    func(node);

    var children = node.children().each(function() {
        walkTheDOM($(this), func);
    });
}
walkTheDOM($(document), function(node) { console.log(node); } );




function getRandomColor() {
    var letters = '0123456789ABCDEF'.split('');
    var color = '#';

    for (var i = 0; i < 6; i++ ) {
        color += letters[Math.floor(Math.random() * 16)];
    }

    return color;
}
