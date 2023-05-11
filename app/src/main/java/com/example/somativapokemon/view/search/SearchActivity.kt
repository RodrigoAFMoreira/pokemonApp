package com.example.somativapokemon.view.search

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.somativapokemon.view.pokemon.PokemonActivity
import com.example.somativapokemon.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    private lateinit var viewModel: SearchViewModel
    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

            viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

            initUI()
        }

        private fun initUI(){
            binding.recyclerViewSearch.layoutManager = LinearLayoutManager(this)
            binding.recyclerViewSearch.adapter = SearchAdapter{
                val intent = Intent(this, PokemonActivity::class.java)
                intent.putExtra("id", it)
                startActivity(intent)
            }

            viewModel.getPokemonList()

            viewModel.pokemonList.observe(this, Observer { list ->
                (binding.recyclerViewSearch.adapter as SearchAdapter).setData(list)
            })
        }
}
