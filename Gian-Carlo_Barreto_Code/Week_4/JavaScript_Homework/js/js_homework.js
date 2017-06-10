/*Javascript Homework
 * @author: Gian-Carlo Barreto
Due Friday @ 9PM
Put all homework in:
	....Firstname_Lastname_Code/Week4/Javascript_Homework/
-----------------------------------------------------------------------------------
PART I
Create a single Javascript file called homework.js to answer these questions.
Please put the question itself as a comment above each answer.
-----------------------------------------------------------------------------------
*/

/* 1. Fibonacci
 * Define function: fib(n) 
 * Return the nth number in the fibonacci sequence.
*/

function fib(n) {
	if (n == 1)
		return 0;
	else if (n == 2)
		return 1;
	else
		return fib(n - 1) + fib(n - 2);
}

function calc() {
	var num = document.getElementById("fib").value;
	num = parseInt(num);
	document.getElementById("ans1").innerHTML = fib(num);
}

//Add event listener to document
document.getElementById("calc").addEventListener("click", calc, false);


/* 2. Bubble Sort
 * Define function: bubbleSort(numArray)
 * Use the bubble sort algorithm to sort the array.
 * Return the sorted array.
*/

function bubbleSort(numArray) {
	for (var i = 0; i < numArray.length - 1; i++) {
		for (var j = i + 1; j < numArray.length; j++) {
			// Swaps two elements
			if (numArray[i] > numArray[j]) {
				var temp = numArray[j];
				numArray[j] = numArray[i];
				numArray[i] = temp;
			}
		}
	}
	
	return numArray;
}

// Get the user's array and displays the sorted array
function doSort() {
	var str = document.getElementById("bsort").value;
	var strArray = str.split(" ");
	var nums = new Array(strArray.length);
	for (var i = 0; i < nums.length; i++)
		nums[i] = parseInt(strArray[i]);
	nums = bubbleSort(nums);
	document.getElementById("ans2").innerHTML = nums.join(" ");
}

// Add an event listener to the Sort button.
document.getElementById("sort").addEventListener("click", doSort, false);


/* 3. Reverse String
 * Define function: reverseStr(someStr)
 * Reverse and return the String.
*/

function reverseStr(someStr) {
	var rev = ""
	for (var i = someStr.length - 1; i >= 0; i--) {
		rev += someStr.charAt(i);
	}
	return rev;
}

// Get the user input and display the reversed string
function doReverse() {
	var str = document.getElementById("ostr").value;
	document.getElementById("ans3").innerHTML = reverseStr(str); 
}

// Add an event listener to the Reverse String Button
document.getElementById("rev").addEventListener("click", doReverse, false);


/* 4. Factorial
 * Define function: factorial(someNum)
 * Use recursion to compute and return the factorial of someNum.
*/

function factorial(someNum) {
	if (someNum == 1 || someNum == 0)
		return 1;
	else
		return someNum * factorial(someNum - 1);
}

// Get the user number and display the factorial of that number
function doFact() {
	var num = document.getElementById("factNum").value;
	document.getElementById("ans4").innerHTML = factorial(parseInt(num));
}

// Add an event listener to the Compute Factorial button
document.getElementById("fact").addEventListener("click", doFact, false);


/* 5. Substring
 * Define function substring(someStr, length, offset)
 * Return the substring contained between offset and (offset + length) inclusively.
 * If incorrect input is entered, use the alert function and describe why the input was incorrect.
*/

function substring(someStr, length, offset) {
	if (someStr == null || someStr == "") 
		alert("String is null or empty");
	else if (offset < 0 || offset >= someStr.length) 
		alert("The offset is not a valid index")
	else if (offset + length > someStr.length)
		alert("A substring of that length and offset cannot be created")
	else {
		var sub = "";
		for (var i = offset; i <= offset + length; i++) {
			sub += someStr.charAt(i);
		}
		return sub;
	}
	return null;
}

// Get the substring of a string and display it
function doSub() {
	var str = document.getElementById("sstr").value;
	var len = parseInt(document.getElementById("len").value);
	var offset = parseInt(document.getElementById("off").value);
	document.getElementById("ans5").innerHTML = substring(str, len, offset);
}

// Add an event listener to the Get Substring button
document.getElementById("sub").addEventListener("click", doSub, false);


/* 6. Even Number
 * Define function: isEven(someNum)
 * Return true if even, false if odd.
 * Do not use % operator.
*/

function isEven(someNum) {
	return ((someNum & 1) == 0);
}

// Get the user's number and display whether or not the number is even
function doEven() {
	var num = document.getElementById("enum").value;
	document.getElementById("ans6").innerHTML = isEven(parseInt(num));
}

// Add an event listener to the Is Even button
document.getElementById("even").addEventListener("click", doEven, false);


/* 7. Palindrome
 * Define function isPalindrome(someStr)
 * Return true if someStr is a palindrome, otherwise return false
*/

function isPalindrome(someStr) {
	// Use the split() method to convert the String into an array of chars
	var strArray = someStr.split("");
	
	// Use the reverse() method to reverse the string array
	var reverseArray = strArray.reverse();
	
	// Use the join() method to join all elements of the array into a string
	var revStr = reverseArray.join("");
	
	if (someStr == revStr)
		return true;
	else 
		return false;
}

// Get the user's string and determine whether or not it is a palindrome
function doPalin() {
	var str = document.getElementById("pstr").value;
	document.getElementById("ans7").innerHTML = isPalindrome(str);
}

// Add an event listener to the Is Palindrome button
document.getElementById("palin").addEventListener("click", doPalin, false);

