package com.vclyfe.experiment.retrofitboi.api

import com.vclyfe.experiment.retrofitboi.model.PokemonDetailsModel
import io.reactivex.rxjava3.core.Single

interface ApiServiceRepository {
    fun getPokemonDetails(pokemonName: String): Single<PokemonDetailsModel>
}