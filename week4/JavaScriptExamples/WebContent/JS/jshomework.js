/*
 * Javascript Homework
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
 **/
function fib(a){
	if(a==0){
		return 0}
	if(a==1)
	{return 1} 
	else 
		return fib(a-2)+fib(a-1);
}
//elem = document.getElementById("fib");
//elem.innerHTML=fib(5);

function doFIB(){
	var disp = document.getElementById("fibDisplay");
	var input = document.getElementById("fibNum").value;
	disp.innerHTML = fib(input);
}
document.getElementById("doFib").addEventListener("click", doFIB, false);


/*function work(){
	return "work";
}

elem1 = document.getElementByID("work").innerHTML=work();*/

//var x = document.getElementByClass("examples");

//var x = fib(5);
//elem.appendChild(x);
/*
2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
 */
function bubbleSort(a)
{
	var swapped;
	do {
		swapped = false;
		for (var i=0; i < a.length-1; i++) {
			if (a[i] > a[i+1]) {
				var temp = a[i];
				a[i] = a[i+1];
				a[i+1] = temp;
				swapped = true;
			}
		}
	} while (swapped);
	return a;
}

function doBsort(){
	var disp = document.getElementById("bSortVu");
	var input = document.getElementById("array").value;
	var s = input.split(",");
	disp.innerHTML = bubbleSort(s);
}
document.getElementById("doBSort").addEventListener("click", doBsort, false);

/*
3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
 */
function reverse(s) {
	var o = [];
	for (var i = 0, len = s.length; i <= len; i++)
		o.push(s.charAt(len - i));
	return o.join('');

}
function doRev(){

	var disp = document.getElementById("q3");
	var input = document.getElementById("rev").value;
	disp.innerHTML = reverse(input);
}

document.getElementById("revB").addEventListener("click", doRev, false);

/*
4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
 */
function factorial(n){
	if(n==0){
		return 0
	}
	else if(n==1){
		return 1;
	}
	else
		return factorial(n-1)*n;
}
function doFac(){
	disp = document.getElementById("q4");
	input = document.getElementById("iq4").value;
	disp.innerHTML=factorial(input);
}
document.getElementById("bq4").addEventListener("click",doFac,false);


/*
5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.
 */

function substr(s,l,o){
	if(o>=s.length || o<=0){
		alert("Offset is incorrect");
		if(l+o > s.length || o <=0){
			alert("Offset + length is out of bounds");
		}
		return s.substr(o,l);
	}
}

function doSubStr(){
	disp = document.getElementById("q5");
	input1 = document.getElementById("iq51").value;
	input2 = document.getElementById("iq52").value;
	input3 = document.getElementById("iq53").value;
	disp.innerHTML=substr(input1,input2,input3);
}
document.getElementById("bq5").addEventListener("click",doSubStr,false);


/*
6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
 */
var x = 0;
function isEven(n){
	for(x=n;x>=1;x-=2){
		if(n===1){	
			return false;
		}
		n-=2;
		console.log(n);
	}
	console.log(n);
	return true;

}
function doEven(){
	disp = document.getElementById("q6");
	input = document.getElementById("iq6").value;
	disp.innerHTML = isEven(input);
}
document.getElementById("bq6").addEventListener("click",doEven,false);


/*
7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
 */

function isPalindrome(s){
	if(reverse(s)==s){
		return true;
	}
	return false;
}

function doPali(){
	disp = document.getElementById("q7");
	input = document.getElementById("iq7").value;
	disp.innerHTML = isPalindrome(input);
}
document.getElementById("bq7").addEventListener("click", doPali,false);


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
function printShape(s,n,c){
	var t;
	switch(s){
	case("Square"):
		var t='';
	for(var i=0;i<n;i++){
		for(var j=0;j<n;j++){
			//console.log(n);
			t+=c;
		}
		console.log(t);
		t='';
	}
	break;
	case("Triangle"):
		var t='';
	for(var i=0;i<n;i++){
		for(var j=0;j<1;j++){
			t+=c;
		}
		console.log(t);
	}
	break;
	return "Look at Console";


	case("Diamond"):
		let upHeight = Math.floor(n/2) + 1;

    var space = upHeight - 1;
    for (let j = 1; j <= upHeight; j++) {
        let row = '';
        for (let i = 1; i <= space; i++) {
            row += ' ';
        }
        space--;
        for (let i = 1; i <= 2 * j - 1; i++) {
            row += c;
        }
        console.log(row);
    }
    space = 1;

    for (let j = 1; j <= upHeight - 1; j++) {
        let row = '';
        for (let i = 1; i <= space; i++) {
            row += ' ';
        }
        space++;
        for (let i = 1; i <= 2 * (upHeight - j) - 1; i++)
        {
            row += c;
        }
        console.log(row);
    }

    break;
	}
}

