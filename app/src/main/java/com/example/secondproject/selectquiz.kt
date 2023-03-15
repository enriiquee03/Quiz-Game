package com.example.secondproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView


class selectquiz : AppCompatActivity() {

     lateinit  var animation : LottieAnimationView
     lateinit var  imagetransparent : ImageView
     lateinit var  start : Button
     lateinit var  reset : Button

     var check =false
    var randomnumber = 0
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selectquiz2)
        val handler = Handler()
        var comp = false
        animation= findViewById(R.id.selectimage)
        imagetransparent = findViewById(R.id.animation)
        start = findViewById(R.id.go_quizz)
        reset = findViewById(R.id.reset_quizz)

            //comenzar el quizz
            start.setOnClickListener(){
                goquizz()
            }
            //resetear animacion
            reset.setOnClickListener {
                callreset()
            }
            //llamar a la animacion
            animation.setOnClickListener(){
                imagetransparent.setImageResource(R.drawable.transparent)
                randomnumber = (Math.random()*4+1).toInt()
                playanimation(animation,R.raw.game,comp,randomnumber,imagetransparent)

                handler.postDelayed({
                    changephoto(imagetransparent,randomnumber)
                    showtoastquiz(randomnumber)
                }, 3000)
                Global.changenumber(randomnumber)
            }
    }

    //comenzar animacion
    fun playanimation(imageview: LottieAnimationView, animation : Int, comp: Boolean, random:Int,imageView: ImageView): Boolean {
        check=true
        if(!comp){
            imageview.setAnimation(animation)
            imageview.playAnimation()
            imageview.animate()
                    .setDuration(4000)
        }
        return comp
    }
    //mostrar toast del quizz seleccionado
    fun showtoastquiz(random: Int){
        when (random) {
            1 -> {
                Toast.makeText(
                    applicationContext,
                    "El Quizz elegido ha sido:  Ciencia",
                    Toast.LENGTH_SHORT
                ).show()
            }
            2 -> {
                Toast.makeText(
                    applicationContext,
                    "El Quizz elegido ha sido:  Deportes",
                    Toast.LENGTH_SHORT
                ).show()
            }
            3 -> {
                Toast.makeText(
                    applicationContext,
                    "El Quizz elegido ha sido:  Geografia",
                    Toast.LENGTH_SHORT
                ).show()
            }
            4 -> {
                Toast.makeText(
                    applicationContext,
                    "El Quizz elegido ha sido:  Historia",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    //cambiar foto a la del quizz elegido
    fun changephoto(imageView: ImageView, random: Int){
        when (random) {
            1 -> {
                imageView.setImageResource(R.drawable.ciencia)
            }
            2 -> {
                imageView.setImageResource(R.drawable.deportes)
            }
            3 -> {
                imageView.setImageResource(R.drawable.geografia)
            }
            4 -> {
                imageView.setImageResource(R.drawable.historia)
            }
        }
    }

    //resetear animacion
    fun resetanimation(imageview: LottieAnimationView,comp: Boolean){

        if(check){
            imageview.setImageResource(R.drawable.clickbutton)
            randomnumber = 0
            imagetransparent.setImageResource(R.drawable.transparent)
        }else{
            Toast.makeText(applicationContext,"El quizz todavia no ha sido elegido",Toast.LENGTH_SHORT).show()
        }
    }

    //resetear animacion
    fun callreset(){
        resetanimation(animation,false)
    }
    //pasar al quizz
    fun goquizz(){
        if(randomnumber!=0){
            val i = Intent(applicationContext,StartsFragment::class.java)
            startActivity(i)
        }else{
            Toast.makeText(applicationContext,"No se ha seleccionado el quizz",Toast.LENGTH_SHORT).show()
        }
    }
}