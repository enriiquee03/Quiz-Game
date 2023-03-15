package com.example.secondproject

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import com.airbnb.lottie.LottieAnimationView
import java.util.regex.Pattern

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
lateinit var question : TextView
lateinit var send_answers : Button
lateinit var answertext : EditText
lateinit var container_answer : RelativeLayout
lateinit  var animation : LottieAnimationView
lateinit var  background : ImageView
lateinit var  backmenu : Button
lateinit var instagram :ImageButton
var comp =false

/**
 * A simple [Fragment] subclass.
 * Use the [EditTextFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditTextFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_edit_text, container, false)
        question = view.findViewById(R.id.preguntacheckbox)
        send_answers = view.findViewById(R.id.send)
        answertext = view.findViewById(R.id.answertext)
        animation = view.findViewById(R.id.puntuacion)
        container_answer = view.findViewById(R.id.answercontainer)
        background = view.findViewById(R.id.background)
        backmenu = view.findViewById(R.id.backmenu)
        backmenu.visibility = View.INVISIBLE
        instagram= view.findViewById(R.id.instagram)
        instagram.visibility = View.INVISIBLE

        makequestionscheckbox(Global.randomnumber)

        //Mostrar puntuacion
        send_answers.setOnClickListener {
        if((answertext.text.toString().trim()).isNotEmpty()) {

                validar_respuesta(Global.randomnumber)
                background.setImageResource(R.drawable.finish_background)
                instagram.visibility = View.VISIBLE
                backmenu.visibility = View.VISIBLE
                send_answers.visibility = View.INVISIBLE
                question.text = "${Global.nombre}\n Has obtenido ${Global.puntuacion}/5 puntos"
                container_answer.visibility = View.INVISIBLE

                playanimation(animation, R.raw.puntuacion, comp, Global.randomnumber)
            }else{
                Toast.makeText(requireActivity().application,"Debe responder a la pregunta",Toast.LENGTH_SHORT).show()
            }
        }
        //volver al menu principal
        backmenu.setOnClickListener {
            val i = Intent(activity,MainActivity::class.java)
            startActivity(i)
            Global.puntuacion=0
        }

        //Intent para abrir perfil en instagram
        instagram.setOnClickListener {
                val url = "https://www.instagram.com/centronelson/?hl=es"
                openWebPage(url)
        }




        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EditText.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EditTextFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun makequestionscheckbox(numquizz:Int){
        when(numquizz){
            1->{
                question.text="¿Qué órgano del cuerpo humano produce la bilis?"
                // Respuesta correcta : Higado
                background.setImageResource(R.drawable.ciencia_quizz)

            }
            2->{
                question.text="¿Quién ganó el mundial de fútbol de 2018?"
                //Rspuesta coorecta : Francia

            }
            3->{
                question.text="¿En qué país situarías la ciudad de Cali?"
                //Respuesta correcta: Colombia
                background.setImageResource(R.drawable.grografia_quizz)

            }
            4->{
                question.text="¿Cómo se llamaban los gobernantes del antiguo Egipto?"
                //Respuesta correcta: Faraones
                background.setImageResource(R.drawable.historia_quizz)

            }
        }
    }
    fun validar_respuesta(numquizz:Int){
        when(numquizz){
            1->{
                if(answertext.text.toString().equals("higado", true)){
                    Global.puntuacion+=1
                }

            }
            2->{
                if(answertext.text.toString().equals("francia", true)){
                    Global.puntuacion+=1
                }

            }
            3->{
                if(answertext.text.toString().equals("Colombia", true)){
                    Global.puntuacion+=1
                }

            }
            4->{
                if(answertext.text.toString().equals("faraones", true)){
                    Global.puntuacion+=1
                }

            }
        }
    }

    fun playanimation(imageview: LottieAnimationView, animation : Int, comp: Boolean, random:Int): Boolean {
        if(!comp){
            imageview.setAnimation(animation)
            imageview.playAnimation()
        }
        return comp
    }

    fun openWebPage(url: String) {
        val packageManager = requireActivity().packageManager
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

}