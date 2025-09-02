package com.example.torres3.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.torres3.R
import com.example.torres3.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var num1: EditText
    private lateinit var num2: EditText
    private lateinit var resultado: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        num1 = view.findViewById(R.id.editTextNum1)
        num2 = view.findViewById(R.id.editTextNum2)
        resultado = view.findViewById(R.id.txtResultado)

        val btnSumar = view.findViewById<Button>(R.id.btnSumar)
        val btnRestar = view.findViewById<Button>(R.id.btnRestar)
        val btnMultiplicar = view.findViewById<Button>(R.id.btnMultiplicar)
        val btnDividir = view.findViewById<Button>(R.id.btnDividir)

        fun getValues(): Pair<Double?, Double?> {
            val a = num1.text.toString().toDoubleOrNull()
            val b = num2.text.toString().toDoubleOrNull()
            return Pair(a, b)
        }

        fun mostrarResultado(valor: Double) {
            resultado.text = "Resultado: ${String.format("%.2f", valor)}"
        }

        btnSumar.setOnClickListener {
            val (a, b) = getValues()
            if (a != null && b != null) mostrarResultado(a + b)
            else resultado.text = "Por favor, ingresa números válidos."
        }

        btnRestar.setOnClickListener {
            val (a, b) = getValues()
            if (a != null && b != null) mostrarResultado(a - b)
            else resultado.text = "Por favor, ingresa números válidos."
        }

        btnMultiplicar.setOnClickListener {
            val (a, b) = getValues()
            if (a != null && b != null) mostrarResultado(a * b)
            else resultado.text = "Por favor, ingresa números válidos."
        }

        btnDividir.setOnClickListener {
            val (a, b) = getValues()
            if (a != null && b != null) {
                if (b != 0.0) mostrarResultado(a / b)
                else resultado.text = "Error: División por cero"
            } else {
                resultado.text = "Por favor, ingresa números válidos."
            }
        }

        return view
    }
}



