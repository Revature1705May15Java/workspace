// let pars = document.getElementsByTagName("p");
// let parStr = "";
//
// for (var i = 0; i < pars.length; i++) {
//     parStr += pars[i].innerHTML + " - ";
// }
//
// document.getElementById("display").innerHTML = parStr;


var count = 0;
var updateCount = function() {
    document.getElementById('counter').innerHTML = count;
    count++;
};

updateCount();

var add = function () {
    updateCount();

    var id = document.getElementById('t_id').value;
    var name = document.getElementById('t_name').value;
    var major = document.getElementById('t_major').value;
    document.getElementById('t_id').value = '';
    document.getElementById('t_name').value = '';
    document.getElementById('t_major').value = '';

    var row = document.createElement('tr');

    var cell1 = document.createElement('td');
    var cell2 = document.createElement('td');
    var cell3 = document.createElement('td');

    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);

    cell1.innerHTML = id;
    cell2.innerHTML = name;
    cell3.innerHTML = major;

    document.getElementById('students').appendChild(row);
};

document.getElementById('add').onclick = add;

// false is bubbling vs capture
// document.getElementById('add').addEventListener('click', add, false);

document.getElementById('myForm').addEventListener('click', function() {
    alert('formm');
}, false);

document.getElementById('myDiv').addEventListener('click', function() {
    alert('my div');
}, false);

document.getElementById('myP').addEventListener('click', function() {
    alert('ppppp');
}, false);
