package com.example.pokemonotravezconfragmentos.data.api

data class PokemonListApiModel(
    val list:List<PokemonApiModel>
)

data class PokemonApiModel(
    val id:Int,
    val name:String,
    val weight:Double,
    val height:Double,
    val front:String
)
