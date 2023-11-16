package com.example.pokemonotravezconfragmentos.data.api

data class PokemonListApiModel(
    val list:List<PokemonApiModel>
)

data class PokemonApiModel(
    val id:Int,
    val name:String,
    val weight:Int,
    val height:Int,
    val front:String
)
