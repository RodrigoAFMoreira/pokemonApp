package com.example.somativapokemon.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.somativapokemon.R
import com.example.somativapokemon.controller.MainActivity

class LoreActivity : AppCompatActivity() {
    private lateinit var btnLore: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lore)

        btnLore = findViewById<Button>(R.id.buttonL)
        btnLore.setOnClickListener {
                val intent = Intent(this@LoreActivity, MainActivity::class.java)
                startActivity(intent)
            }
    }
}