//Javascript Homework
//Due Friday @ 9PM
//Put all homework in:
//	....Firstname_Lastname_Code/Week4/Javascript_Homework/
//-----------------------------------------------------------------------------------
//PART I
//Create a single Javascript file called homework.js to answer these questions.
//Please put the question itself as a comment above each answer.
//-----------------------------------------------------------------------------------
//1. Fibonacci
//Define function: fib(n) 
//Return the nth number in the fibonacci sequence.
function fib(n){
	
	
	if(n == 0)
		return 0;
	else if(n ==1)
		return 1;
	else
		return fib(n-1)+fib(n-2);

}

//elem = document.getElementById("fib");
//elem.innerHTML=fib(4);

function doFib(){
	var display = document.getElementById("fibDisplay");
	var input = document.getElementById("fibNum").value;
	display.innerHTML = fib(input);
}


document.getElementById("doFib").addEventListener("click", doFib, false);

//var x = document.getElementByClass("examples");
//x.appendChild("hallo");
//document.getElementById("fib").innerHTML = fib(4);


//2. Bubble Sort
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort the array.
//Return the sorted array.
function bubbleSort(numArray){
	var i,j;
	var temp = 0;
	for(i = 0; i <numArray.length-1; i++){
		for (j = 0; j<numArray.length-1; j++){
			if(numArray[j+1]<numArray[j]){
				temp = numArray[j+1];
				numArray[j+1] = numArray[j];
				numArray[j] = temp;
			}
		}
	}
	return numArray;
}

function doBSort(){
	var display = document.getElementById("bSortDisplay");
	var input = document.getElementById("bSort").value;
	var i = input.split(",");
	var o = bubbleSort(i).toString();
	
	display.innerHTML = o;
}

document.getElementById("doBSort").addEventListener("click", doBSort, false);



//3. Reverse String
//Define function: reverseStr(someStr)
//Reverse and return the String.


function reverseStr(someStr){
	var s = someStr.split("");
	var reverse = s.reverse();
	var join = reverse.join("");
	return join;

}

function doReverse(){
	var display = document.getElementById("reverseDisplay");
	var input = document.getElementById("reverse").value;

	
	display.innerHTML = reverseStr(input);
}

document.getElementById("doReverse").addEventListener("click", doReverse, false);



//4. Factorial
//Define function: factorial(someNum)
//Use recursion to compute and return the factorial of someNum.


function factorial(someNum){
	var result=1;
	if(someNum==0||someNum==1){
		return result;
	}
	for(var i=1; i<=someNum; i++){
		result = result*i;
	}
	return result;
}

function doFactorial(){
	var display = document.getElementById("factorialDisplay");
	var input = document.getElementById("factorial").value;

	
	display.innerHTML = factorial(input);
}

document.getElementById("doFactorial").addEventListener("click", doFactorial, false);
//5. Substring
//Define function substring(someStr, length, offset)
//Return the substring contained between offset and (offset + length) inclusively.
//If incorrect input is entered, use the alert function and describe why the input was incorrect.


function substring(someString, length, offset){
	if(offset>=someString.length || offset<0){
		alert("offset out of boundry!!");
	}
	if((length+offset)>=someString.length || offset<0){
		alert("length out of boundry!!");
	}
	return someString.substr(offset, length);
	
}

function doSubstring(){
	var display = document.getElementById("substringDisplay");
	var str = document.getElementById("string").value;
	var length = document.getElementById("length").value;
	var offset = document.getElementById("offset").value;;
	
	display.innerHTML = substring(str,length,offset);
}

document.getElementById("doSubstring").addEventListener("click", doSubstring, false);


//6. Even Number
//Define function: isEven(someNum)
//Return true if even, false if odd.
//Do not use % operator.


function isEven(someNum){
    if((someNum & 1) == 0){
        return true;
    }else{
        return false;
    }
}

function doEven(){
	var display = document.getElementById("evenDisplay");
	var input = document.getElementById("even").value;

	
	display.innerHTML = isEven(input);
}

document.getElementById("doEven").addEventListener("click", doEven, false);



//7. Palindrome
//Define function isPalindrome(someStr)
//Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr){
	var s = someStr.split("");
	var reverse = s.reverse();
	var join = reverse.join("");
	if(someStr==join){
		return true;
	}
	else 
		return false;
}

function doPalindrome(){
	var display = document.getElementById("palindromeDisplay");
	var input = document.getElementById("palindrome").value;

	
	display.innerHTML = isPalindrome(input);
}

document.getElementById("doPalindrome").addEventListener("click", doPalindrome, false);

