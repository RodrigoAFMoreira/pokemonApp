package com.example.somativapokemon.model

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.somativapokemon.R
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast

import com.example.somativapokemon.controller.UserDB

import com.example.somativapokemon.view.PokemonSearch

class RegisterActivity : AppCompatActivity() {

    private lateinit var userName: EditText
    private lateinit var userPword: EditText
    private lateinit var userCPword: EditText
    private lateinit var enterButton: Button
    private lateinit var db: UserDB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        userName = findViewById(R.id.editTextNomeRegsiter)
        userPword = findViewById(R.id.editTextTextPassword)
        userCPword = findViewById(R.id.editTextTextPassword2)
        enterButton = findViewById(R.id.buttonEntrarRegister)
        db = UserDB(this)

        enterButton.setOnClickListener{
            val unametext = userName.text.toString()
            val pwordtext = userPword.text.toString()
            val cpwordtext = userCPword.text.toString()
            val savedata = db.inserirdata(unametext,pwordtext)

            if(TextUtils.isEmpty(unametext)|| TextUtils.isEmpty(pwordtext) || TextUtils.isEmpty(cpwordtext)) {
                Toast.makeText(this, "adicione um nome..., senha... & confirme senha...", Toast.LENGTH_SHORT).show()
            }
            else{
                if(pwordtext.equals(cpwordtext)){
                    if(savedata==true){
                        Toast.makeText(this,"Conta registrada com sucesso", Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext, PokemonSearch::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,"Usuário já existe", Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(this,"Senha não se encaixa", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}