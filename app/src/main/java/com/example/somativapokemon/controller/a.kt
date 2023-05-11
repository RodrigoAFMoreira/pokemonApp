package com.example.somativapokemon.controller

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.somativapokemon.view.search.SearchAdapter

class a (
    val pokemonClick: (Int) -> Unit):RecyclerView.Adapter<SearchAdapter.SearchViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchAdapter.SearchViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: SearchAdapter.SearchViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}

