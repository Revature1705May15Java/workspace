var pokemonVar;

function getPokemon(){
	var pokemonId = document.getElementById("pokemonId").value;
	console.log("sending pokemon id: " + pokemonId);
	
	//Step 1: Open XHR
	var xhttp = new XMLHttpRequest();
	// typically we will use this to store JSON, regardless of it being
	// an "XML" request object;
	
	//Step 2: Write a function to handle the readystatechange of the response
	xhttp.onreadystatechange = function() {
		if(xhttp.readyState == 4 && xhttp.status == 200) {
			var pokemon = JSON.parse(xhttp.responseText);
			setValues(pokemon);
			pokemonVar = pokemon;
		}
	};
	
	//Step 3: Open xhttp
	xhttp.open("GET", "http://pokeapi.co/api/v2/pokemon/" + pokemonId, true);
	
	//Step 4: Send
	xhttp.send(); // post our data w/ get method
}
function setValues(pokemon){
	document.getElementById("pokemonName").innerHTML = pokemon.name;
	var pokeImg = document.getElementById("pokemonImg");
	pokeImg.setAttribute("alt", pokemon.name);
	pokeImg.setAttribute("src", pokemon.sprites.front_default);
	pokeImg.setAttribute("width", 200);
	pokeImg.setAttribute("height", 200);
	document.getElementById("extra1").innerHTML = "Weight: " + pokemon.weight;
	document.getElementById("extra2").innerHTML = "Height: " + pokemon.height;
}


window.onload = function(){
	document.getElementById("pokemonSubmit").addEventListener("click", getPokemon);
	// bubble b. capture boolean = undefined = falsy = bubble
}