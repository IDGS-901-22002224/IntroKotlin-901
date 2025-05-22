package org.utl.introkotlin_901

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin_901.Cinepolis.CinepolisActivity
import org.utl.introkotlin_901.R.id
import org.utl.introkotlin_901.R.id.btn1
import org.utl.introkotlin_901.R.id.btn2
import org.utl.introkotlin_901.R.id.btn3
import org.utl.introkotlin_901.ejemplo1.SumaActivity
import org.utl.introkotlin_901.ejemplo2.SaludoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnSaludo = findViewById<Button>(btn1)
        val btnCinepolis = findViewById<Button>(btn2)
        val btnnavegateToSalud2 = findViewById<Button>(btn3)


        btnSaludo.setOnClickListener {navegateToSaludo()}
        btnCinepolis.setOnClickListener {navegateToSaludoCinepolis()}
        btnnavegateToSalud2.setOnClickListener {navegateToSalud2()}

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navegateToSaludo() {
        val intent = Intent(this, SumaActivity::class.java)
        startActivity(intent)
    }

    private fun navegateToSaludoCinepolis() {
        val intent = Intent(this, CinepolisActivity::class.java)
        startActivity(intent)
    }

    private fun navegateToSalud2() {
        val intent = Intent(this, SaludoActivity::class.java)
        startActivity(intent)
    }

}