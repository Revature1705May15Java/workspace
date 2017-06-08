/*
Javascript Homework
Due Friday @ 9PM
Put all homework in:
    ....Firstname_Lastname_Code/Week4/Javascript_Homework/

-----------------------------------------------------------------------------------

PART I

Create a single Javascript file called homework.js to answer these questions.
Please put the question itself as a comment above each answer.

-----------------------------------------------------------------------------------

1. Fibonacci

Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/

function fib(n) {
	if(n <= 0) {
		return -1;
	} 
	else if(n == 1) {
		return 0;
	}
	else if(n == 2) {
		return 1;
	}
	else{
		var a = 0; 
		var b = 1;
		var count = n - 2;
		
		while(count > 0) {
			var temp = a + b;
			a = b;
			b = temp;
			
			--count;
		}
		
		return b;
	}
}

function fibHelper() {
	var input = document.getElementById("fibInput").value;
	document.getElementById("fibResult").innerHTML = "Result: " + fib(input);
}

//document.getElementById("fib").innerHTML = fib(7);
document.getElementById("fibButton").addEventListener("click", fibHelper, false);

/*
2. Bubble Sort

Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/
var numArr = [];
function bubbleSort(arr) {
	for(var i = 0; i < arr.length; i++) {
		var swapped = false;
		
		for(var j = 0; j < arr.length; j++) {
			if(arr[j] > arr[j + 1]) {
				swapped = true;
				var temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
		
		if(swapped == false) {
			break;
		}
	}
	
	return arr;
}

function arrAppend(n) {
	var input = document.getElementById("bubInput").value;
	numArr.push(Number(input));
	document.getElementById("bubResult").innerHTML += input + " ";
}

function arrSort() {
	numArr = bubbleSort(numArr);
	var displayString = "";
	for(var i = 0; i < numArr.length; i++) {
		displayString += numArr[i] + " ";
	}
	document.getElementById("bubResult").innerHTML = displayString;
}

document.getElementById("bubAdd").addEventListener("click", arrAppend, false);
document.getElementById("bubSort").addEventListener("click", arrSort, false);

/*
3. Reverse String

Define function: reverseStr(someStr)
Reverse and return the String.
*/
function reverseStr(someStr) {
	var result = "";
	
	for(var i = someStr.length - 1; i >= 0; i--) {
		result += someStr[i];
	}
	
	return result;
}

function reverse() {
	var result = document.getElementById("revInput").value;
	result = reverseStr(result);
	document.getElementById("revResult").innerHTML = result;
}
document.getElementById("revButton").addEventListener("click", reverse, false);

//document.getElementById("reverse").innerHTML = reverseStr("Some String");
/*
4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
*/
function factorial(someNum) {
	if(someNum == 0) {
		return 1;
	}
	else{
		return someNum * factorial(someNum - 1);
	}
}

function factorialTrigger() {
	var result = Number(document.getElementById("factInput").value);
	result = factorial(result);
	document.getElementById("factResult").innerHTML = result;
}

document.getElementById("factButton").addEventListener("click", factorialTrigger, false);

/*
5. Substring

Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.
*/
function substring(someStr, length, offset) {
	var result = "";
	if((offset + length) >= someStr.length) {
		alert("Index out of bounds error. Please check your starting index and length...");
	}
	else {
		result = "";
		for(var i = offset; i < (offset + length); i++) {
			result += someStr[i];
		}		
	}
	
	return result;
}

function subTrigger() {
	var string = document.getElementById("subInput").value;
	var index = Number(document.getElementById("subIndex").value);
	var length = Number(document.getElementById("subLength").value);
	
	var result = substring(string, length, index);
	document.getElementById("subResult").innerHTML = result;
}

document.getElementById("subButton").addEventListener("click", subTrigger, false);

/*
6. Even Number

Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/
function isEven(someNum) {
	if((someNum & 1) == 1) {
		return false;
	}
	else {
		return true;
	}
}

function evenTrigger() {
	var input = Number(document.getElementById("evenInput").value);
	var result = isEven(input);
	
	var displayString = "" + input + " is ";
	
	if(result == true) {
		displayString += "even.";
	}
	else {
		displayString += "odd.";
	}
	
	document.getElementById("evenResult").innerHTML = displayString;
}

document.getElementById("evenButton").addEventListener("click", evenTrigger, false);

/*
7. Palindrome

Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
*/
function isPalindrome(someStr) {
	var result = true;
	
	for(var i = 0, j = someStr.length - 1; i < j && result; i++, j--) {
		if(someStr[i] != someStr[j]) {
			result = false;
		}
	}
	
	return result;
}

function palinTrigger() {
	var input = document.getElementById("palinInput").value;
	var result = isPalindrome(input);
	var displayString = input + " is ";
	
	if(result == true) {
		displayString += "a palindrome.";
	}
	else {
		displayString += " not a palindrome.";
	}
	
	document.getElementById("palinResult").innerHTML = displayString;
}

document.getElementById("palinButton").addEventListener("click", palinTrigger, false);

/*
8. Shapes

Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape. Assume this String contains just one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape.

Example for printShape("Square", 3, "%");

%%%
%%%
%%%

Example for printShape("Triangle", 3, "$");

$
$$
$$$

Example for printShape("Diamond", 5, "*");

  *
 ***
*****
 ***
  *
*/
function printShape(shape, height, character) {
	var line = "";
	var result = "";
	
	switch(shape) {
	case "Square":
		for(var i = 0; i < height; i++) {
			line += character;
		}
		for(var i = 0; i < height; i++) {
			result += line + "\n";
		}
		break;
	case "Triangle":
		for(var i = 0; i < height; i++) {
			line += character;
			result += line + "\n";
		}
		break;
	case "Diamond":
		for(var i = 0; i < height; i++) {
			line += character;
		}
		
		result = line + "\n";
		var tempLine = line;
		
		for(var i = 1, j = height - 1; i < j; i++, j--) {
			tempLine = tempLine.substr(0, tempLine.length - 2);
			line = "";
			for(var k = 0; k < i; k++) {
				line += " ";
			}
			line += tempLine;
			
			result = line + "\n" + result + line + "\n";
		}
		break;
	}
	
	console.log(result);	
}

