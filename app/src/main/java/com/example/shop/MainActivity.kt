package com.example.shop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultText: TextView = findViewById(R.id.result)
        val numberInput: EditText = findViewById(R.id.number_input)
        val formatButton: Button = findViewById(R.id.format_button)

        formatButton.setOnClickListener {
            val num = numberInput.text.toString().toDoubleOrNull() ?: 0.0
            val formatted = formatDouble(num)
            resultText.text = formatted
        }
    }
}
