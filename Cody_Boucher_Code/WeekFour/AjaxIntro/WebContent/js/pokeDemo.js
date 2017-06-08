var pokemonVar;

function getPokemon() {
	var pokemonId = document.getElementById("pokemonId").value;
	console.log("sending pokemon id: " + pokemonId);
	//open xhr
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if(xhttp.readyState == 4 && xhttp.status == 200) {
			var pokemon = JSON.parse(xhttp.responseText);
			setValues(pokemon);
			pokemonVar = pokemon;
		}
	};
	xhttp.open("GET", "http://pokeapi.co/api/v2/pokemon/"+pokemonId, true);
	xhttp.send();
}

function setValues(pokemon){
	document.getElementById("pokemonName").innerHTML = pokemon.name;
	document.getElementById("pokemonWeight").innerHTML = "weight: " + pokemon.weight;
	document.getElementById("pokemonHeight").innerHTML = "height: " + pokemon.height;
	var pokeImg = document.getElementById("pokemonImg");
	pokeImg.setAttribute("alt", pokemon.name);
	pokeImg.setAttribute("src", pokemon.sprites.front_shiny);
}

window.onload = function() {
	document.getElementById("pokemonSubmit").addEventListener("click", getPokemon);
}