/*8. Shapes
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
	var hline = "";
	switch(shape) {
		case "Square":
			for (var i = 1; i <= height; i++) {
				for (var j = 1; j <= height; j++) {
					line += character;
					hline += character;
				}
				line += "\n";
				hline += "<br>";
			}
			break;
		case "Triangle":
			for (var i = 1; i <= height; i++) {
				for (var j = 1; j <= i; j++) {
					line += character;
					hline += character;
				}
				line += "\n";
				hline += "<br>";
			}
			break;
		case "Diamond":
			var count = 1;
			var spaces = 0;
			var s = " "
			var sp = "&nbsp";
			for (var i = 1; i <= parseInt((height / 2), 10) + 1; i++) {
				spaces = parseInt((height - count) / 2, 10);
				line += s.repeat(spaces) + character.repeat(count);
				hline += sp.repeat(spaces) + character.repeat(count);
				line += "\n";
				hline += "<br>";
				count += 2;
			}
			count -= 4;
			for (var i = parseInt((height / 2) + 2, 10); i <= parseInt(height, 10); i++) {
				console.log("i: " + i);
				spaces = parseInt((height - count) / 2, 10);
				line += s.repeat(spaces) + character.repeat(count);
				hline += sp.repeat(spaces) + character.repeat(count);
				line += "\n";
				hline += "<br>";
				count -= 2;
			}
			break;
		default:
			line = "Invalid Shape";
	}
	console.log(line);
	return hline;
}

// Get the user's shape info and display the shape
function doPrint() {
	var shape = document.getElementById("shape").value;
	var height = document.getElementById("height").value;
	var char = document.getElementById("char").value;
	document.getElementById("ans8").innerHTML = printShape(shape, height, char);
}

// Add an action listener to the "Print Shape" button
document.getElementById("display").addEventListener("click", doPrint, false);

/* 9. Object literal
 * Define function traverseObject(someObj)
 * Print every property and it's value.
*/

function traverseObject(someObj) {
	var line = "";
	for (var key in someObj) {
		if (someObj.hasOwnProperty(key)) {
			console.log(key + " : " + someObj[key]);
			line += key + " : " + someObj[key] + "<br>";
		}
	}
	return line;
}

function doTraverse() {
	var strObj = document.getElementById("obj").value;
	console.log(strObj);
	var myObj = JSON.parse(strObj);
	document.getElementById("ans9").innerHTML = traverseObject(myObj);
}

// Add an event listener to the Traverse button
document.getElementById("trav").addEventListener("click", doTraverse, false);


/* 10. Delete Element
 * Define function deleteElement(someArr)
 * Print length
 * Delete the third element in the array.
 * Print length
 * The lengths should be the same.
*/

function deleteElement(someArr) {
	console.log("Length: " + someArr.length);
	delete someArr[2];
	console.log("Length: " + someArr.length);
	return someArr;
}

// Get the user array and delete the third element
function doDelete() {
	var str = document.getElementById("oarr").value;
	var strArray = str.split(" ");
	var nums = new Array(strArray.length);
	var line = "Length before deletion: " + nums.length + "<br>";
	for (var i = 0; i < nums.length; i++)
		nums[i] = parseInt(strArray[i]);
	nums = deleteElement(nums);
	line += "Length after deletion: " + nums.length + "<br>";
	document.getElementById("ans10").innerHTML = line;
}

// Add an event listener to the Delete button
document.getElementById("del").addEventListener("click", doDelete, false);


/* 11. Splice Element
 * Define function spliceElement(someArr)
 * Print length
 * Splice the third element in the array.
 * Print length
 * The lengths should be one less than the original length.
*/

function spliceElement(someArr) {
	console.log("Length: " + someArr.length);
	someArr.splice(2, 1);
	console.log("Length: " + someArr.length);
	return someArr;
}

//Get the user array and delete the third element
function doSplice() {
	var str = document.getElementById("orarr").value;
	var strArray = str.split(" ");
	var nums = new Array(strArray.length);
	var line = "Length before deletion: " + nums.length + "<br>";
	for (var i = 0; i < nums.length; i++)
		nums[i] = parseInt(strArray[i]);
	nums = spliceElement(nums);
	line += "Length after deletion: " + nums.length + "<br>";
	document.getElementById("ans11").innerHTML = line;
}

// Add an event listener to the Delete button
document.getElementById("splice").addEventListener("click", doSplice, false);

/* 12. Defining an object using a constructor
 * Define a function Person(name, age)
 * The following line should set a Person object to the variable john:
 *	var john = new Person("John", 30);
*/

function Person(name, age) {
	this.name = name;
	this.age = age;
}

// Get the name and age from user and display an obj with the fields
function doPrintObj() {
	var name = document.getElementById("name").value;
	var age = document.getElementById("age").value;
	var person = new Person(name, age);
	var line = "Name: " + person.name + "<br>";
	line += "Age: " + person.age + "<br>";
	document.getElementById("ans12").innerHTML = line;
}

// Add an event listener to the "Print Object" button
document.getElementById("pcon").addEventListener("click", doPrintObj, false);


/* 13. Defining an object using an object literal
 * Define function getPerson(name, age)
 * The following line should set a Person object to the variable john:
 *	var john = getPerson("John", 30);
*/

function getPerson(name, age) {
	var person = new Object();
	person.name = name;
	person.age = age;
	return person;
}

//Get the name and age from user and display an obj with the fields
function doPrintP() {
	var name = document.getElementById("name13").value;
	var age = document.getElementById("age13").value;
	var person = getPerson(name, age);
	var line = "Name: " + person.name + "<br>";
	line += "Age: " + person.age + "<br>";
	document.getElementById("ans13").innerHTML = line;
}

// Add an event listener to the "Print Object" button
document.getElementById("pcon13").addEventListener("click", doPrintP, false);
