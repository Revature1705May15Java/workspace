/**
 * 
 */
function fib(n){
	var num = 0;
	var num2 = 1; 
	var temp = 1; 
	for(i = 0; i < n-2; i++)
	{
		num += num2; 
		num2 = temp; 
		temp = num; 
	}
	return num;
}

elem = document.getElementById("fib"); 
elem.innerHTML=fib(4);

var parags = document.getElementsByTagName("p"); 
//var inner;
//for(i = 0; i < parags.length; i++)
//	{
//		inner.push(parags[i].innerHTML); 
//	}

document.getElementById("display").innerHTML = parags[0].innerHTML;

//var x = fib(5); 
//elem.appendChild(x); 
