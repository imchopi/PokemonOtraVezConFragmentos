package com.example.pokemonotravezconfragmentos.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonotravezconfragmentos.data.api.PokemonApiModel
import com.example.pokemonotravezconfragmentos.data.api.PokemonListApiModel
import com.example.pokemonotravezconfragmentos.data.api.PokemonListItemResponse
import com.example.pokemonotravezconfragmentos.data.api.PokemonListResponse
import com.example.pokemonotravezconfragmentos.data.api.PokemonRepository
import com.example.pokemonotravezconfragmentos.data.model.Pokemon
import kotlinx.coroutines.launch

class PokemonListViewModel(): ViewModel() {
    // Parte 18 - Referencias al repositorio
    private val repository = PokemonRepository.getInstance()

    // Parte hecha en casa 1
    private val _pokemonListUi = MutableLiveData<List<Pokemon>>()

    // Parte 20
    val pokemonListUi : LiveData<List<Pokemon>>
        get() = _pokemonListUi

    // Parte hecha en casa 1
    private val observer = Observer<PokemonListApiModel> { response ->
        _pokemonListUi.value = response.list.map {
            pokemonApiModel -> Pokemon(pokemonApiModel.id,pokemonApiModel.name, pokemonApiModel.weight, pokemonApiModel.height, pokemonApiModel.front)
        }

    }

    // Parte 19
    init {
        fetch()
    }

    // Parte 18 - Consumir la api
    private fun fetch() {
        // Parte hecha en casa 1
        repository.pokemonList.observeForever(observer)

        // Parte 18 - Scope (Trozo de código donde puedo ejecutar corutinas)
        viewModelScope.launch {
            repository.fetch()
        }
    }

    // Parte hecha en casa 1
    override fun onCleared() {
        super.onCleared()
        repository
            .pokemonList
            .removeObserver(observer)
    }

}