package org.utl.introkotlin_901.ejemplo2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin_901.R

class SaludoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_saludo)

        val btnStart = findViewById<AppCompatButton>(R.id.btnStart)
        val edtName = findViewById<AppCompatEditText>(R.id.edtName)

        btnStart.setOnClickListener {
            val name = edtName.text.toString()
            if (name.isNotEmpty()) {
                val intent = Intent(this, Resultado::class.java)
                intent.putExtra("EXTRA_NAME", name)
                startActivity(intent)
            }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
            }
        }
    }
}