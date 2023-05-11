package com.example.somativapokemon.view.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.somativapokemon.R
import com.example.somativapokemon.model.PokeResult
import com.example.somativapokemon.databinding.CardPokemonSearchBinding


class SearchAdapter(
    val pokemonClick: (Int) -> Unit): RecyclerView.
Adapter<SearchAdapter.SearchViewHolder>() {

    //private lateinit var binding: CardPokemonSearchBinding

    var pokemonList: List<PokeResult> = emptyList<PokeResult>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_pokemon_search, parent,false))

        //binding = CardPokemonSearchBinding.inflate(layoutInflater)
        //setContentView(binding.root)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {

        val pokemon = pokemonList[position]

        holder.binding.itemView.pokemonText.text = "#${position + 1} - ${pokemon.name}"
        holder.itemView.setOnClickListener { pokemonClick(position + 1) }
    }

    class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    fun setData(list: List<PokeResult>){
        pokemonList = list
        notifyDataSetChanged()
    }

}

// dúvida