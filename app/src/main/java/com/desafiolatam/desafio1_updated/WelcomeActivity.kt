package com.desafiolatam.desafio1_updated

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    lateinit var nameUser: TextView
    lateinit var advance: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        sharedPreferences = getSharedPreferences("com.desafiolatam.desafio1_updated", Context.MODE_PRIVATE)
        nameUser = findViewById(R.id.welcome_name)
        advance = findViewById(R.id.advance_button)
        setUpViewsAndListener()
    }

    private fun setUpViewsAndListener() {
        val userName = sharedPreferences.getString("CURRENT_USER","") // obtener el nombre de usuario de alguna manera y mostrarlo en nameUser
        nameUser.text = userName
        advance.setOnClickListener {
            //Agregar los pasos necesarios para manejar la persistencia
            //de cuando un usuario ve la pantalla de bienvenida la primera vez
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}