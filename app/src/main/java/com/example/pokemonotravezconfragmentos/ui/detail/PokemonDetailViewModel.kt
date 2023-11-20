package com.example.pokemonotravezconfragmentos.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonotravezconfragmentos.data.api.PokemonApiModel
import com.example.pokemonotravezconfragmentos.data.api.PokemonListApiModel
import com.example.pokemonotravezconfragmentos.data.api.PokemonRepository
import com.example.pokemonotravezconfragmentos.data.model.Pokemon
import com.example.pokemonotravezconfragmentos.databinding.FragmentPokemonDetailBinding
import kotlinx.coroutines.launch

class PokemonDetailViewModel(): ViewModel() {
    private val repository = PokemonRepository.getInstance()

    private val _pokemonDetails = MutableLiveData<Pokemon>()
    val pokemonDetails: LiveData<Pokemon> = _pokemonDetails

    fun fetch(namePokemon: String) {
        // Parte 18 - Scope (Trozo de código donde puedo ejecutar corutinas)
        viewModelScope.launch {
            val pokemonApi = repository.getPokemonDetails(namePokemon)
            _pokemonDetails.value = Pokemon(pokemonApi.id, pokemonApi.name, pokemonApi.weight, pokemonApi.height, pokemonApi.front)
        }
    }

}