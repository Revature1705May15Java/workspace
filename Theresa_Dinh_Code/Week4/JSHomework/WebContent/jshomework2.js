//PART II
//Part II will focus on Javascript's ability to manipulate the DOM.
//Use the provided index.html
//Put your Javascript in the provided <script> element at the bottom of the page.
//Please put the question itself as a comment above each answer.
//NOTE: Part II will be done twice: once with Javascript and once with jQuery.
//      They should be done separately.
//      Copy the index.html file and rename them to: indexJavascript.html and indexJQuery.html
//-----------------------------------------------------------------------------------
//1. USA
//Define function getUSA()
//Find the html element that contains "USA".
//Print that element's contents.
function getUSA()
{
    var contents = document.getElementsByTagName("span");
    console.log(contents[1]);
}

//2. Sales
//Define function getPeopleInSales()
//Print the names of all the people in the sales department.
function getPeopleInSales()
{
    var contents = document.getElementsByClassName("empName");
    for(i = 0; i < contents.length; i++)
        console.log(contents[i].innerHTML);
}

//3. Click Here
//Define function getAnchorChildren()
//Find all anchor elements with a <span> child.
//Print the contents of <span>
function getAnchorChildren()
{
    var contents = document.getElementsByTagName("span");
    for(i = 0; i < contents.length; i++)
    {
        if(contents[i].parentNode.nodeName == "A")
            console.log(contents[i].innerHTML);
    }
}

//4. Hobbies
//Define function getHobbies()
//Find all checked options in the 'skills' select element.
//Print the value and the contents.
function getHobbies()
{
    var contents = document.getElementsByTagName("option");
    for(i = 0; i < contents.length; i++)
    {
        if(contents[i].parentNode.getAttribute("name") == "skills") //if parent node is part of skills
        console.log(contents[i].value + " " + contents[i].innerHTML);
    }
}

//5. Custom Attribute
//Define function getCustomAttribute()
//Find all elements with "data-customAttr" attribute
//Print the value of the attribute.
//Print the element that has the attribute.
function getCustomAttribute()
{
    var contents = document.getElementsByTagName("div");
    var children = contents.childNodes;
    for(i = 0; i < children.length; i++)
    {
        if(chldren[i].getAttribute("data-customAttr") != null)
            console.log(contents[i].getAttribute("data-customAttr") + " " + contents[i]);
    }
}

//6. Sum Event
//NOTE: Write unobtrusive Javascript
//Regarding these elements:
//    <input id="num1" class="nums" type="text"/>
//    <input id="num2" class="nums" type="text"/>
//    <h3>Sum: <span id="sum"></span></h3>
//Define onchange event handler.
//Add <input> element values.
//Put the sum in the <span> element.
//If values cannot be added, put "Cannot add" in the <span> element


//7. Skills Event
//NOTE: Write unobtrusive Javascript
//When user selects a skill, create an alert with a message similar to:
//    "Are you sure CSS is one of your skills?"
//NOTE: no alert should appear when user deselects a skill.
{
    var contents = document.getElementsByTagName("option");
    for(i = 0; i < contents.length; i++)
    {
        if(contents[i].parentNode.getAttribute("name") == "skills") //if parent node is part of skills
            contents[i].addEventListener("onchange", alert("Are you sure " + contents[i].innerHTML + " is one of your skills?")); 
    }
}

//8. Favorite Color Event
//NOTE: Write unobtrusive Javascript
//NOTE: This is regarding the favoriteColor radio buttons.
//When a user selects a color, create an alert with a message similar to:
//    "So you like green more than blue now?"
//In this example, green is the new value and blue is the old value.
//Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor


//9. Show/Hide Event
//NOTE: Write unobtrusive Javascript
//When user hovers over an employees name:
//    Hide the name if shown.
//    Show the name if hidden.
{
    var contents = document.getElementsByClassName("empName");
    contents.addEventListener
    (
        "mouseover",
        function()
        {
            contents.style.visibility = 'hidden'; 
        }
    );
    contents.addEventListener
    (
        "mouseout",
        function()
        {
            contents.style.visibility = 'visible'; 
        }
    );
}

//10. Current Time
//Regarding this element:
//    <h5 id="currentTime"></h5>
//Show the current time in this element in this format: 9:05:23 AM
//The time should be accurate to the second without having to reload the page.
{
   setInterval
   (
        function()
        {
            var contents = document.getElementById("currentTime"); 
            contents.innerHTML = new Date().toLocaleTimeString();   
        }, 
       1000
    )
}

//11. Delay
//Regarding this element:
//    <p id="helloWorld">Hello, World!</p>
//Three seconds after a user clicks on this element, change the text to a random color.
{
    setTimeout
    (
        function()
        {
            var contents = document.getElementById("hellowWorld");
            contents.addEventListener
            (
                "click", 
                function()
                {
                    contents.style.color = getRandomColor();
                }
            );
        },
        3000
    )
    
    function getRandomColor() 
    {
        var letters = '0123456789ABCDEF';
        var color = '#';
        for (var i = 0; i < 6; i++ ) 
        {
            color += letters[Math.floor(Math.random() * 16)];
        }
        return color;
    }
}

//12. Walk the DOM
//Define function walkTheDOM(node, func)
//This function should traverse every node in the DOM. Use recursion.
//On each node, call func(node).
function walkTheDOM(node, func)
{
    
}