//8. Shapes
//Define function: printShape(shape, height, character)
//shape is a String and is either "Square", "Triangle", "Diamond".
//height is a Number and is the height of the shape. Assume the number is odd.
//character is a String that represents the contents of the shape. Assume this String contains just one character.
//Use a switch statement to determine which shape was passed in.
//Use the console.log function to print the desired shape.
//Example for printShape("Square", 3, "%");
//%%%
//%%%
//%%%
//Example for printShape("Triangle", 3, "$");
//$
//$$
//$$$
//Example for printShape("Diamond", 5, "*");
//  *
// ***
//*****
// ***
//  *
















//9. Object literal
//Define function traverseObject(someObj)
//Print every property and it's value.
function traverseObject(someObj){
  var x = 0;
  var i;
  var keys = Object.keys(someObj);
  for(i in someObj){
      console.log(keys[x] + " " + someObj[i]);
      x++;
  }
}



//function doTraverse(){
//	var display = document.getElementById("traverseDisplay");
//	var input = document.getElementById("traverse").value;
//	var inp = input.split(',');
//	var p[inp[0]]=inp[1];
//	
//	
//	display.innerHTML = traverseObject(p);
//}
//document.getElementById("doTraverse").addEventListener("click", doTraverse, false);
//10. Delete Element
//Define function deleteElement(someArr)
//Print length
//Delete the third element in the array.
//Print length
//The lengths should be the same.
function deleteElement(someArr){
  console.log("Array Length = " + someArr.length);
  delete someArr[2];
  console.log("Array Length = " + someArr.length)
}
//11. Splice Element
//Define function spliceElement(someArr)
//Print length
//Splice the third element in the array.
//Print length
//The lengths should be one less than the original length.
function spliceElement(someArr){
  console.log("Array Length = " + someArr.length);
  someArr.splice(2,1);
  console.log("Array Length = " + someArr.length)
}
//12. Defining an object using a constructor
//Define a function Person(name, age)
//The following line should set a Person object to the variable john:
//var john = new Person("John", 30);
function Person(name, age){
  this.Name = name;
  this.Age = age;
}
//13. Defining an object using an object literal
//Define function getPerson(name, age)
//The following line should set a Person object to the variable john:
//var john = getPerson("John", 30);
function getPerson(name, age){
  var temp = {
      Name: name,
      Age: age,
  };
  return temp;
}

//-----------------------------------------------------------------------------------
//PART II
//Part II will focus on Javascript's ability to manipulate the DOM.
//Use the provided index.html
//Put your Javascript in the provided <script> element at the bottom of the page.
//Please put the question itself as a comment above each answer.
//NOTE: Part II will be done twice: once with Javascript and once with jQuery.
//	  They should be done separately.
//	  Copy the index.html file and rename them to: indexJavascript.html and indexJQuery.html
//-----------------------------------------------------------------------------------
//1. USA
//Define function getUSA()
//Find the html element that contains "USA".
//Print that element's contents.
//  
//2. Sales
//Define function getPeopleInSales()
//Print the names of all the people in the sales department.
//  
//3. Click Here
//Define function getAnchorChildren()
//Find all anchor elements with a <span> child.
//Print the contents of <span>
//  
//4. Hobbies
//Define function getHobbies()
//Find all checked options in the 'skills' select element.
//Print the value and the contents.
//  
//5. Custom Attribute
//Define function getCustomAttribute()
//Find all elements with "data-customAttr" attribute
//Print the value of the attribute.
//Print the element that has the attribute.
//6. Sum Event
//NOTE: Write unobtrusive Javascript
//Regarding these elements:
//	<input id="num1" class="nums" type="text"/>
//	<input id="num2" class="nums" type="text"/>
//	<h3>Sum: <span id="sum"></span></h3>
//Define onchange event handler.
//Add <input> element values.
//Put the sum in the <span> element.
//If values cannot be added, put "Cannot add" in the <span> element
//7. Skills Event
//NOTE: Write unobtrusive Javascript
//When user selects a skill, create an alert with a message similar to:
//	"Are you sure CSS is one of your skills?"
//NOTE: no alert should appear when user deselects a skill.
//8. Favorite Color Event
//NOTE: Write unobtrusive Javascript
//NOTE: This is regarding the favoriteColor radio buttons.
//When a user selects a color, create an alert with a message similar to:
//	"So you like green more than blue now?"
//In this example, green is the new value and blue is the old value.
//Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
//9. Show/Hide Event
//NOTE: Write unobtrusive Javascript
//When user hovers over an employees name:
//	Hide the name if shown.
//	Show the name if hidden.
//10. Current Time
//Regarding this element:
//	<h5 id="currentTime"></h5>
//Show the current time in this element in this format: 9:05:23 AM
//The time should be accurate to the second without having to reload the page.
//11. Delay
//Regarding this element:
//	<p id="helloWorld">Hello, World!</p>
//Three seconds after a user clicks on this element, change the text to a random color.
//12. Walk the DOM
//Define function walkTheDOM(node, func)
//This function should traverse every node in the DOM. Use recursion.
//On each node, call func(node).
