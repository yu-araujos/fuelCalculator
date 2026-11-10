package com.yuri.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DistanciaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distancia)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val precoCombustivel = intent.getDoubleExtra("PRECO_LITRO", 0.0)
        val consumoPorLitro = intent.getIntExtra("CONSUMO_LITRO", 0)

        val edtDistancia = findViewById<EditText>(R.id.edtDistancia)
        val btnDistanciaCalulcar = findViewById<Button>(R.id.btnDistanciaCalcular)

        btnDistanciaCalulcar.setOnClickListener {
            val distancia = edtDistancia.text.toString().toInt()
            val consumo = consumoPorLitro
            val precoLitro = precoCombustivel

            val litrosNecessarios = distancia / consumo

            val custoTotal = litrosNecessarios * precoLitro


            val intent = Intent(this, ResultadoActivity::class.java)
            intent.putExtra("DISTANCIA_PRECO_LITRO", precoLitro)
            intent.putExtra("DISTANCIA_CONSUMO_LITRO", consumo)
            intent.putExtra("DISTANCIA_VALOR", distancia)
            intent.putExtra("DISTANCIA_CUSTO_TOTAL", custoTotal)

            startActivity(intent)
        }
    }
}