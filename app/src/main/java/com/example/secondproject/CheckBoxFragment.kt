package com.example.secondproject

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CheckBoxFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CheckBoxFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var question : TextView

    lateinit var answer1 : CheckBox
    lateinit var answer2 : CheckBox
    lateinit var answer3 : CheckBox
    lateinit var answer4 : CheckBox
    lateinit var background : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_check_box, container, false)


        question= view.findViewById(R.id.preguntacheckbox)
        answer1= view.findViewById(R.id.answer1q1)
        answer2= view.findViewById(R.id.answer2q1)
        answer3= view.findViewById(R.id.answer3q1)
        answer4= view.findViewById(R.id.answer4q1)
        background= view.findViewById(R.id.background)
        makequestionscheckbox(Global.randomnumber)

        //validamos que responda a la pregunta y sumamos la
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
         * @return A new instance of fragment Global_Quizz.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CheckBoxFragment().apply {
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
                question.text="¿Cuales de las siguientes respuestas son Opiáceos?"
                answer1.text="Eritrocitos"
                answer2.text="Morfina" //respuesta correcta
                answer3.text="Clorofila"
                answer4.text="Heroina" //respuesta correcta
                background.setImageResource(R.drawable.ciencia_quizz)
            }
            2->{
                question.text="¿Cuánto dura una maratón?"
                answer1.text="42.195 kilómetros" //respuesta correcta
                answer2.text="23.2 millas"
                answer3.text="45.195 kilómetros"
                answer4.text="26.2 millas" //respuesta correcta
            }
            3->{
                question.text="¿Entre qué dos países está el lago Titicaca? "
                answer1.text="Bolivia " //respuesta correcta
                answer2.text="Perú" //respuesta correcta
                answer3.text="Paraguay"
                answer4.text="Brasil"
                background.setImageResource(R.drawable.grografia_quizz)
            }
            4->{
                question.text="¿Quiénes fueron los Reyes Católicos?"
                answer1.text="Felipe I"
                answer2.text="Isabel I" //respuesta correcta
                answer3.text="Isabel II"
                answer4.text="Fernando II" //respuesta correcta
                background.setImageResource(R.drawable.historia_quizz)
            }
        }
    }




}