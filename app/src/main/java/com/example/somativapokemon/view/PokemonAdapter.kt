package com.example.somativapokemon.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.somativapokemon.R
import com.example.somativapokemon.model.Pokemon

class PokemonAdapter(
    val items: List<Pokemon>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_search, parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item)
    }
class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bindView(item: Pokemon) = with(itemView){
            val imageViewPokemon = findViewById<ImageView>(R.id.imageViewPokemon)
            val tvNumber = findViewById<TextView>(R.id.tvNumber)
            val textViewNumberPokemon = findViewById<TextView>(R.id.textViewNumberPokemon)
            val textViewTipo1 = findViewById<TextView>(R.id.textViewTipo1)
            val textViewTipo2 = findViewById<TextView>(R.id.textViewTipo2)

            tvNumber.text = "№ ${item.number}"
            textViewNumberPokemon.text = item.name
            textViewTipo1.text= item.types[0].name

            if (item.types.size > 1){
                textViewTipo2.text= item.types[1].name
                } else{
                    textViewTipo2.visibility = View.GONE
                }
            }
        }
}


