var pokemonVar;

function getPokemon()
{
    var pokemonId = document.getElementById("pokemonid").value; 
    console.log("sending pokemon id: " + pokemonId);
    
    // open xhr
    var xhttp = new XMLHttpRequest();
    // use to store json 
    
    // function for handling readystatechange of resposne
    xhttp.onreadystatechange = function()
    {
        if(xhttp.readyState == 4 && xhttp.status == 200)
        {
            var pokemon = JSON.parse(xhttp.responseText);
            setValues(pokemon); 
            pokemonVar = pokemon; 
        }
    };
    
    //open xhttp
    xhttp.open("GET", "http://pokeapi.co/api/v2/pokemon/"+pokemonId, true); 
    
    // send
    xhttp.send();   //post data with get method
}

function setValues(pokemon)
{
    document.getElementById("pokemonName").innerHTML = pokemon.name;
    var pokeImg = document.getElementById("pokemonImg"); 
    pokeImg.setAttribute("alt", pokemon.name); 
    pokeImg.setAttribute("src", pokemon.sprites.front_shiny);
    document.getElementById("pokemonSpecies").innerHTML = "species: " + pokemon.species.name;
    document.getElementById("pokemonType1").innerHTML = "type 1: " + pokemon.types[0].type.name;
    document.getElementById("pokemonType2").innerHTML = "type 2: " + pokemon.types[1].type.name;
}

window.onload = function()
{
    document.getElementById("pokemonsubmit").addEventListener("click", getPokemon); 
};