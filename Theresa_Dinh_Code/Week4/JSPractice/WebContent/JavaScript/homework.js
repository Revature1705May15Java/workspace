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

function reverseStr(someStr)
{
	var str = "";
	var array = someStr.split(""); 
	for(var s in array)
		str += array[s]
	return str; 
}	
