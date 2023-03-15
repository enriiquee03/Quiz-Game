package com.example.secondproject

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RadioButtonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RadioButtonFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var answers:RadioGroup
    lateinit var question : TextView
    lateinit var answer1 : RadioButton
    lateinit var answer2 : RadioButton
    lateinit var answer3 : RadioButton
    lateinit var answer4 : RadioButton
    lateinit var background :ImageView


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
        val view =  inflater.inflate(R.layout.fragment_radio_button, container, false)
        question = view.findViewById(R.id.preguntacheckbox)
        answer1 = view.findViewById(R.id.answer1q4)
        answer2 = view.findViewById(R.id.answer2q4)
        answer3 = view.findViewById(R.id.answer3q4)
        answer4 = view.findViewById(R.id.answer4q4)
        background= view.findViewById(R.id.background)
        makequestionscheckbox(Global.randomnumber)

        answers = view.findViewById(R.id.radioanswers)

        //Comprobamos las respuestas
            answer1.setOnCheckedChangeListener { _, isChecked ->
                Global.comp1 = answer1.isChecked
            }
            answer2.setOnCheckedChangeListener { _, isChecked ->
                Global.comp2 = answer2.isChecked
            }
            answer3.setOnCheckedChangeListener { _, isChecked ->
                Global.comp3 = answer3.isChecked
            }
            answer4.setOnCheckedChangeListener { _, isChecked ->
                Global.comp4 = answer4.isChecked
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
         * @return A new instance of fragment RadioButton.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RadioButtonFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    //CAMBIO DE PREGUNTAS POR CADA QUIZZ
    fun makequestionscheckbox(numquizz:Int){
        when(numquizz){
            1->{
                question.text="¿Quién formuló la teoría de la relatividad general?"
                answer1.text="Isaac Newton"
                answer2.text="S.Wozniak"
                answer3.text="Albert Einstein" //respuesta correcta
                answer4.text="S.Jobs"
                background.setImageResource(R.drawable.ciencia_quizz)
            }
            2->{
                question.text="¿Qué jugador marcó el hat -trick más rápido en LaLiga?"
                answer1.text="Bebeto " //respuesta correcta
                answer2.text="Cristiano"
                answer3.text="Messi"
                answer4.text="Iago Aspas"

            }
            3->{
                question.text="¿En cuál de los siguientes países NO hay ningún desierto?"
                answer1.text="España"
                answer2.text="Chile"
                answer3.text="Mongolia"
                answer4.text="Alemania" //respuesta correcta
                background.setImageResource(R.drawable.grografia_quizz)

            }
            4->{
                question.text="¿Qué título recibían los soberanos musulmanes en España ?"
                answer1.text="Rey"
                answer2.text="Jeque"
                answer3.text="Khaleesi"
                answer4.text="Califa"//respuesta correcta
                background.setImageResource(R.drawable.historia_quizz)

            }
        }
    }

}