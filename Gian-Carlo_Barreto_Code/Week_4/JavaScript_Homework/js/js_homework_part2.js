/*-----------------------------------------------------------------------------------
PART II
Part II will focus on Javascript's ability to manipulate the DOM.
Use the provided index.html
Put your Javascript in the provided <script> element at the bottom of the page.
Please put the question itself as a comment above each answer.
NOTE: Part II will be done twice: once with Javascript and once with jQuery.
	  They should be done separately.
	  Copy the index.html file and rename them to: indexJavascript.html and indexJQuery.html
-----------------------------------------------------------------------------------
*/

/* 1. USA
 * Define function getUSA()
 * Find the html element that contains "USA".
 * Print that element's contents.
*/
function getUSA() {
	var array = document.getElementsByTagName("H1");
	var str = array[0].innerHTML;
	console.log(str);
}

document.getElementById("c1").addEventListener("click", getUSA, false);


/* 2. Sales
 * Define function getPeopleInSales()
 * Print the names of all the people in the sales department.
*/

function getPeopleInSales() {
	var t = document.getElementById("table");
	var trs = t.getElementsByTagName("tr");
	var tds = null;
	var names = [];
	
	for (var i = 1; i < trs.length; i++)
	{
	    tds = trs[i].getElementsByTagName("td");
	    if (tds[1].innerHTML == "Sales")
	    	names.push(tds[0].innerHTML);
	}
	for (var n = 0; n < names.length; n++) 
		console.log("Name: " + names[n]);
}

document.getElementById("c2").addEventListener("click", getPeopleInSales, false);


/* 3. Click Here
 * Define function getAnchorChildren()
 * Find all anchor elements with a <span> child.
 * Print the contents of <span>
*/

function getAnchorChildren() {
	var anchors = document.getElementsByTagName("a");
	for (var i = 0; i < anchors.length; i++) {
		var childs = anchors[i].childNodes;
		for (var j = 0; j < childs.length; j++) {
			if (childs[j].nodeName == "SPAN")
				console.log("Span content: " + childs[j].innerHTML);
		}
	}
}

document.getElementById("c3").addEventListener("click", getAnchorChildren, false);

/* 4. Hobbies
 * Define function getHobbies()
 * Find all checked options in the 'hobbies' select element.
 * Print the value and the contents.
*/

function getHobbies() {
	var hobby = document.getElementById('hobbies').value;
	console.log("Hobbies: " + hobby);
}

document.getElementById("c4").addEventListener("click", getHobbies, false);

/* 5. Custom Attribute
 * Define function getCustomAttribute()
 * Find all elements with "data-customAttr" attribute
 * Print the value of the attribute.
 * Print the element that has the attribute.
*/

function getCustomAttribute() {
	var elements = document.querySelectorAll('[data-customAttr]');
	for (var i = 0; i < elements.length; i++) {
		console.log("Info: " + elements[i].innerHTML);
	}
}

document.getElementById("c5").addEventListener("click", getCustomAttribute, false);


/* 6. Sum Event
 * NOTE: Write unobtrusive Javascript
 * Regarding these elements:
 *	<input id="num1" class="nums" type="text"/>
 *	<input id="num2" class="nums" type="text"/>
 *	<h3>Sum: <span id="sum"></span></h3>
 * Define onchange event handler.
 * Add <input> element values.
 * Put the sum in the <span> element.
 * If values cannot be added, put "Cannot add" in the <span> element
*/

var sum = 0;
var inputs = document.getElementsByClassName("nums");

for (var i = 0; i < inputs.length; i++) {
	inputs[i].addEventListener("change", getSum, false);
}

// Gets the number from the input field, adds the number to sum
// and displays the sum in the appropriate span element
function getSum() {
	var num = parseInt((this).value);
	if (isNaN(num))
		document.getElementById("sum").innerHTML = "Cannot add";
	else {
		sum += num;
		document.getElementById("sum").innerHTML = sum;
	}
}


/* 7. Skills Event
 * NOTE: Write unobtrusive Javascript
 * When user selects a skill, create an alert with a message similar to:
 *	"Are you sure CSS is one of your skills?"
 * NOTE: no alert should appear when user deselects a skill.
*/

var mySelect = document.getElementById("skills");

mySelect.addEventListener("change", doSelect, false);

function doSelect() {
	var text = (this).options[this.selectedIndex].text;
	alert("Are you sure " + text + " is one of your skills?");
}


/* 8. Favorite Color Event
 * NOTE: Write unobtrusive Javascript
 * NOTE: This is regarding the favoriteColor radio buttons.
 * When a user selects a color, create an alert with a message similar to:
 *	"So you like green more than blue now?"
 * In this example, green is the new value and blue is the old value.
 * Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
*/

var colors = document.getElementsByName("favoriteColor");
var prevColor = "white";

for (var i = 0; i < colors.length; i++) {
	colors[i].addEventListener("change", displayAlert, false);
}

function displayAlert() {
	var color = (this).value;

	alert("So you like " + color + " more than " + prevColor + " now?");
	//document.body.style.backgroundColor = color;
	var c = document.getElementsByClassName("color");
	for (var i = 0; i < c.length; i++) {
		c[i].style.backgroundColor = color;
	}
	prevColor = color;
}


/* 9. Show/Hide Event
 * NOTE: Write unobtrusive Javascript
 * When user hovers over an employees name:
 *	Hide the name if shown.
 *	Show the name if hidden.
*/

var emps = document.getElementsByClassName("empName");

for (var i = 0; i < emps.length; i++) {
	emps[i].addEventListener("mouseover", doHover, false);
	emps[i].addEventListener("mouseout", doOut, false);
}

function doHover() {
	this.style.visibility = 'hidden';
}

function doOut() {
	this.style.visibility = 'visible';
}


/* 10. Current Time
 * Regarding this element:
 *	<h5 id="currentTime"></h5>
 * Show the current time in this element in this format: 9:05:23 AM
 * The time should be accurate to the second without having to reload the page.
*/

setInterval(function() {
	var date = new Date();
	var p = "AM";
	if (date.getHours() >= 12)
		p = "PM";
	document.getElementById("currentTime").innerHTML = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + " " + p;
}, 1000);


/* 11. Delay
 * Regarding this element:
 *	<p id="helloWorld">Hello, World!</p>
 * Three seconds after a user clicks on this element, change the text to a random color.
*/

document.getElementById("helloWorld").addEventListener("click", changeColor, false);

function changeColor() {
	var ele = (this);
	setTimeout(function() {
		var hue = 'rgb(' + (Math.floor(Math.random() * 256)) + ',' 
					+ (Math.floor(Math.random() * 256)) + ',' 
					+ (Math.floor(Math.random() * 256)) + ')';
		ele.style.color = hue;
	}, 3000);
}

/*12. Walk the DOM
Define function walkTheDOM(node, func)
This function should traverse every node in the DOM. Use recursion.
On each node, call func(node).
*/

function walkTheDom(node, func) {
	// I do not know how to do this
}