var pars = document.getElementsByTagName("p");

var parStr = '';
for (var i = 0; i < pars.length; i++) {
   parStr += pars[i].innerHTML + ' - ';
}

document.getElementById("display").innerHTML = parStr;
