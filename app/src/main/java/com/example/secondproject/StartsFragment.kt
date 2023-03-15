package com.example.secondproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.FrameLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.bottomnavigation.BottomNavigationView

class StartsFragment : AppCompatActivity() {

    lateinit var  text : TextView
    lateinit var  navigation : BottomNavigationView

    //METODO BARRA DE NAVEGACION PREGUNTAS(FRAGMENT MANAGER)
    private val opcNavMenu = BottomNavigationView.OnNavigationItemSelectedListener { item->
        if(Global.comp1 || Global.comp2 || Global.comp3 || Global.comp4 ) {
            when (item.itemId) {
                R.id.itemcheckbox1 -> {
                    if (Global.question == 0) {
                        supportFragmentManager.commit {
                            replace<CheckBoxFragment>(R.id.framecontainer)
                            setReorderingAllowed(true)
                            addToBackStack("replacement")
                            Global.changenquestion(1)
                            Global.resetcomp()
                            Toast.makeText(
                                applicationContext,
                                "Sigue Asi!!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        navigation.menu.findItem(R.id.itemcheckbox1).isCheckable = false
                    }
                    return@OnNavigationItemSelectedListener true
                }
                R.id.itemcheckbox2 -> {
                    if (Global.question == 1) {
                        supportFragmentManager.commit {
                            replace<CheckBoxFragment2>(R.id.framecontainer)
                            setReorderingAllowed(true)
                            addToBackStack("replacement")
                            Global.changenquestion(2)
                            sumarpuntuacionp1()
                            Global.resetcomp()
                            Toast.makeText(
                                applicationContext,
                                "Vas Muy Bien!!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        navigation.menu.findItem(R.id.itemcheckbox2).isCheckable = false
                    }
                    return@OnNavigationItemSelectedListener true
                }

                R.id.itemcheckbox3 -> {
                    if (Global.question == 2) {
                        supportFragmentManager.commit {
                            replace<CheckBoxFragment3>(R.id.framecontainer)
                            setReorderingAllowed(true)
                            addToBackStack("replacement")
                            Global.changenquestion(3)
                            sumarpuntuacionp2()
                            Global.resetcomp()
                            Toast.makeText(
                                applicationContext,
                                "Ya Queda Menos!!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        navigation.menu.findItem(R.id.itemcheckbox3).isCheckable = false
                    }
                    return@OnNavigationItemSelectedListener true
                }
                R.id.itemradiobutton -> {
                    if (Global.question == 3) {
                        supportFragmentManager.commit {
                            replace<RadioButtonFragment>(R.id.framecontainer)
                            setReorderingAllowed(true)
                            addToBackStack("replacement")
                            Global.changenquestion(4)
                            sumarpuntuacionp3()
                            Global.resetcomp()
                            Toast.makeText(
                                applicationContext,
                                "Genial!!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        navigation.menu.findItem(R.id.itemradiobutton).isCheckable = false
                    }
                    return@OnNavigationItemSelectedListener true
                }
                R.id.itemedittext -> {
                    if (Global.question == 4) {
                        supportFragmentManager.commit {
                            replace<EditTextFragment>(R.id.framecontainer)
                            setReorderingAllowed(true)
                            addToBackStack("replacement")
                            Global.changenquestion(5)
                            sumarpuntuacionp4()
                            Global.resetcomp()
                        }
                    } else {
                        navigation.menu.findItem(R.id.itemedittext).isCheckable = false
                    }
                    return@OnNavigationItemSelectedListener true
                }
            }
        }else{
            Toast.makeText(applicationContext,"Debes Responder a la pregunta o esa pregunta ya ha sido contestada",Toast.LENGTH_SHORT).show()
        }
            false

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.starts_fragments)
        navigation = findViewById(R.id.navMenu)
        navigation.setOnNavigationItemSelectedListener(opcNavMenu)

        supportFragmentManager.commit {
            replace<CheckBoxFragment>(R.id.framecontainer)
            setReorderingAllowed(true)
            addToBackStack("replacement")
            Global.changenquestion(1)
        }

    }

    //EL USUARIO AL PRESIONAR BACK VOLVERA AL MENU PRINCIPAL
    override fun onBackPressed() {
        val i = Intent(applicationContext,MainActivity::class.java)
        startActivity(i)
        Global.puntuacion=0
        Toast.makeText(applicationContext,"Abandonando el Quizz",Toast.LENGTH_SHORT).show()
    }

    //SUMAR PUNTUACION PREGUNTA 1
    fun sumarpuntuacionp1(){
        when(Global.randomnumber){
            1->{
               if(Global.comp2 && Global.comp4 && !Global.comp1 && !Global.comp3) {
                   Global.puntuacion+=1
               }
            }
            2->{
                if(Global.comp1 && Global.comp4 && !Global.comp2 && !Global.comp3) {
                    Global.puntuacion+=1
                }
            }
            3->{
                if(Global.comp1 && Global.comp2 && !Global.comp3 && !Global.comp4) {
                    Global.puntuacion+=1
                }
            }
            4->{
                if(Global.comp2 && Global.comp4 && !Global.comp1 && !Global.comp3) {
                    Global.puntuacion+=1
                }
            }
        }
    }
    //SUMAR PUNTUACION PREGUNTA 2
    fun sumarpuntuacionp2(){
        when(Global.randomnumber){
            1->{
                if(Global.comp1 && Global.comp2 && Global.comp4 && !Global.comp4) {
                    Global.puntuacion+=1
                }
            }
            2->{
                if(Global.comp3 && Global.comp4 && !Global.comp2 && !Global.comp1) {
                    Global.puntuacion+=1
                }
            }
            3->{
                if(Global.comp1 && Global.comp2 && !Global.comp3 && !Global.comp4 ) {
                    Global.puntuacion+=1
                }
            }
            4->{
                if(Global.comp1 && Global.comp3 && Global.comp4 && !Global.comp2) {
                    Global.puntuacion+=1
                }
            }
        }
    }
    //SUMAR PUNTUACION PREGUNTA 3
    fun sumarpuntuacionp3(){
        when(Global.randomnumber){
            1->{
                if(Global.comp1 && Global.comp3 && !Global.comp2 && !Global.comp4) {
                    Global.puntuacion+=1
                }
            }
            2->{
                if(Global.comp1 && Global.comp2 && Global.comp3 && !Global.comp4) {
                    Global.puntuacion+=1
                }
            }
            3->{
                if(Global.comp3 && Global.comp4 && !Global.comp1 && !Global.comp2) {
                    Global.puntuacion+=1
                }
            }
            4->{
                if(Global.comp1 && Global.comp3 && !Global.comp2 && !Global.comp4) {
                    Global.puntuacion+=1
                }
            }
        }
    }
    //SUMAR PUNTUACION PREGUNTA 4
    fun sumarpuntuacionp4(){
        when(Global.randomnumber){
            1->{
                if(Global.comp3 && !Global.comp1 && !Global.comp2 && !Global.comp4) {
                    Global.puntuacion+=1
                }
            }
            2->{
                if(Global.comp1 && !Global.comp2 && !Global.comp3 && !Global.comp4) {
                    Global.puntuacion+=1
                }
            }
            3->{
                if(Global.comp4 && !Global.comp1 && !Global.comp2 && !Global.comp3) {
                    Global.puntuacion+=1
                }
            }
            4->{
                if(Global.comp4 && !Global.comp1 && !Global.comp2 && !Global.comp3) {
                    Global.puntuacion+=1
                }
            }
        }
    }

}