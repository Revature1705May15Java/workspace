//1. Fibonacci
//Define function: fib(n) 
//Return the nth number in the fibonacci sequence.
function fib(n)
{
	var num = 0;
	var num2 = 1; 
	var temp = 1; 
	for(i = 0; i < n-2; i++)
	{
		num += num2; 
		num2 = temp; 
		temp = num; 
	}
	return num;
}

//2. Bubble Sort
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort the array.
//Return the sorted array.
function bubbleSort(numArray)
{
    
}

//3. Reverse String
//Define function: reverseStr(someStr)
//Reverse and return the String.
function reverseStr(someStr)
{
	var str = "";
	var array = someStr.split("");
	for(i = array.length-1; i >= 0; i--)
		str += array[i];
	return str; 
}	

//4. Factorial
//Define function: factorial(someNum)
//Use recursion to compute and return the factorial of someNum.
function factorial(someNum)
{
    if(someNum <= 0)
        return 1;
    return someNum * factorial(--someNum);
}

//5. Substring
//Define function substring(someStr, length, offset)
//Return the substring contained between offset and (offset + length) inclusively.
//If incorrect input is entered, use the alert function and describe why the input was incorrect.
function substring(someStr, length, offset)
{
    try
    {
        return someStr.substring(offset, offset+length);
    }
    catch(SyntaxError)
    {
        alert("The method requires input to be a string, a number, and another number to work properly."); 
    }
}

//6. Even Number
//Define function: isEven(someNum)
//Return true if even, false if odd.
//Do not use % operator.
function isEven(someNum)
{
    var remainder = (someNum/2.0).toString;
    var regex = /\d*\.{1}\d+/;//
    return !regex.test(remainder);
}
//7. Palindrome
//Define function isPalindrome(someStr)
//Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr)
{
    var matchLetterNum = someStr.length / 2; 
    for(var i = 0; i < matchLetterNum; i++)
    {
        if(someStr.substring(i, i+1) == someStr.substring(someStr.length-(i+1), someStr.length-i))
        {
        }
        else
            return false; 
    }
    return true; 
}

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
function printShape(shape, height, character)
{
    switch(shape)
    {
        case "Square":
        {
            var output = ""; 
            for(i = 0; i < height; i++)
            {
                for(j = 0; j < height; j++)
                {
                    output += character; 
                }
                console.log(output);
                output = ""; 
            }
            break;
        }
        case "Triangle":
        {
            var output = ""; 
            for(i = 0; i < height; i++)
            {
                for(j = 0; j <= i; j++)
                {
                    output += character;
                }
                console.log(output); 
                output = ""; 
            }
            break;
        }
        case "Diamond":
        {
            var output = ""; 
            for(i = 0; i < height; i++)
            {
                for(j = i; j < (height/2); j++)
                {
                    output += " "; 
                }
                for(k = 0; k <= i; k++)
                {
                    ///////////////////////////////////
                }
                console.log(output); 
                output = ""; 
            }
            break;
        }
    }
}

//9. Object literal
//Define function traverseObject(someObj)
//Print every property and it's value.
function traverseObject(someObj)
{
    for(var property in someObj)
        console.log(property + " " + someObj[property]); 
}
//10. Delete Element
//Define function deleteElement(someArr)
//Print length
//Delete the third element in the array.
//Print length
//The lengths should be the same.
function deleteElement(someArr)
{
    log.console(someArr.length);
    delete someArr[2];
    log.constant(someArr.length);
}

//11. Splice Element
//Define function spliceElement(someArr)
//Print length
//Splice the third element in the array.
//Print length
//The lengths should be one less than the original length.
function spliceElement(someArr)
{
    log.console(someArr.length);
    someArr.splice(3, 0);
    log.console(someArr.length);
}

//12. Defining an object using a constructor
//Define a function Person(name, age)
//The following line should set a Person object to the variable john:
//    var john = new Person("John", 30);
function Person(name, age)
{
    var john = new Person("John", 30);
}

//13. Defining an object using an object literal
//Define function getPerson(name, age)
//The following line should set a Person object to the variable john:
//    var john = getPerson("John", 30);
function getPerson(name, age)
{
    var john = getPerson("John", 30); 
}
