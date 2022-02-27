package com.vclyfe.experiment.retrofitboi.api

import com.vclyfe.experiment.retrofitboi.model.PokemonDetailsModel
import com.vclyfe.experiment.retrofitboi.model.PokemonListResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("/api/v2/pokemon/{pokemonName}")
    fun getPokemonDetails(@Path("pokemonName") pokemonName: String): Single<PokemonDetailsModel>

    @GET("/api/v2/pokemon/")
    fun getPokemonList(@Query("offset") offset: String?, @Query("limit") limit: String?): Single<PokemonListResponse>
}