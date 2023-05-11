package com.example.somativapokemon.controller

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.somativapokemon.R
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast
import com.example.somativapokemon.view.search.SearchActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var uname: EditText
    private lateinit var pword: EditText
    private lateinit var cpword: EditText
    private lateinit var signupbtn: Button
    private lateinit var db: UserDB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        uname = findViewById(R.id.editTextNomeRegsiter)
        pword = findViewById(R.id.editTextTextPassword)
        cpword = findViewById(R.id.editTextTextPassword2)
        signupbtn = findViewById(R.id.buttonEntrarRegister)
        db = UserDB(this)

        signupbtn.setOnClickListener{
            val unametext = uname.text.toString()
            val pwordtext = pword.text.toString()
            val cpwordtext = cpword.text.toString()
            val savedata = db.inserirdata(unametext,pwordtext)

            if(TextUtils.isEmpty(unametext)|| TextUtils.isEmpty(pwordtext) || TextUtils.isEmpty(cpwordtext)) {
                Toast.makeText(this, "adicione um nome..., senha... & confirme senha...", Toast.LENGTH_SHORT).show()
            }
            else{
                if(pwordtext.equals(cpwordtext)){
                    if(savedata==true){
                        Toast.makeText(this,"Conta registrada com sucesso", Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext, SearchActivity::class.java)
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