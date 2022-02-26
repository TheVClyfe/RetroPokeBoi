package com.vclyfe.experiment.retrofitboi.api

import com.vclyfe.experiment.retrofitboi.model.PokemonDetailsModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("/api/v2/pokemon/{pokemonName}")
    fun getPokemonDetails(@Path("pokemonName") pokemonName: String): Single<PokemonDetailsModel>
}