function doShape(){
	disp = document.getElementById("q8");
	input1= document.getElementById("iq81").value;
	input2= document.getElementById("iq82").value;
	input3= document.getElementById("iq83").value;
	disp.innerHTML = (printShape(input1,input2,input3));
}
document.getElementById("bq8").addEventListener("click", doShape,false);


/*
9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.
*/
function traverseObject(someObj){
	 for (var a in someObj) {
	        console.log(a + ' : ' + someObj[a]);
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

function deleteElement(arr){
	console.log(arr.length);
	delete arr[2];
    console.log(arr.length);
}


    


/*
11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.
*/
function deleteElement(arr){
	console.log(arr.length);
	arr.splice(2,1);
    console.log(arr.length);
}



/*
12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
    var john = new Person("John", 30);
*/
function Person(name, age) {
    this.name = name;
    this.age = age;
}

/*
13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
    var john = getPerson("John", 30);
*/
function getPerson(name, age) {
    var x = {
        'name' : name,
        'age' : age
    };
    return x;
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
*/
function getUSA(){
	var Elements = document.innerHTML("USA");
	traverseObject(Elements);
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
Add Comment Collapse

genesis [10:35 AM]  
added this HTML snippet: index.html.txt 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DOM</title>
</head>
<body>

  <div>
    <div>
      <h3>Sum: <span id="sum"></span></h3>
      <h5 id="currentTime"></h5>
    </div>
    <div>
      <h1>United <span data-customAttr="USA">States</span> of America (<span>USA</span>)</h1>
      <div><a>Click Here</a><a>Click Here</a><a>Click Here</a><a>Click Here</a><a>Click Here</a></div>
      <a>Click Here</a>
      <a>Click <span>Here1</span></a>
      <a>Click Here</a>
      <div>
	  <select name="colors">
	    <option value="green">Green</option>
	    <option value="blue">Blue</option>
	    <option value="red" selected="selected">Red</option>
	    <option value="purple">Purple</option>
	    <option value="yellow" selected="selected">Yellow</option>
	  </select>
      </div>
    </div>
    <p id="helloWorld">Hello, World!</p>
    <div>
      <table>
        <tr>
          <th>Name</th>
          <th>Department</th>
        </tr>
        <tr>
          <td class="empName">John</td>
          <td>Sales</td>
        </tr>
        <tr>
          <td class="empName">Amy</td>
          <td>Finance</td>
        </tr>
        <tr>
          <td class="empName">Austin</td>
          <td>Sales</td>
        </tr>
        <tr>
          <td class="empName">Katie</td>
          <td>Marketing</td>
        </tr>
        <tr>
          <td class="empName" data-customAttr="court">Courtney</td>
          <td>Sales</td>
        </tr>
        <tr>
          <td class="empName">Scout</td>
          <td>Sales</td>
        </tr>
      </table>
    </div>
    <form id="firstForm">
      <a>Click <span>Here2</span></a>
	  <input type="text" data-customAttr="7"/><br/>
	  <input type="text" data-customAttr="24"/><br/>
	  <input type="radio" name="favoriteAnimal" value="dog"/>Dog<br/>
	  <input type="radio" name="favoriteColor" value="blue"/>Blue<br/>
	  <input id="num1" class="nums" type="text"/><br/>
	  <input type="radio" name="favoriteAnimal" value="cat"/>Cat<br/>
	  <input type="radio" name="favoriteColor" value="red"/>Red<br/>
	  <input type="radio" name="favoriteAnimal" value="horse"/>Horse<br/>
	  <input type="radio" name="favoriteAnimal" value="dolphin"/>Dolphin<br/>
	  <a>Click <span>Here</span></a><br/>
	  <input type="radio" name="favoriteAnimal" value="eagle"/>Eagle<br/>
	  <input type="radio" name="favoriteColor" value="green"/>Green<br/>
	  <input type="radio" name="favoriteColor" value="orange"/>Orange<br/>
	  <select name="hobbies">
	    <option value="photography">Photography</option>
	    <option value="football" selected="selected">Football</option>
	    <option value="kayaking" selected="selected">Kayaking</option>
	    <option value="hiking">Hiking</option>
	    <option value="programming" selected="selected">Programming</option>
	  </select>
	  <input id="num2" class="nums" type="text"/>
	  <select name="skills">
	    <option value="java">Java</option>
	    <option value="net">.NET</option>
	    <option value="dom" selected="selected">DOM</option>
	    <option value="html">HTML</option>
	    <option value="css">CSS</option>
	    <option value="javascript" selected="selected">Javascript</option>
	  </select>
    </form>
  </div>
  <a>Click Here</a>
  <a>Click <span data-customAttr="500">Here3</span></a>
  <a>Click Here</a>

  <script type="text/javascript">
    //TODO: Javascript homework
  </script>

</body>
</html>
 * 
 * 
 * 
 * 
 */