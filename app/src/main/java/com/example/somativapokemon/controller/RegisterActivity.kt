package com.example.somativapokemon.controller

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.somativapokemon.R

class registerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val buttonEntrarRegister = findViewById<Button>(R.id.buttonEntrarRegister)

        buttonEntrarRegister?.setOnClickListener {
                val intent = Intent(this@registerActivity, SearchActivity::class.java)
                startActivity(intent)
            }
    }
}