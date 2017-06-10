var pokemonVar;

function getPokemon() {
	 //var pokemonId = document.getElementById("pokemonId").value
	var pokemonId = $("#pokemonId").val();
	console.log("sending pokemon is: " + pokemonId);
	
	// Step 1: Open XHR
	var xhttp = new XMLHttpRequest();
	
	// typically we will use this store JSON, regardless of it being an "XML" request object
	
	// Step 2: write function to handle the readystatechange of the response
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			var pokemon = JSON.parse(xhttp.responseText);
			setValues(pokemon);
			pokemonVar = pokemon;
		}
	};
	
	// Step 3: open xhttp
	xhttp.open("GET", "http://pokeapi.co/api/v2/pokemon/" + pokemonId, true);
	
	// Step 4: send
	xhttp.send(); // post our datat with get method
}

function setValues(pokemon) {
	//document.getElementById("pokemonName").innerHTML = pokemon.name;
	$("#pokemonName").html(pokemon.name);
	$("#weight").html("Weight: " + (pokemon.weight / 10) + " kg");
	$("#height").html("Height: " + (pokemon.height / 10) + " m");
	//var pokeImg = document.getElementById("pokemonImg");
	var pokeImg = $("#pokemonImg");
	//pokeImg.setAttribute("alt", pokemon.name);
	//pokeImg.setAttribute("src", pokemon.sprites.front_shiny);
	pokeImg.attr("alt", pokemon.name);
	pokeImg.attr("src", pokemon.sprites.front_default);
}

window.onload = function() {
	//document.getElementById("pokemonSubmit").addEventListener("click", getPokemon);
	$("#pokemonSubmit").on("click", getPokemon);
	// buuble v capture boolean = undefined = falsy = bubble
}