package com.example.somativapokemon.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.somativapokemon.R
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast
import com.example.somativapokemon.model.UserDB

class MainActivity : AppCompatActivity() {

    private lateinit var loginbtn: Button
    private lateinit var registerbtn: Button
    private lateinit var lorebtn: Button
    private lateinit var edituser: EditText
    private lateinit var editpword: EditText
    private lateinit var dbh: UserDB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginbtn = findViewById(R.id.buttonLoginMain)
        edituser = findViewById(R.id.editTextNomeMain)
        editpword = findViewById(R.id.editTextSenhaMain)
        dbh = UserDB(this)
        lorebtn = findViewById<Button>(R.id.buttonSobreMain)
        registerbtn = findViewById<Button>(R.id.buttonCriarMain)

        loginbtn.setOnClickListener{
            val useredtx = edituser.text.toString()
            val passedtx = editpword.text.toString()

            if(TextUtils.isEmpty(useredtx)|| TextUtils.isEmpty(passedtx)){
                Toast.makeText(this,"adicione nome... & senha...", Toast.LENGTH_SHORT).show()
            }
            else{
                val checkuser = dbh.checkuserpass(useredtx, passedtx)
                if(checkuser==true){
                    Toast.makeText(this,"login feito com sucesso", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this,"nome... & senha... errado(s)", Toast.LENGTH_SHORT).show()
                }
            }
        }
        lorebtn.setOnClickListener {
            val intent = Intent(this@MainActivity, LoreActivity::class.java)
            startActivity(intent)
        }
        registerbtn.setOnClickListener {
            val intent = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}