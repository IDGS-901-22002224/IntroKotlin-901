package org.utl.introkotlin_901.Diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import org.utl.introkotlin_901.MenuActivity
import org.utl.introkotlin_901.R
import java.io.File
import java.io.FileOutputStream

class AgregarPalabras : AppCompatActivity() {

    private val wordsList = mutableListOf<String>()
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var editTextSpanish: EditText
    private lateinit var editTextEnglish: EditText
    private lateinit var buttonSave: Button
    private lateinit var listViewWords: ListView
    private lateinit var textViewSavedWordsLabel: TextView
    private lateinit var buttonReturnToMenuFromAdd: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_palabras)

        editTextSpanish = findViewById(R.id.editTextSpanish)
        editTextEnglish = findViewById(R.id.editTextEnglish)
        buttonSave = findViewById(R.id.buttonSave)
        listViewWords = findViewById(R.id.listViewWords)
        textViewSavedWordsLabel = findViewById(R.id.textViewSavedWordsLabel)
        buttonReturnToMenuFromAdd = findViewById(R.id.buttonReturnToMenuFromAdd)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, wordsList)
        listViewWords.adapter = adapter
        loadWords()

        buttonSave.setOnClickListener {
            val spanish = editTextSpanish.text.toString().trim()
            val english = editTextEnglish.text.toString().trim()

            if (spanish.isNotEmpty() && english.isNotEmpty()) {
                val wordPair = "$spanish,$english"
                if (isWordPairExists(spanish, english)) {
                    AlertDialog.Builder(this)
                        .setTitle("Advertencia")
                        .setMessage("Esta palabra ya está registrada")
                        .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                        .create()
                        .show()
                } else {
                    saveWord(wordPair)
                    wordsList.add("$spanish - $english")
                    adapter.notifyDataSetChanged()
                    editTextSpanish.text.clear()
                    editTextEnglish.text.clear()
                    textViewSavedWordsLabel.text = "Palabras Guardadas con éxito"

                    AlertDialog.Builder(this)
                        .setTitle("Éxito")
                        .setMessage("Palabras Guardadas con éxito")
                        .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                        .create()
                        .show()
                }
            } else {
                Toast.makeText(this, "Por favor, llena ambos campos", Toast.LENGTH_SHORT).show()
            }
        }

        // Return to Menu
        buttonReturnToMenuFromAdd.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }

    private fun isWordPairExists(spanish: String, english: String): Boolean {
        try {
            val file = File(filesDir, "dictionary.txt")
            if (file.exists()) {
                file.readLines(Charsets.UTF_8).forEach { line ->
                    if (line.isNotBlank()) {
                        val parts = line.split(",")
                        if (parts.size == 2) {
                            val existingSpanish = parts[0].trim()
                            val existingEnglish = parts[1].trim()
                            if (existingSpanish.equals(spanish, ignoreCase = true) &&
                                existingEnglish.equals(english, ignoreCase = true)) {
                                return true
                            }
                        }
                    }
                }
            }
        } catch (e: Exception) {
            AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage("Error al verificar la palabra: ${e.message}")
                .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                .create()
                .show()
        }
        return false
    }

    private fun saveWord(wordPair: String) {
        try {
            val file = File(filesDir, "dictionary.txt")
            FileOutputStream(file, true).use { fos ->
                fos.write(("$wordPair\n").toByteArray(Charsets.UTF_8))
            }
        } catch (e: Exception) {
            AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage("Error al guardar: ${e.message}")
                .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                .create()
                .show()
        }
    }

    private fun loadWords() {
        try {
            val file = File(filesDir, "dictionary.txt")
            if (file.exists()) {
                file.readLines(Charsets.UTF_8).forEach { line ->
                    if (line.isNotBlank()) {
                        val parts = line.split(",")
                        if (parts.size == 2 && parts[0].isNotBlank() && parts[1].isNotBlank()) {
                            wordsList.add("${parts[0].trim()} - ${parts[1].trim()}")
                        }
                    }
                }
                adapter.notifyDataSetChanged()
            }
        } catch (e: Exception) {
            AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage("Error al cargar: ${e.message}")
                .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                .create()
                .show()
        }
    }
}