@file:Suppress("DEPRECATION")

package com.example.somativapokemon.controller

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.somativapokemon.R
import com.example.somativapokemon.model.Pokemon
import com.example.somativapokemon.model.PokemonType
import com.example.somativapokemon.view.PokemonAdapter

class SearchActivity : AppCompatActivity() {

    val REQUEST_IMAGE_CAPTURE = 100
    val PERMISSION_REQUEST_CODE = 200
    lateinit var imageView: ImageView
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val recyclerViewSearch = findViewById<RecyclerView>(R.id.recyclerViewSearch)
        val Zigzagoon = Pokemon(
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/263.png",
            3,
            "Zigzagoon",
            listOf(
                PokemonType("Normal")
            )
        )
        val pokemons = listOf(Zigzagoon, Zigzagoon, Zigzagoon)
        val layoutManager = LinearLayoutManager(this)
        recyclerViewSearch.layoutManager = layoutManager
        recyclerViewSearch.adapter = PokemonAdapter(pokemons)

        imageView = findViewById(R.id.imageViewSearch)
        button = findViewById(R.id.buttonSearch)


        if (checkPermission()) {
            button.setOnClickListener {
                val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                try {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                } catch (e: ActivityNotFoundException) {
                    Toast.makeText(this, "Error: " + e.localizedMessage, Toast.LENGTH_SHORT).show()
                }
            }
        }


        button.setOnClickListener{
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            try{
                startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE)
            }catch (e: ActivityNotFoundException){
                Toast.makeText(this,"Error: "+ e.localizedMessage,Toast.LENGTH_SHORT).show()
            }
        }
        }
    private fun checkPermission(): Boolean {
        return if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermission()
            true
        } else false
    }
    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this, arrayOf<String>(android.Manifest.permission.CAMERA),
            PERMISSION_REQUEST_CODE
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}