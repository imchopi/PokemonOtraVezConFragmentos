package com.example.pokemonotravezconfragmentos.data.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET("api/v2/pokemon/{name}/")
    suspend fun fetchPokemon(@Path("name") name: String): PokemonDetailResponse
    @GET("api/v2/pokemon/")
    suspend fun fetchPokemonList(): PokemonListResponse
}

class PokemonRepository private constructor(private val api: PokemonApi) {
    private val _pokemonList = MutableLiveData<PokemonListApiModel>()
    val pokemonList : LiveData<PokemonListApiModel>
        get() = _pokemonList

    companion object {
        private var _INSTANCE: PokemonRepository? = null

        fun getInstance(): PokemonRepository {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val pokemonApi = retrofit.create(PokemonApi::class.java)
            _INSTANCE = _INSTANCE ?: PokemonRepository(pokemonApi)
            return _INSTANCE!!
        }

    }

    suspend fun fetch() {
        val pokemonListResponse = api.fetchPokemonList()
        val detailedPokemonList = mutableListOf<PokemonApiModel>()
        pokemonListResponse.results.forEach { basicPokemon ->
            val detailResponse = api.fetchPokemon(basicPokemon.name)
            val pokemonApiModel = PokemonApiModel(
                id = detailResponse.id,
                name = detailResponse.name,
                front = detailResponse.sprites.front_default,
                weight = detailResponse.weight,
                height = detailResponse.height,
            )
            detailedPokemonList.add(pokemonApiModel)
        }

        val pokemonListApiModel = PokemonListApiModel(detailedPokemonList)
        _pokemonList.postValue(pokemonListApiModel)
    }
}