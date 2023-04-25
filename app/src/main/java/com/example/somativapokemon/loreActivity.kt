package com.example.somativapokemon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class loreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lore)

        val buttonL = findViewById<Button>(R.id.buttonL)
        buttonL?.setOnClickListener {
                val intent = Intent(this@loreActivity, MainActivity::class.java)
                startActivity(intent)
            }
    }
}