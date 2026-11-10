package com.yuri.fuelcalculator

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        intent.putExtra("DISTANCIA_PRECO_LITRO", precoLitro)
//        intent.putExtra("DISTANCIA_CONSUMO_LITRO", consumo)
//        intent.putExtra("DISTANCIA_VALOR", distancia)
//        intent.putExtra("DISTANCIA_CUSTO_TOTAL", custoTotal)

        val valorTotal = intent.getDoubleExtra("DISTANCIA_CUSTO_TOTAL", 0.0)
        val tvPreco = findViewById<TextView>(R.id.tvPrecoViagem)

        tvPreco.text = valorTotal.toString()
    }
}