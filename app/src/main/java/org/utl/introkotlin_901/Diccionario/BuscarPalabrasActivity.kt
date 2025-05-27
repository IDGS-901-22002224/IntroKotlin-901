package org.utl.introkotlin_901.Diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.utl.introkotlin_901.MenuActivity
import org.utl.introkotlin_901.R
import java.io.File

class BuscarPalabrasActivity : AppCompatActivity() {

    private lateinit var editTextSearchWord: EditText
    private lateinit var radioSpanish: RadioButton
    private lateinit var buttonSearch: Button
    private lateinit var textViewResult: TextView
    private lateinit var buttonReturnToMenuFromSearch: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar_palabras)

        editTextSearchWord = findViewById(R.id.editTextSearchWord)
        radioSpanish = findViewById(R.id.radioSpanish)
        buttonSearch = findViewById(R.id.buttonSearch)
        textViewResult = findViewById(R.id.textViewResult)
        buttonReturnToMenuFromSearch = findViewById(R.id.buttonReturnToMenuFromSearch)

        val wordToSearch = intent.getStringExtra("WORD_TO_SEARCH")
        if (!wordToSearch.isNullOrEmpty()) {
            editTextSearchWord.setText(wordToSearch)
            searchWord(wordToSearch)
        }

        buttonSearch.setOnClickListener {
            val word = editTextSearchWord.text.toString().trim()
            if (word.isNotEmpty()) {
                searchWord(word)
            } else {
                Toast.makeText(this, "Por favor, ingresa una palabra", Toast.LENGTH_SHORT).show()
            }
        }

        buttonReturnToMenuFromSearch.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }

    private fun searchWord(word: String) {
        val isSpanish = radioSpanish.isChecked
        val file = File(filesDir, "dictionary.txt")
        var result = "Palabra no encontrada"

        if (file.exists()) {
            file.readLines(Charsets.UTF_8).forEach { line ->
                if (line.isNotBlank()) {
                    val parts = line.split(",")
                    if (parts.size == 2) {
                        val spanishWord = parts[0].trim()
                        val englishWord = parts[1].trim()

                        if (isSpanish && spanishWord.equals(word, ignoreCase = true)) {
                            result = "Palabra encontrada: $englishWord"
                        } else if (!isSpanish && englishWord.equals(word, ignoreCase = true)) {
                            result = "Palabra encontrada: $spanishWord"
                        }
                    }
                }
            }
        }

        textViewResult.text = result
    }
}