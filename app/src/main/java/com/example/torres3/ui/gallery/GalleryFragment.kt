package com.example.torres3.ui.gallery

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.torres3.R
import com.example.torres3.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {
    private lateinit var layout: LinearLayout
    private lateinit var btnCambiarColor: Button
    private var colorIndex = 0

    private val colores = listOf(
        "#FFCDD2", "#C8E6C9", "#BBDEFB", "#FFF9C4", "#D1C4E9"
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)
        layout = view.findViewById(R.id.galleryLayout)
        btnCambiarColor = view.findViewById(R.id.btnCambiarColor)

        btnCambiarColor.setOnClickListener {
            val color = Color.parseColor(colores[colorIndex])
            layout.setBackgroundColor(color)
            colorIndex = (colorIndex + 1) % colores.size
        }

        return view
    }
}



