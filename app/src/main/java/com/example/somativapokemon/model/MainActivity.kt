package com.example.somativapokemon.model

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.somativapokemon.R
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast
import com.example.somativapokemon.controller.UserDB
import com.example.somativapokemon.view.LoreActivity

class MainActivity : AppCompatActivity() {

    private lateinit var loginButton: Button
    private lateinit var registerButton: Button
    private lateinit var loreButton: Button
    private lateinit var editUser: EditText
    private lateinit var editPword: EditText
    private lateinit var db: UserDB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton = findViewById(R.id.buttonLoginMain)
        editUser = findViewById(R.id.editTextNomeMain)
        editPword = findViewById(R.id.editTextSenhaMain)
        db = UserDB(this)

        loginButton.setOnClickListener{
            val useredtx = editUser.text.toString()
            val passedtx = editPword.text.toString()

            if(TextUtils.isEmpty(useredtx)|| TextUtils.isEmpty(passedtx)){
                Toast.makeText(this,"adicione nome... & senha...", Toast.LENGTH_SHORT).show()
            }
            else{
                val checkuser = db.checkuserpass(useredtx, passedtx)
                if(checkuser==true){
                    Toast.makeText(this,"login feito com sucesso", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this,"nome... & senha... errado(s)", Toast.LENGTH_SHORT).show()
                }
            }
        }
        loreButton = findViewById<Button>(R.id.buttonSobreMain)
        loreButton.setOnClickListener {
            val intent = Intent(this@MainActivity, LoreActivity::class.java)
            startActivity(intent)
        }
        registerButton = findViewById<Button>(R.id.buttonCriarMain)
        registerButton.setOnClickListener {
            val intent = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}