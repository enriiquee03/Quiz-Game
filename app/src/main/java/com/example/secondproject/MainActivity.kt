package com.example.secondproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    lateinit var play :Button
    lateinit var nombre : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        play= findViewById(R.id.play)
        nombre = findViewById(R.id.name_game)

        play.setOnClickListener {
            if(validatename(nombre.text.toString())){
                Global.nombre = nombre.text.toString()
                empezarjuego()
            }else{
                Toast.makeText(applicationContext,"Introduce un nombre valido", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //validar nombre
    fun validatename(name: String): Boolean {
        val p = Pattern.compile("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*\$")
        val m = p.matcher(name)
        return m.matches()
    }
    // pasar al siguiente activity
    fun empezarjuego(){
        val i = Intent(applicationContext,selectquiz::class.java)
        startActivity(i)
    }
}