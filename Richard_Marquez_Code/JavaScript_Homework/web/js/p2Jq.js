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
    var elems = document.body.getElementsByTagName("*");
    for (let i in elems) {
        if (elems[i].textContent === 'USA') {
            console.log(elems[i]);
            break;
        }
    }
}
// getUSA();



//     2. Sales
//     Define function getPeopleInSales()
//     Print the names of all the people in the sales department.
function getPeopleInSales() {
    var table = document.getElementById('salesTable');
    var rows = table.getElementsByTagName('tr');
    for (let row of rows) {
        var cols = row.childNodes;
        var name = cols[1].textContent;
        var dept = cols[3].textContent;
        if (dept === 'Sales') {
            console.log(name + ' works in Sales');
        }
    }
}
// getPeopleInSales();



//     3. Click Here
//     Define function getAnchorChildren()
//     Find all anchor elements with a <span> child.
//         Print the contents of <span>
function getAnchorChildren() {
    var anchors = document.getElementsByTagName('a');
    for (let a of anchors) {
        let spans = a.getElementsByTagName('span');
        if (spans.length > 0) {
            for (let s of spans) {
                console.log(s.textContent);
            }
        }
    }
}
// getAnchorChildren();



//     4. Hobbies
//     Define function getHobbies()
//     Find all checked options in the 'skills' select element.
//         Print the value and the contents.
function getHobbies() {
    var skills = document.getElementsByName('skills')[0];
    console.log(skills.value);
}
// getHobbies();




//     5. Custom Attribute
//     Define function getCustomAttribute()
//     Find all elements with "data-customAttr" attribute
//     Print the value of the attribute.
//         Print the element that has the attribute.
function getCustomAttribute() {
    var all = document.getElementsByTagName('*');

    for (let e of all) {
        if (e.hasAttribute('data-customAttr')) {
            console.log(e.getAttribute('data-customAttr'));
        }
    }
}
// getCustomAttribute();




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
var num1 = document.getElementById('num1');
var num2 = document.getElementById('num2');
var sum = document.getElementById('sum');
num1.value = 'NUM1';
num2.value = 'NUM2';
num1.onchange = updateSum;
num2.onchange = updateSum;
function updateSum() {
    var result = parseInt(num1.value) + parseInt(num2.value);
    if (Number.isNaN(result)) {
        sum.innerHTML = 'Cannot add';
    } else {
        sum.innerHTML = result;
    }
}




//     7. Skills Event
//     NOTE: Write unobtrusive Javascript
//     When user selects a skill, create an alert with a message similar to:
//         "Are you sure CSS is one of your skills?"
//     NOTE: no alert should appear when user deselects a skill.
var skillNode = document.getElementsByName('skills')[0];
skillNode.onchange = function() {
    confirm('Are you sure ' + skillNode.value + ' is one of your skills?');
};




//     8. Favorite Color Event
//     NOTE: Write unobtrusive Javascript
//     NOTE: This is regarding the favoriteColor radio buttons.
//         When a user selects a color, create an alert with a message similar to:
//         "So you like green more than blue now?"
//     In this example, green is the new value and blue is the old value.
//         Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
var colorInputs = document.getElementsByName('favoriteColor');
var newColor = 'green';
var oldColor = 'blue';
function resetColors() {
    for (let ci of colorInputs) {
        console.log('asdf');
        ci.style.backgroundColor = newColor;
        document.getElementsByTagName('body')[0] .style.backgroundColor = newColor;
    }
}

for (let ci of colorInputs) {
    ci.onclick = function() {
        oldColor = newColor;
        newColor = getFavoriteColor();
        alert('So you like ' + newColor + ' more than ' +
            oldColor + ' now?');

        resetColors();
    };
}
function getFavoriteColor() {
    for (let ci of colorInputs) {
        if (ci.checked) {
            return ci.value;
        }
    }
}




//     9. Show/Hide Event
//     NOTE: Write unobtrusive Javascript
//     When user hovers over an employees name:
//         Hide the name if shown.
//         Show the name if hidden.
var empNames = document.getElementsByClassName('empName');
for (let e of empNames) {
    e.onmouseover = function() {
        e.style.display = 'none';
    };
    e.onmouseout = function() {
        e.style.display = 'block';
    };
}



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
    document.getElementById('currentTime').innerHTML = dateStr;


}, 500);



//     11. Delay
//     Regarding this element:
//         <p id="helloWorld">Hello, World!</p>
//     Three seconds after a user clicks on this element, change the text to a random color.
var helloElem = document.getElementById('helloWorld');
helloElem.onclick = function() {
    setTimeout(function() {
        helloElem.style.color = getRandomColor();
    }, 3000);
};




//     12. Walk the DOM
//     Define function walkTheDOM(node, func)
//     This function should traverse every node in the DOM. Use recursion.
//         On each node, call func(node).
function walkTheDOM(node, func) {
    func(node);

    var children = node.childNodes;
    for (let c of children) {
        walkTheDOM(c, func);
    }
}
// walkTheDOM(document, function(node) { console.log(node); } );




function getRandomColor() {
    var letters = '0123456789ABCDEF'.split('');
    var color = '#';

    for (var i = 0; i < 6; i++ ) {
        color += letters[Math.floor(Math.random() * 16)];
    }

    return color;
}
