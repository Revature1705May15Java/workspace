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
	var a = 1, b = 0, temp;
	
	while(n > 0) {
		temp = a;
		a = a + b;
		b = temp;
		n--;
	}
	return b;
}

function doFib(){
	var display = document.getElementById("fib");
	var input = document.getElementById("fibNum").value;
	display.innerHTML = fib(input);
}

document.getElementById("doFib").addEventListener("click", doFib, false);

//elem = document.getElementById("fib");
//elem.innerHTML=fib(4);

// OR use...
//document.getElementById("fib").innerHTML = fib(4);
//var x = fib(5);
//elem.appendChild(x);

/*
2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/
function bubble(numArray){
	var swap = true;
	do{
		swap=false;
		for(i = 1; i < numArray.length; i++){
			if(numArray[i-1] > numArray[i]){
				var temp = numArray[i-1];
				numArray[i-1] = numArray[i];
				numArray[i] = temp;
				swap = true;
			}
		}
	} while(swap);
	return numArray;
}

function doSort(){
	var display = document.getElementById("sort");
	var input = document.getElementById("sortNum").value;
	var myArray = bubble(input);
	for(i = 0; i < myArray.length; i++) {
		display.innerHTML = myArray[i];
	}
}

document.getElementById("doSort").addEventListener("click", doSort, false);

//document.getElementById("bubble").innerHTML = bubble((1,1,7,8,5,6,9,2,2));

/*
3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
*/
function reverseStr(someStr){
	var temp = "";
	for(i = someStr.length; i > 0; i--) temp += someStr.charAt(i-1);
	
	return temp;
}



/*
4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
*/
function factorial(someNum){
	var result = 1;
	var length = someNum;
	
	for(i = 0; i < length; i++) result *= someNum--;

	return result;
}


/*
5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.
*/
function substring(someStr, length, offset){
	var temp = "";
	
	for(i = offset; i < offset+length; i++) temp += someStr.charAt(i);
	
	return temp;
}



/*
6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/
function isEven(someNum) {
	var temp = someNum%2;
	if(temp == 0) return true;
	return false;
}




/*
7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
*/
function isPalindrome(someStr){
	var temp = someStr.split("").reverse().join("");
	if(temp===someStr) return true;
	return false;
}

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
function printShape(shape, height, character){
	if(shape=="Square" || shape=="square"){
		var text = "";
		for (i = 0; i < height; i++) { 
			for (j = 0; j < height; j++) { 
			    text += character;
			}
			text += "<br>";
		}
		document.write(text);
	}
	if(shape=="Triangle" || shape=="triangle"){
		var text = "";
		for (i = 1; i <= height; i++) { 
			for (j = 0; j < i; j++) { 
			    text += character;
			}
			text += "<br>";
		}
		document.write(text);
	}
	if(shape=="Diamond" || shape=="diamond"){
	    var i, s;
	    
	    // top: 1 to n
	    document.write("<pre>");
	    for(i = 1; i <= height; ++i )
	    {
	        // write n-i spaces:
	        for ( s = 1; s <= height-i; ++s )
	        {
	            document.write(" ");
	        }
	        // then write i asterisk+space sets:
	        for ( s = 1; s <= i; ++s )
	        {
	            document.write(character + " ");
	        }
	        document.write("\n");
	    }
	    // bottom: n-1 down to 1
	    for(i = height-1; i >= 1; --i )
	    {
	        // write n-i spaces:
	        for ( s = 1; s <= height-i; ++s )
	        {
	            document.write(" ");
	        }
	        // then write i asterisk+space sets:
	        for ( s = 1; s <= i; ++s )
	        {
	            document.write(character + " ");
	        }
	        document.write("\n");
	    }
	    document.write("</pre>");
	}
}



/*
9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.
*/
function traverseObject(someObj){
	var propValue;
	for(var propName in someObj) {
	    propValue = someObj[propName]

	    document.write(propName + ": " + propValue + "<br>")
	}
}



/*
10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.
*/
function deleteElement(someArr){
	document.write("<br>" + "Length Before Delete: " + someArr.length);
	delete someArr[3];
	document.write("<br>" + "Length After Delete: " + someArr.length + "<br>");
	
}



/*
11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.
*/
function spliceElement(someArr){
	document.write("<br>" + "Length Before Delete: " + someArr.length);
	someArr.splice(2,1);
	document.write("<br>" + "Length After Delete: " + someArr.length + "<br>");
}



/*
12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
	var john = new Person("John", 30);
*/
function Person(name, age){
	this.name = name;
	this.age = age;
}

/*
13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
	var john = getPerson("John", 30);
*/
function getPerson(name, age){
	this.name = name;
	this.age = age;
}




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