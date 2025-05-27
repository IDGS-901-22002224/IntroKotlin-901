package org.utl.introkotlin_901.Diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin_901.R

class DiccionarioActivity : AppCompatActivity() {

    private lateinit var buttonNavigateToAddWords: Button
    private lateinit var buttonNavigateToSearchWords: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_diccionario)

        buttonNavigateToAddWords = findViewById(R.id.buttonNavigateToAddWords)
        buttonNavigateToSearchWords = findViewById(R.id.buttonNavigateToSearchWords)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonNavigateToAddWords.setOnClickListener {
            val intent = Intent(this, AgregarPalabras::class.java)
            startActivity(intent)
        }

        buttonNavigateToSearchWords.setOnClickListener {
            val intent = Intent(this, BuscarPalabrasActivity::class.java)
            startActivity(intent)
        }
    }
}