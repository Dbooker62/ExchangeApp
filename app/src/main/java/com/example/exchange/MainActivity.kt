package com.example.exchange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inputAmount = findViewById<EditText>(R.id.editTextNumberDecimal)
        val usdToPkrRadio = findViewById<RadioButton>(R.id.radioButton)
        val pkrToUsdRadio = findViewById<RadioButton>(R.id.radioButton2)
        val convertButton = findViewById<Button>(R.id.button)
        val resultTextView = findViewById<TextView>(R.id.textView2)
        convertButton.setOnClickListener {
            val amountString = inputAmount.text.toString()

            if (amountString.isEmpty()) {
                Toast.makeText(this, "Please enter an amount", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val amount = amountString.toDouble()
            val convertedAmount: Double

            if (usdToPkrRadio.isChecked) {

                convertedAmount = amount * 280.0
            } else if (pkrToUsdRadio.isChecked) {

                convertedAmount = amount / 280.0
            } else {
                Toast.makeText(this, "Please select a currency", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (convertedAmount > 10000.00) {
                Toast.makeText(this, "Converted amount is over $10,000.00", Toast.LENGTH_LONG).show()
                resultTextView.setText("Converted amount: $convertedAmount")
            } else {
                // Display the converted amount in the resultTextView
                resultTextView.setText("Converted amount: $convertedAmount")
            }
        }
    }
}