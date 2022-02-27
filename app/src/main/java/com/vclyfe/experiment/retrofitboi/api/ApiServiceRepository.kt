package com.vclyfe.experiment.retrofitboi.api

import com.vclyfe.experiment.retrofitboi.model.PokemonDetailsModel
import com.vclyfe.experiment.retrofitboi.model.PokemonListResponse
import io.reactivex.rxjava3.core.Single

interface ApiServiceRepository {
    fun getPokemonDetails(pokemonName: String): Single<PokemonDetailsModel>
    fun getPokemonList(limit: String?, offset: String?): Single<PokemonListResponse>
}