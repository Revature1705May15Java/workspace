// Javascript Homework
// Due Friday @ 9PM
// Put all homework in:
// ....Firstname_Lastname_Code/Week4/Javascript_Homework/
// -----------------------------------------------------------------------------------
//     PART I
// Create a single Javascript file called homework.js to answer these questions.
//     Please put the question itself as a comment above each answer.
// -----------------------------------------------------------------------------------
//     1. Fibonacci
// Define function: fib(n)
// Return the nth number in the fibonacci sequence.

function fib(n) {
    if (n < 2) {
        return 1;
    } else {
        return fib(n - 2) + fib(n - 1);
    }
}

// console.log(fib(10));
// var elem = document.getElementById('fib');
// elem.innerHTML = fib(10);


// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
//     Return the sorted array.

function bubbleSort(numArray) {
    for (let i = 0; i < numArray.length; i++) {
        for (let j = 0; j < numArray.length-1; j++) {
            if (numArray[j] > numArray[j+1]) {
                //swap
                let tmp = numArray[j];
                numArray[j] = numArray[j+1];
                numArray[j+1] = tmp;
            }
        }

    }

    return numArray;
}
// console.log(bubbleSort([3, 1, 6, 3, 5, 9, 2]));



// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.

function reverseStr(s) {
    let result = '';

    for (let i = s.length-1; i >= 0; i--) {
        result += s[i];
    }

    return result;
}
// console.log(reverseStr('asdf'));



// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
function factorial(n) {
    if (n <= 1) {
        return 1;
    } else {
        return n * factorial(n-1);
    }
}
// console.log(factorial(5));




// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
//     If incorrect input is entered, use the alert function and describe why the input was incorrect.
function substring(str, length, offset) {
    if (offset > str.length-1 || offset+length > str.length) {
        alert('bounds not w/in string');
        return;
    }

    let result = '';

    for (let i = offset; i < offset + length; i++) {
        result += str[i];
    }

    return result;
}
// console.log(substring('asdf', 2, 1));




// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
//     Do not use % operator.
function isEven(n) {
    let result = false;

    let i = n;
    while (i > 0) {
        i -= 2;
    }

    if (i === 0) {
        result = true;
    }

    return result;
}
// console.log(isEven(6));



// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
function isPalindrome(str) {
    if (reverseStr(str) === str) {
        return true;
    } else {
        return false;
    }
}
// console.log(isPalindrome("racecar"));
// console.log(isPalindrome("mom"));
// console.log(isPalindrome("race"));




// 8. Shapes
// Define function: printShape(shape, height, character)
// shape is a String and is either "Square", "Triangle", "Diamond".
//     height is a Number and is the height of the shape. Assume the number is odd.
//     character is a String that represents the contents of the shape. Assume this String contains just one character.
//     Use a switch statement to determine which shape was passed in.
//     Use the console.log function to print the desired shape.
//         Example for printShape("Square", 3, "%");
//         %%%
// %%%
// %%%
//     Example for printShape("Triangle", 3, "$");
//                 $
//                 $$
//         $$$
//     Example for printShape("Diamond", 5, "*");
//         *
// ***
// *****
// ***
// *
function printShape(shape, height, char) {
    switch (shape) {
        case 'Square':
            for (let i = 0; i < height; i++) {
                let row = '';
                for (let j = 0; j < height; j++) {
                    row += char;
                }
                console.log(row);
            }
            break;
        case 'Triangle':
            for (let i = 1; i <= height; i++) {
                let row = '';
                for (let j = 0; j < i; j++) {
                    row += char;
                }
                console.log(row);
            }
            break;
        case 'Diamond':
            let upHeight = Math.floor(height/2) + 1;

            var space = upHeight - 1;
            for (let j = 1; j <= upHeight; j++) {
                let row = '';
                for (let i = 1; i <= space; i++) {
                    row += ' ';
                }
                space--;
                for (let i = 1; i <= 2 * j - 1; i++) {
                    row += char;
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
                    row += char;
                }
                console.log(row);
            }

            break;
    }
}
// printShape('Square', 3, '%');
// printShape('Triangle', 3, '#');
// printShape('Diamond', 7, '8');


