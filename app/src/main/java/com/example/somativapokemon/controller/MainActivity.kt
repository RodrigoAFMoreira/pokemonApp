package com.example.somativapokemon.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.somativapokemon.R
import com.example.somativapokemon.model.loreActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonLoginMain = findViewById<Button>(R.id.buttonLoginMain)
        val buttonSobreMain = findViewById<Button>(R.id.buttonSobreMain)
        val buttonCriarMain = findViewById<Button>(R.id.buttonCriarMain)

        buttonLoginMain?.setOnClickListener {
            val intent = Intent(this@MainActivity, SearchActivity::class.java)
            startActivity(intent)
        }
        buttonSobreMain?.setOnClickListener {
            val intent = Intent(this@MainActivity, loreActivity::class.java)
            startActivity(intent)
        }
        buttonCriarMain?.setOnClickListener {
            val intent = Intent(this@MainActivity, registerActivity::class.java)
            startActivity(intent)
        }



    }
}