function printShapeOnPage(shape, height, character) {
	var line = "";
	var result = "";
	
	switch(shape) {
	case "Square":
		for(var i = 0; i < height; i++) {
			line += character;
		}
		for(var i = 0; i < height; i++) {
			result += line + "<br>";
		}
		break;
	case "Triangle":
		for(var i = 0; i < height; i++) {
			line += character;
			result += line + "<br>";
		}
		break;
	case "Diamond":
		for(var i = 0; i < height; i++) {
			line += character;
		}
		
		result = line + "<br>";
		var tempLine = line;
		
		for(var i = 1, j = height - 1; i < j; i++, j--) {
			tempLine = tempLine.substr(0, tempLine.length - 2);
			line = "";
			for(var k = 0; k < i; k++) {
				line += "&nbsp;";
			}
			line += tempLine;
			
			result = line + "<br>" + result + line + "<br>";
		}
		break;
	}
		
	return result;
}

function shapeTrigger() {
	var height = Number(document.getElementById("heightInput").value);
	var character = document.getElementById("charInput").value;
	var shapes = document.getElementsByName("shapeRadio");
	var shape;
	
	for(var i = 0; i < shapes.length; i++) {
		if(shapes[i].checked) {
			shape = shapes[i].value;
		}
	}
	
	var displayString = printShapeOnPage(shape, height, character);
	
	document.getElementById("shapeResult").innerHTML = displayString;
}

document.getElementById("shapeButton").addEventListener("click", shapeTrigger, false);

/*
9. Object literal

Define function traverseObject(someObj)
Print every property and it's value.
*/
function traverseObject(someObj) {
	var result = "";
	
	for(var prop in someObj) {
		result += prop + " : " + someObj[prop] + "\n";
	}
	
	return result;
}

var animal = {
		'age' : 4,
		'name' : "Bobby",
		'location' : "In my hair!!!"
};

console.log(traverseObject(animal));


/*
10. Delete Element

Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.
*/
function deleteElement(someArr) {
	console.log(someArr.length);
	delete someArr[2];
	console.log(someArr.length);
}

var randomArr = [4, 33, 44, 2, 1, 8];
deleteElement(randomArr);

/*
11. Splice Element

Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.
*/
function spliceElement(someArr) {
	console.log(someArr.length);
	someArr.splice(2, 1);
	console.log(someArr.length);
}

spliceElement(randomArr);

/*
12. Defining an object using a constructor

Define a function Person(name, age)
The following line should set a Person object to the variable john:

    var john = new Person("John", 30);
*/
function Person(name, age) {
	var result = {
			'name' : name,
			'age' : age
	}
	
	return result;
}

document.getElementById("constructor").innerHTML = traverseObject(new Person("John", 30));

/*
13. Defining an object using an object literal

Define function getPerson(name, age)
The following line should set a Person object to the variable john:

    var john = getPerson("John", 30);
*/
function getPerson(name, age) {
	return new Person(name, age);
}

document.getElementById("person").innerHTML = traverseObject(getPerson("Barry", 22));

/*
-----------------------------------------------------------------------------------

PART II

Part II will focus on Javascript's ability to manipulate the DOM.
Use the provided index.html

Put your Javascript in the provided <script> element at the bottom of the page.
Please put the question itself as a comment above each answer.

NOTE: Part II will be done twice: once with Javascript and once with jQuery.

      They should be done separately.
      Copy the index.html file and rename them to: indexJavascript.html and indexJQuery.html

-----------------------------------------------------------------------------------

1. USA

Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
*/
function getUSA() {
	
}
/*
2. Sales

Define function getPeopleInSales()
Print the names of all the people in the sales department.

3. Click Here

Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>  

4. Hobbies

Define function getHobbies()
Find all checked options in the 'skills' select element.
Print the value and the contents.

5. Custom Attribute

Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.

6. Sum Event

NOTE: Write unobtrusive Javascript
Regarding these elements:

    <input id="num1" class="nums" type="text"/>

    <input id="num2" class="nums" type="text"/>

    <h3>Sum: <span id="sum"></span></h3>

Define onchange event handler.
Add <input> element values.
Put the sum in the <span> element.
If values cannot be added, put "Cannot add" in the <span> element

7. Skills Event

NOTE: Write unobtrusive Javascript
When user selects a skill, create an alert with a message similar to:

    "Are you sure CSS is one of your skills?"

NOTE: no alert should appear when user deselects a skill.

8. Favorite Color Event

NOTE: Write unobtrusive Javascript
NOTE: This is regarding the favoriteColor radio buttons.
When a user selects a color, create an alert with a message similar to:

    "So you like green more than blue now?"

In this example, green is the new value and blue is the old value.
Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor

9. Show/Hide Event

NOTE: Write unobtrusive Javascript
When user hovers over an employees name:
    Hide the name if shown.
    Show the name if hidden.

10. Current Time
Regarding this element:

    <h5 id="currentTime"></h5>

Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.

11. Delay
Regarding this element:
    <p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on this element, change the text to a random color.

12. Walk the DOM
Define function walkTheDOM(node, func)
This function should traverse every node in the DOM. Use recursion.
On each node, call func(node).
*/