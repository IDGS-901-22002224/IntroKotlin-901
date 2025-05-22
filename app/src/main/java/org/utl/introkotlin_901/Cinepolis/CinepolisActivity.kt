package org.utl.introkotlin_901.Cinepolis

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin_901.R

class CinepolisActivity : AppCompatActivity() {
    private lateinit var nombreEditText: EditText
    private lateinit var personasEditText: EditText
    private lateinit var boletosEditText: EditText
    private lateinit var tarjetaRadioGroup: RadioGroup
    private lateinit var totalTextView: TextView
    private lateinit var calcularButton: Button

    private var precioUnico = 12.00
    private var total = 0.0
    private var descuentoTarj = 0.0
    private var descuento = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cinepolis)

        nombreEditText = findViewById(R.id.nombreEditText)
        personasEditText = findViewById(R.id.personasEditText)
        boletosEditText = findViewById(R.id.boletosEditText)
        tarjetaRadioGroup = findViewById(R.id.tarjetaRadioGroup)
        totalTextView = findViewById(R.id.totalPagar)
        calcularButton = findViewById(R.id.calcularButton)

        calcularButton.setOnClickListener {
            calcularTotal()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun calcularTotal() {
        val nombre = nombreEditText.text.toString()
        val personasStr = personasEditText.text.toString()
        val boletosStr = boletosEditText.text.toString()

        if (nombre.isEmpty() || personasStr.isEmpty() || boletosStr.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        val personas = personasStr.toIntOrNull()
        val boletos = boletosStr.toIntOrNull()

        if (personas == null || boletos == null) {
            Toast.makeText(this, "Ingresa valores numéricos válidos", Toast.LENGTH_SHORT).show()
            return
        }

        if (personas <= 0) {
            Toast.makeText(this, "La cantidad de personas no puede ser 0 o negativa", Toast.LENGTH_SHORT).show()
            return
        }
        if (boletos <= 0) {
            Toast.makeText(this, "La cantidad de boletos no puede ser 0 o negativa", Toast.LENGTH_SHORT).show()
            return
        }

        val limiteBoletos = 7 * personas
        if (boletos > limiteBoletos) {
            Toast.makeText(this, "Solo puede comprar hasta $limiteBoletos boletos", Toast.LENGTH_SHORT).show()
            return
        }

        total = boletos * precioUnico

        when {
            boletos in 3..5 -> {
                descuento = total * 0.10
                total -= descuento
            }
            boletos > 5 -> {
                descuento = total * 0.15
                total -= descuento
            }
        }

        val tarjetaSeleccionada = tarjetaRadioGroup.checkedRadioButtonId
        if (tarjetaSeleccionada != -1) {
            val radioButton = findViewById<RadioButton>(tarjetaSeleccionada)
            if (radioButton.text == "Sí") {
                descuentoTarj = total * 0.10
                total -= descuentoTarj
            }
        }

        totalTextView.text = "Boletos a Pagar\n$ ${"%.2f".format(total)}"
    }
}