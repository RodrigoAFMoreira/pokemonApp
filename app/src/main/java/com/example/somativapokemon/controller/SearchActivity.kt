package com.example.somativapokemon.controller

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.somativapokemon.R
import com.example.somativapokemon.databinding.ActivitySearchBinding
import com.example.somativapokemon.model.Pokemon
import com.example.somativapokemon.model.PokemonType
import com.example.somativapokemon.view.PokemonAdapter
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener

@Suppress("DEPRECATION")
class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_search)
        //
        val recyclerViewSearch = findViewById<RecyclerView>(R.id.recyclerViewSearch)

        val Zigzagoon = Pokemon(
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/263.png",
            3,
            "Zigzagoon",
            listOf(
                PokemonType("Normal")
            )
        )
        val pokemons = listOf(Zigzagoon,Zigzagoon,Zigzagoon)

        val layoutManager = LinearLayoutManager(this)

        recyclerViewSearch.layoutManager = layoutManager
        recyclerViewSearch.adapter = PokemonAdapter(pokemons)

        binding.imageViewSearch.setOnClickListener{
            cameraCheckPermission()
        }
    }
    private fun cameraCheckPermission() {
        Dexter.withContext(this)
            .withPermissions(
                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                android.Manifest.permission.CAMERA).withListener(
                object : MultiplePermissionsListener {
                    override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
                        report?.let {
                            if (report.areAllPermissionsGranted()) {
                                camera()
                            }
                        }
                    }
                    override fun onPermissionRationaleShouldBeShown(
                        p0: MutableList<PermissionRequest>?,
                        p1: PermissionToken?) {
                    }
                }
            ).onSameThread().check()
    }
    private fun camera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, CAMERA_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                CAMERA_REQUEST_CODE -> {
                    val bitmap = data?.extras?.get("data") as Bitmap
                    binding.imageViewSearch.load(bitmap) {
                    }
                }
            }
        }
    }
    companion object {
        private const val CAMERA_REQUEST_CODE = 1
    }
}