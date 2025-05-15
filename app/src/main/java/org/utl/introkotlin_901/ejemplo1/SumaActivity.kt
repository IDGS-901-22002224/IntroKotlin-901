package org.utl.introkotlin_901.ejemplo1

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin_901.R
import org.utl.introkotlin_901.R.id

class SumaActivity : AppCompatActivity() {
    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var tv1: TextView
    private lateinit var radioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_suma)


        et1 = findViewById(id.et1)
        et2 = findViewById(id.et2)
        tv1 = findViewById(id.tv1)
        radioGroup = findViewById(id.radioGroup)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcular(view: View?) {

        if (et1.text.isEmpty() || et2.text.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa ambos números", Toast.LENGTH_SHORT).show()
            return
        }


        val num1 = et1.text.toString().toDouble()
        val num2 = et2.text.toString().toDouble()


        val selectedId = radioGroup.checkedRadioButtonId
        val resultado: Double

        when (selectedId) {
            R.id.rbSuma -> {
                resultado = num1 + num2

            }
            R.id.rbResta -> {
                resultado = num1 - num2

            }
            R.id.rbMultiplicacion -> {
                resultado = num1 * num2

            }
            R.id.rbDivision -> {
                if (num2 == 0.0) {
                    Toast.makeText(this, "No se puede dividir por cero", Toast.LENGTH_SHORT).show()
                    return
                }
                resultado = num1 / num2

            }
            else -> {
                Toast.makeText(this, "Selecciona una operación", Toast.LENGTH_SHORT).show()
                return
            }
        }


        tv1.text = "RESULTADO= $resultado"
    }
}