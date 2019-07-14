var pokemonVar;

function getPokemon(){
	var pokemonId = document.getElementById("pokemonId").value;
	console.log("sending pokemon id: " + pokemonId);
	
	//Step 1: Open XHR
	var xhttp = new XMLHttpRequest();
	// typically we will use this to store JSON, regardless of it being 
	// an "XML" request object
	
	
	// Step 2: write function to handle the readystatechange of the response
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState==4 &&  xhttp.status==200){
			var pokemon = JSON.parse(xhttp.responseText);
			setValues(pokemon);
			pokemonVar = pokemon;
		}
	};
	
	// Step 3: open xhhtp
	xhttp.open("GET", "http://pokeapi.co/api/v2/pokemon/"+pokemonId, true);
	
	//Step 4: send
	xhttp.send();// post our data w. get method 
}

function setValues(pokemon){
	document.getElementById("pokemonName").innerHTML = "Name: " + pokemon.name;
	document.getElementById("pokemonWeight").innerHTML = "Weight:  " + pokemon.weight;
	document.getElementById("pokemonType").innerHTML = "Type:  " + pokemon.types[0].type.name;
	var pokeImg = document.getElementById("pokemonImg");
	pokeImg.setAttribute("alt", pokemon.name);
	pokeImg.setAttribute("src", pokemon.sprites.front_shiny);
}

window.onload = function(){
	document.getElementById("pokemonSubmit").addEventListener("click", getPokemon);
// bubble v capture boolean = undefined = falsy = bubble
}