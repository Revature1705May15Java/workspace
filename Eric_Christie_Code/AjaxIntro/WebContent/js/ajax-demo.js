function getText() {
  let xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (xhr.readyState == 4 && xhr.status == 200) {
      document.getElementById("stuff").innerHTML = xhr.responseText;
    }
  };
  xhr.open("GET", 'ajaxGetText', true);
  xhr.send();
};
// document.getElementById('myBtn').addEventListener('click', getText, false);

let p1;
function handleEvent() {
  let xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (xhr.readyState == 4 && xhr.status == 200) {
      p1 = JSON.parse(xhr.responseText);
      document.getElementById('stuff').innerHTML = p1.name + " is " + p1.age + " years old. His intersts are: ";
    }
  };
  xhr.open('GET', 'ajaxGetJson', true);
  xhr.send();
}
// document.getElementById('myBtn').addEventListener('click', handleEvent, false);

let p2;
function jqHandleEvent() {
  $.ajax({
    url: 'AjaxJackson',
    method: 'get',
    success: function(res, status, xhr) {
      console.log('success');
      console.log(res);
      p2 = res;
      $('#stuff').html(res.name + "makes $" + res.income + "his interests include " + res.interests.join(', '));
    },
    error: function(xhr, status) {
      console.log('YOUR INTERNET SUCKS! FIND A BETTER CONNECTION!');
    },
    complete: function(xhr, status) {
      console.log("I'm done now");
    }
  });
}
$('#myBtn').on('click', jqHandleEvent);
