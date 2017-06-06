let pars = document.getElementsByTagName("p");
let parStr = "";

for (var i = 0; i < pars.length; i++) {
    parStr += pars[i].innerHTML + " - ";
}

document.getElementById("display").innerHTML = parStr;
