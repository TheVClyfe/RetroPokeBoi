package com.vclyfe.experiment.retrofitboi.api

import com.vclyfe.experiment.retrofitboi.model.PokemonDetailsModel
import com.vclyfe.experiment.retrofitboi.model.PokemonListResponse
import io.reactivex.rxjava3.core.Single

class ApiServiceImpl: ApiServiceRepository {

    private val apiRetrofitClient = APIClient.getRetrofitClient("https://pokeapi.co/")
    private val apiService = apiRetrofitClient.create(ApiInterface::class.java)

    override fun getPokemonDetails(pokemonName: String): Single<PokemonDetailsModel> {
        return apiService.getPokemonDetails(pokemonName)
    }

    override fun getPokemonList(limit: String?, offset: String?): Single<PokemonListResponse> {
        return apiService.getPokemonList(offset, limit)
    }
}