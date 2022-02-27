package com.vclyfe.experiment.retrofitboi.model

data class PokemonListResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonListData>
)

data class PokemonListData(
    val name: String,
    val url: String
)