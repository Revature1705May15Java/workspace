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

$('h1').on("click", getUSA);

function getUSA() {
	console.log($('h1').text());
}


/* 2. Sales
 * Define function getPeopleInSales()
 * Print the names of all the people in the sales department.
*/

$('#c2').on("click", getPeopleInSales);

function getPeopleInSales() {
	$('table tr').each(function() {
		if ($(':nth-child(2)', this).text() == "Sales")
			console.log($(':nth-child(1)', this).text());
	});
}


/* 3. Click Here
 * Define function getAnchorChildren()
 * Find all anchor elements with a <span> child.
 * Print the contents of <span>
*/

$('#c3').on("click", getAnchorChildren);

function getAnchorChildren() {
	$('a').each(function() {
		if ($(this).find('span').text() != "")
			console.log($(this).find('span').text());
	});
}


/* 4. Hobbies
 * Define function getHobbies()
 * Find all checked options in the 'hobbies' select element.
 * Print the value and the contents.
*/

$('#hobbies').change(getHobbies);

function getHobbies() {
	console.log($('option:selected', this).text());
}

/* 5. Custom Attribute
 * Define function getCustomAttribute()
 * Find all elements with "data-customAttr" attribute
 * Print the value of the attribute.
 * Print the element that has the attribute.
*/

$('#c4').click(getCustomAttribute);

function getCustomAttribute() {
	$('[data-customAttr]').each(function() {
		console.log("Value: " + $(this).text());
	});
}

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
$('.nums').change(getSum);

function getSum() {
	var num = parseInt($(this).val());
	if (isNaN(num))
		$('#sum').text("Cannot add");
	else {
		sum += num;
		$('#sum').text(sum);
	}
}


/* 7. Skills Event
 * NOTE: Write unobtrusive Javascript
 * When user selects a skill, create an alert with a message similar to:
 *	"Are you sure CSS is one of your skills?"
 * NOTE: no alert should appear when user deselects a skill.
*/

$("#skills").change(doSelect);

function doSelect() {
	var skill = $('option:selected', this).text();
	alert("Are you sure " + skill + " is one of your skills?");
}


/* 8. Favorite Color Event
 * NOTE: Write unobtrusive Javascript
 * NOTE: This is regarding the favoriteColor radio buttons.
 * When a user selects a color, create an alert with a message similar to:
 *	"So you like green more than blue now?"
 * In this example, green is the new value and blue is the old value.
 * Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
*/
var prev = "white";
$('[name="favoriteColor"]').change(displayAlert);

function displayAlert() {
	var color = $(this).val();
	alert("So you like " + color + " more than " + prev + " now?");
	$('.color').css("background-color", color);
	prev = color;
}


/* 9. Show/Hide Event
 * NOTE: Write unobtrusive Javascript
 * When user hovers over an employees name:
 *	Hide the name if shown.
 *	Show the name if hidden.
*/

$('.empName').hover(function() {
	$(this).fadeToggle("slow");
});


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
	$('#currentTime').html(date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + " " + p);
}, 1000);


/* 11. Delay
 * Regarding this element:
 *	<p id="helloWorld">Hello, World!</p>
 * Three seconds after a user clicks on this element, change the text to a random color.
*/

$('#helloWorld').click(changeColor);

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