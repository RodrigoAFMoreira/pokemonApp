package com.example.somativapokemon.view.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.somativapokemon.model.PokeResult
import com.example.somativapokemon.model.PokemonRepository
import com.example.somativapokemon.service.PokemonApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchViewModel() : ViewModel() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: PokemonApiService = retrofit.create(PokemonApiService::class.java)

    val pokemonList = MutableLiveData<List<PokeResult>>()

    fun getPokemonList(){
        val call = service.getPokemonList(100,0)

        call.enqueue(object : Callback<PokemonRepository>{
            override fun onResponse(call: Call<PokemonRepository>,response: Response<PokemonRepository>) {
                response.body()?.results?.let { list ->
                    pokemonList.postValue(list)
                }

            }

            override fun onFailure(call: Call<PokemonRepository>, t: Throwable) {
                call.cancel()
            }

        })
    }
}