package com.example.somativapokemon.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.somativapokemon.R
import com.example.somativapokemon.model.pokemon

class pokemonAdapter(
    val items: List<pokemon>
) : RecyclerView.Adapter<pokemonAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_search, parent,false)
        return ViewHolder(view)
    }
    //42:40
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item)
    }
    //52:40
class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: pokemon) = with(itemView){
            val imageViewPokemon = findViewById<ImageView>(R.id.imageViewPokemon)
            //val tvNumber = findViewById<ImageView>(R.id.tvNumber)
           //val textViewTipo1 = findViewById<ImageView>(R.id.textViewTipo1)
            //val textViewTipo2 = findViewById<ImageView>(R.id.textViewTipo2)
            }
        }
}


