function add() {
  let id = document.getElementById('t_id').value;
  let name = document.getElementById('t_name').value;
  let major = document.getElementById('t_major').value;

  let row = document.createElement('tr');
  let cell1 = document.createElement('td');
  cell1.innerHTML = id;
  let cell2 = document.createElement('td');
  cell2.innerHTML = name;
  let cell3 = document.createElement('td');
  cell3.innerHTML = major;

  row.appendChild(cell1);
  row.appendChild(cell2);
  row.appendChild(cell3);

  document.getElementById('students').appendChild(row);
}

document.getElementById('addBtn').addEventListener("click", add, false);

function count() {
  let num = +document.getElementById('counter').innerHTML;
  document.getElementById('counter').innerHTML = num + 1;
}