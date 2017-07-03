//create a simple person object
var person {
	"name": "Nate",
	"age" : 25,
	"employeeID": true,
	"vehicle" : {},
	"talk": function(){console.log("hello");}
};
//-- person.talk(); prints hello.
//-------------------------------------------------------------------------------
//-- All extra args sent to function are stored in arguments objects.
function sum(x,y) {
	if(arguments[2])
		console.log(arguments[2]);
	return(x+y);
}
//-------------------------------------------------------------------------------
//-- Typical constructor  -- person.prototype -> Object {}
var Person = function(name) {
	this,name = name;
}
//-------------------------------------------------------------------------------
//-- An immediately invoking function (Whenever you run it.) (Because of the parenthesis)
var Person = (function() {
	var lName;
	var lAge;
	return function(age, name) {
		lname = name;
		lAge = age;
		return {
			"getAge": function() { 
				return lAge;
			},
			"getName": function() { 
				return lName;
			}
		}
	}
})();
//-------------------------------------------------------------------------------
//-- code test 
//-- sum(2,3) outputs 5
//-- sum(2)(3) outputs 5
var sum = function (a,b) {
	if(b != null)
		return arguments[0] + arguments[1];
	else
		return function(c) {
		return a+c;
	}
}
//-------------------------------------------------------------------------------
//-- Shouldnt do this.
//-- When you want to handle events let JS file deal with it
/*
<div id="box1" class="b" onclick="alert("hello"")">
    <div id="inBox1"></div>
</div> */
//-- Instead
var box1 getElementById("box1");
var box3 getElementById("box3");

//-- Registerts an event function for box1 when whatever thing happens
box1.addEventListener("click", function(event) {
	alert("You clicked box 1");
});

box1.addEventListener("mouseenter", function(event) {
	var actualTar = event.currentTarget;

	if(actualTar.id == "inBox1")


		event.target.style.backgroundColor = "blue";
});

box1.addEventListener("mouseleave", function(event) {
	event.target.style.backgroundColor = "red";
});

box3.onclick = function(evert) {
	alert("you clicked box3");
};





