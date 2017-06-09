const pokeLyrics = "I wanna be, the very best Like no one ever was. To catch them is my real test, To train them is my cause. I will travel across the land, Searching far and wide. Each pokemon to understand The power thats inside. Pokemon! Gotta Catch 'em! It's you and me! I know it's my destiny! Pokemon! Ohh You're my best friend In a world we must defend! Pokemon! Gotta Catch 'em! A heart so true! Our courage will pull us through. You teach me and I'll teach you Pokemon! Gotta Catch 'em All! Gotta Catch 'em All... Every challenge along the way, With Courage I will face. I will battle everyday, To claim my rightful place. Come with me, The time is right. There's no better team. Arm in arm we'll win the fight, It's always been our dream! Pokemon! Gotta Catch 'em! It's you and me! I know it's my destiny! Pokemon! Ohh You're my best friend In a world we must defend! Pokemon! Gotta Catch 'em! A heart so true! Our courage will pull us through. You teach me and I'll teach you Pokemon! Gotta Catch 'em All! Gotta Catch 'em All... Gotta Catch 'em All!!!! Gotta Catch 'em All! Yeah ah! Pokemon! Gotta Catch 'em! It's you and me! I know it's my destiny! Pokemon! Ohh You're my best friend In a world we must defend! Pokemon! Gotta Catch 'em! A heart so true! Our courage will pull us through. You teach me and I'll teach you Pokemon! Gotta Catch 'em All! Gotta Catch 'em All...";
let pokemonVar;

function getPokemon() {
  let pokemonId = $('#pokemonId').val();
  console.log('sending pokemon id: ' + pokemonId);

  let xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function () {
    if (xhr.readyState == 4 && xhr.status == 200) {
      let pokemon = JSON.parse(xhr.responseText);
      setValues(pokemon);
      pokemonVar = pokemon;
    }
  }
  xhr.open('GET', 'http://pokeapi.co/api/v2/pokemon/' + pokemonId, true);
  xhr.send();
}

function setValues(pokemon) {
  $('#pokemonName').html(pokemon.name);
  let pokeImg = document.getElementById('pokemonImg');
  pokeImg.setAttribute('alt', pokemon.name);
  pokeImg.setAttribute('src', pokemon.sprites.front_default);
  $('#pokemonType').html('Type: ' + pokemon.types.map(t => t.type.name).join(', '));
  $('#pokemonHeight').html('Height: ' + pokemon.height);
  $('#pokemonWeight').html('Weight: ' + pokemon.weight);
}

window.onload = function () {
  $('#lyrics').html(pokeLyrics);
  $('#pokemonSubmit').on('click', getPokemon);
  $('#pokemonId').keydown(function(e) {
  if (e.keyCode == 13) {
    getPokemon();
  }
});
}
