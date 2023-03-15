package com.example.secondproject

import android.widget.CheckBox

class Global {


     //Todas las variables que necesito globalmente
companion object{
     var randomnumber = 0
     var comp1=false
     var comp2=false
     var comp3=false
     var comp4=false

     var puntuacion = 0
     //numero de quizz
     fun changenumber(int: Int){
          randomnumber=int
     }
     var nombre = ""
     var question = 0
     //resetear comprobar respuestas
     fun resetcomp(){
          comp1=false
          comp2=false
          comp3=false
          comp4=false
     }
     //cambia numero de pregunta
     fun changenquestion(int: Int){
          question=int
     }
}

}