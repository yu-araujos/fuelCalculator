package com.yuri.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConsumoPorLitroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preco_consumo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val precoCombustivel = intent.getDoubleExtra("PRECO_COMBUSTIVEL", 0.0)
        val edtConsumoPorLitro = findViewById<EditText>(R.id.edtConsumoPorLitro)
        val btnConsumoPorLitro = findViewById<Button>(R.id.btnConsumoLitroProximo)

        btnConsumoPorLitro.setOnClickListener {
            val consumoPorLitroValor = edtConsumoPorLitro.text.toString().toInt()
            val intent = Intent(this, DistanciaActivity::class.java)
            intent.putExtra("CONSUMO_LITRO", consumoPorLitroValor)
            intent.putExtra("PRECO_LITRO", precoCombustivel)
            startActivity(intent)
        }
    }
}