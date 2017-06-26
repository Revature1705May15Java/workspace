//var parags = document.getElementsByTagName("p");
//// var pString = parags.join(" - ");
//var inner;
//for (i = 0; i < parags.length; i++) {
//	inner.push(parags[i].innerHTML);
//
//}
//
//document.getElementById("display").innerHTML = parags[0].innerHTML;
function add() {
	// element values
	var id = document.getElementById("t_id").value;
	var name = document.getElementById("t_name").value;
	var major = document.getElementById("t_major").value;

	// create row element	
	var row = document.createElement("tr");

	// create row cells
	var cell1 = document.createElement("td");
	var cell2 = document.createElement("td");
	var cell3 = document.createElement("td");

	// append cells to the row
	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);

	// add text
	cell1.innerHTML = id;
	cell2.innerHTML = name;
	cell3.innerHTML = major;

	// add to the table
	document.getElementById("students").appendChild(row);
	
}

//add event listener
document.getElementById("add").addEventListener("click", add, false);

var count = localStorage.on_load_counter || 0;
var button = document.getElementById("add");
var display = document.getElementById("counter");

button.onclick = function(){
  localStorage.on_load_counter = display.innerHTML = ++count;
}