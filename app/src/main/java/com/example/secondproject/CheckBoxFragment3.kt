package com.example.secondproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CheckBoxFragment3.newInstance] factory method to
 * create an instance of this fragment.
 */
class CheckBoxFragment3 : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_check_box3, container, false)

        question= view.findViewById(R.id.preguntacheckbox)
        answer1= view.findViewById(R.id.answer1q3)
        answer2= view.findViewById(R.id.answer2q3)
        answer3= view.findViewById(R.id.answer3q3)
        answer4= view.findViewById(R.id.answer4q3)
        background= view.findViewById(R.id.background)

        //validamos que responda a la pregunta
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
        makequestionscheckbox(Global.randomnumber)

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CheckBoxFragment3.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CheckBoxFragment3().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    //CAMBIO DE PREGUNTAS Y RESPUESTAS POR CADA QUIZZ
    fun makequestionscheckbox(numquizz:Int){
        when(numquizz){
            1->{
                question.text="¿Qué sustancias se liberan en una combustión completa?"
                answer1.text="Dióxido de carbono" //respuesta correcta
                answer2.text="Monóxido de carbono "
                answer3.text="Agua"  //respuesta correcta
                answer4.text="Carbono"
                background.setImageResource(R.drawable.ciencia_quizz)
            }
            2->{
                question.text="¿Que selecciones han ganado la copa del mundo en dos ocasiones?"
                answer1.text="Argentina" //respuesta correcta
                answer2.text="Francia" //respuesta correcta
                answer3.text="Uruguay"  //respuesta correcta
                answer4.text="México"
            }
            3->{
                question.text="¿Cúales son las ciudades autónomas de España?"
                answer1.text="Nador"
                answer2.text="Villa Sanjurjo"
                answer3.text="Ceuta" //respuesta correcta
                answer4.text="Melilla" //respuesta correcta
                background.setImageResource(R.drawable.grografia_quizz)
            }
            4->{
                question.text="¿Cuando termina la Edad Media?"
                answer1.text="XV" //respuesta correcta
                answer2.text="1592"
                answer3.text="1492" //respuesta correcta
                answer4.text="XVI"
                background.setImageResource(R.drawable.historia_quizz)

            }
        }
    }



}