//     9. Object literal
//     Define function traverseObject(someObj)
//     Print every property and it's value.
function traverseObject(obj) {
    for (let a in obj) {
        console.log(a + ' : ' + obj[a]);
    }
}
// traverseObject({
//     'fName' : 'eric',
//     'lName' : 'clapton',
//     'group' : 'Cream'
// });




//     10. Delete Element
//     Define function deleteElement(someArr)
//     Print length
//     Delete the third element in the array.
//         Print length
//     The lengths should be the same.
function deleteElement(arr) {
    console.log(arr.length);
    delete arr[2];
    console.log(arr.length);
}
// deleteElement([3, 1, 5, 2, 1]);



//     11. Splice Element
//     Define function spliceElement(someArr)
//     Print length
//     Splice the third element in the array.
//         Print length
//     The lengths should be one less than the original length.
function spliceElement(arr) {
    console.log(arr.length);
    arr.splice(2, 1);
    console.log(arr.length);
}
// console.log(spliceElement([3, 2, 6, 2, 1, 7, 1]));




//     12. Defining an object using a constructor
//     Define a function Person(name, age)
//     The following line should set a Person object to the variable john:
//         var john = new Person("John", 30);
function Person(name, age) {
    this.name = name;
    this.age = age;
}
// let john = new Person("John", 30);
// let frank = new Person("Frank", 23);
// console.log(john);
// console.log(frank);
// console.log(john);




//     13. Defining an object using an object literal
//     Define function getPerson(name, age)
//     The following line should set a Person object to the variable john:
//         var john = getPerson("John", 30);
function getPerson(name, age) {
    let obj = {
        'name' : name,
        'age' : age
    };
    return obj;
}
var john = getPerson("John", 45);
console.log(john);






//     -----------------------------------------------------------------------------------
//         PART II
//     Part II will focus on Javascript's ability to manipulate the DOM.
//     Use the provided index.html
//     Put your Javascript in the provided <script> element at the bottom of the page.
//         Please put the question itself as a comment above each answer.
//         NOTE: Part II will be done twice: once with Javascript and once with jQuery.
//         They should be done separately.
//         Copy the index.html file and rename them to: indexJavascript.html and indexJQuery.html
//     -----------------------------------------------------------------------------------
//         1. USA
//     Define function getUSA()
//     Find the html element that contains "USA".
//         Print that element's contents.




//     2. Sales
//     Define function getPeopleInSales()
//     Print the names of all the people in the sales department.




//     3. Click Here
//     Define function getAnchorChildren()
//     Find all anchor elements with a <span> child.
//         Print the contents of <span>




//     4. Hobbies
//     Define function getHobbies()
//     Find all checked options in the 'skills' select element.
//         Print the value and the contents.




//     5. Custom Attribute
//     Define function getCustomAttribute()
//     Find all elements with "data-customAttr" attribute
//     Print the value of the attribute.
//         Print the element that has the attribute.




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




//     7. Skills Event
//     NOTE: Write unobtrusive Javascript
//     When user selects a skill, create an alert with a message similar to:
//         "Are you sure CSS is one of your skills?"
//     NOTE: no alert should appear when user deselects a skill.




//     8. Favorite Color Event
//     NOTE: Write unobtrusive Javascript
//     NOTE: This is regarding the favoriteColor radio buttons.
//         When a user selects a color, create an alert with a message similar to:
//         "So you like green more than blue now?"
//     In this example, green is the new value and blue is the old value.
//         Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor




//     9. Show/Hide Event
//     NOTE: Write unobtrusive Javascript
//     When user hovers over an employees name:
//         Hide the name if shown.
//         Show the name if hidden.




//         10. Current Time
//     Regarding this element:
//         <h5 id="currentTime"></h5>
//         Show the current time in this element in this format: 9:05:23 AM
//     The time should be accurate to the second without having to reload the page.




//     11. Delay
//     Regarding this element:
//         <p id="helloWorld">Hello, World!</p>
//     Three seconds after a user clicks on this element, change the text to a random color.




//     12. Walk the DOM
//     Define function walkTheDOM(node, func)
//     This function should traverse every node in the DOM. Use recursion.
//         On each node, call func(node).