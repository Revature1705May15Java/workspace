var pokemonVar;
function getPokemon(){
	
	var pokemonId = document.getElementById("pokemonId").value;
	console.log("Sending pokemon ID: " + pokemonId)
	//Step 1. Open XHR
	var xhttp = new XMLHttpRequest(); //Usually JSON now, ignore the XML
	
	//Step 2. function to handle ready state change of the response
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			//We know 
			var pokemon = JSON.parse(xhttp.responseText);
			setValues(pokemon);
			pokemonVar = pokemon;
		}
	};
															//false would synchronous
	//Step 3 Open											//true uses asynchronous
	xhttp.open("GET","http://pokeapi.co/api/v2/pokemon/" + pokemonId, true);
	//Step 4 Send it
	xhttp.send(); //Post data
	
}


function setValues(pokemon){
	document.getElementById("pokemonName").innerHTML = pokemon.name + " " 
						+ "<br>" + pokemon.stats[0].stat.name + ": " + pokemon.stats[0].base_stat
						+ "<br>" +  pokemon.stats[1].stat.name + ": " + pokemon.stats[1].base_stat
						+ "<br>" +  pokemon.stats[2].stat.name + ": " + pokemon.stats[2].base_stat;
	var pokeImg = document.getElementById("pokemonImg");
	pokeImg.setAttribute("src",pokemon.sprites.front_shiny);
	pokeImg.setAttribute("alt", pokemon.name);
}



window.onload = function(){
	
	document.getElementById("pokemonSubmit").addEventListener("click", getPokemon); //not adding useCapture
																					//undefine = falsy
	
}