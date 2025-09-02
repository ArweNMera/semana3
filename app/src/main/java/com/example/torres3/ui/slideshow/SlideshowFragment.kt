package com.example.torres3.ui.slideshow

import android.graphics.Color
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
import com.example.torres3.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {
    private lateinit var nombre: EditText
    private lateinit var edad: EditText
    private lateinit var correo: EditText
    private lateinit var btnMostrar: Button
    private lateinit var resultado: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_slideshow, container, false)

        nombre = view.findViewById(R.id.editNombre)
        edad = view.findViewById(R.id.editEdad)
        correo = view.findViewById(R.id.editCorreo)
        btnMostrar = view.findViewById(R.id.btnMostrar)
        resultado = view.findViewById(R.id.txtResultado)

        btnMostrar.setOnClickListener {
            val nombreText = nombre.text.toString().trim()
            val edadText = edad.text.toString().trim()
            val correoText = correo.text.toString().trim()

            if (nombreText.isEmpty() || edadText.isEmpty() || correoText.isEmpty()) {
                resultado.text = "Por favor, completa todos los campos."
                resultado.setTextColor(Color.RED)
            } else {
                val info = """
                    ✅ Datos ingresados:
                    • Nombre: $nombreText
                    • Edad: $edadText
                    • Correo: $correoText
                """.trimIndent()
                resultado.text = info
                resultado.setTextColor(Color.parseColor("#333333"))
            }
        }

        return view
    }
}

