/*Javascript Homework
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
Return the nth number in the fibonacci sequence.*/
var answer;
function fib(n){
	 if (n <= 1) {
	        return 0;
	    }
	 else if(n<=3){
		 return 1;
	 }else {
	        return fib(n - 2) + fib(n - 1);
	    }
}
function add(){
	var input = document.getElementById("fib").value;
	answer = fib(input);
	console.log("ans: " + answer);
	document.getElementById("fibAnswer").innerHTML = answer;
}
document.getElementById("calculate").addEventListener("click", add, false);


/*2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/
function bubbleSort(numArray){
	for (let i = 0; i < numArray.length; i++) {
        for (let j = 0; j < numArray.length-1; j++) {
            if (numArray[j] > numArray[j+1]) {
                let tmp = numArray[j];
                numArray[j] = numArray[j+1];
                numArray[j+1] = tmp;
            }
        }

    }

    return numArray;
}
function sort(){
	var input = document.getElementById("num").value;
	var s = input.split(" ");
	var sorted = bubbleSort(s);
	document.getElementById("bubsort").innerHTML = sorted;
}
document.getElementById("sort").addEventListener("click", sort, false);
/*3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.*/
function reverseStr(someStr){
	var newStr = "";
	for (var i = someStr.length - 1; i >=0; i--){
		newStr += someStr[i];
	}
	return newStr;
}
function reverse(){
	var reverse = document.getElementById("iStr").value;
	var reversed = reverseStr(reverse);
	document.getElementById("r").innerHTML = reversed;
}
document.getElementById("reverse").addEventListener("click", reverse, false);
/*
4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.*/
function factorial(someNum){
	var factNum;
	if(someNum==1){
		return 1;
	}
	factNum = factorial(someNum-1) * someNum;
	return factNum;
}
function compute(){
	var factInput = document.getElementById("iFact").value;
	var factResult = factorial(factInput);
	document.getElementById("fact").innerHTML = factResult;
}
document.getElementById("comFact").addEventListener("click",compute,false);

/*
5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.

6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.*/
function isEven(someNum){
	if(someNum & 1){
		return false;
	}
	else{
		return true;
	}
}
function isIt(){
	var evenInput = document.getElementById("iEven").value;
	var numEven = isEven(evenInput);
	document.getElementById("eResult").innerHTML = numEven;
}
document.getElementById("isItEven").addEventListener("click", isIt, false);
/*
7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false*/
function isPalindrome(someStr){
	/* remove special characters, spaces and make lowercase*/
	var removeChar = someStr.replace(/[^A-Z0-9]/ig, "").toLowerCase();

	/* reverse removeChar for comparison*/
	var checkPalindrome = removeChar.split('').reverse().join('');

	/* Check to see if myString is a Palindrome*/
	if(removeChar === checkPalindrome){
	  
	  return true;
	}else{
	  
	  return false;
	}
}
function runPalindrome(){
	var pInput = document.getElementById("pWord").value;
	var pResult = isPalindrome(pInput);
	document.getElementById("pResult").innerHTML = pResult;
}
document.getElementById("pCheck").addEventListener("click", runPalindrome, false);
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
  * */
function printShape(shape, height, character){
	switch(shape){
	case("triangle"):
	for(var n =character; n.length <= height; n += character) {
		console.log(n);
		}
	break;
	case("square"):
		var p = "";
		for(var i = 0; i<height;i++){
			for(var j = 0; j<height; j++){
				p += character;
				
			}
			console.log(p);
			p = "";
		}
	break;
	case("diamond"):
		var space = height;
    for (i = 1; i <= height; i++) {
        for (j = 1; j <= space; j++) {
            
        }
        space--;
        for (j = 1; j <= 2 * i - 1; j++) {
            console.log(character);
        }
        console.log('<br>');
    }

    space = 2;
    for (i = 1; i <= height; i++) {
        for (j = 1; j <= space; j++) {
            
        }
        space++;
        for (j = 1; j <= 2 * (height - i) - 1; j++) {
            console.log(character);
        }
       console.log('<br>');
    }
    break;
	}
}
function printS(){
	var shape = document.getElementById("shape").value;
	var height = document.getElementById("height").value;
	var char = document.getElementById("make").value;
	printShape(shape, height, char);
	document.getElementById("consoleCheck").innerHTML = "Check Console";
}
document.getElementById("printShape").addEventListener("click", printS, false);
/*
9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.*/
function traverseObject(someObj){
	
}
function traverse(){
	
	
}
/*
10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.
11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.
12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
    var john = new Person("John", 30);
13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
    var john = getPerson("John", 30);
 
 
 
 
 
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