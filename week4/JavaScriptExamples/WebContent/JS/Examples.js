var parags = document.getElementsByTagName("p");
//var pString = parags.join(" - ");
var inner;

for(i=0; i<parags.length;i++){
	//inner.push(parags[i])
}



function add(){
	//Element values retrieved from table input
	var count=0;
	var id = document.getElementById("t_id").value;
	var name = document.getElementById("t_name").value;
	var major = document.getElementById("t_major").value;
	



//Create row element
var row = document.createElement("tr");


//Create Row Cells
var cell1 = document.createElement("td");
var cell2 = document.createElement("td");
var cell3 = document.createElement("td");

//Appends the cells to the row
row.appendChild(cell1);
row.appendChild(cell2);
row.appendChild(cell3);


//Add text
cell1.innerHTML = id;
cell2.innerHTML = name;
cell3.innerHTML = major;

//append to table
document.getElementById("students").appendChild(row);

}

document.getElementById("add").addEventListener("click", add, false);
document.getElementById("count").createElement(count++);





//document.getElementById("display").innerHTML = parags[0].innerHTML;