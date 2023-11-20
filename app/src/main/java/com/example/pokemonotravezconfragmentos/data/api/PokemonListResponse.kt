package com.example.pokemonotravezconfragmentos.data.api

data class PokemonListResponse(
    val results: List<PokemonListItemResponse>
)

data class PokemonListItemResponse(
    val name:String
)

data class PokemonDetailResponse(
    val id:Int,
    val name:String,
    val weight: Double,
    val height: Double,
    val sprites: PokemonSpritesResponse
)

data class PokemonSpritesResponse(
    val front_default:String
)