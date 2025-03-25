package com.example.principal.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.principal.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Aquí puedes inicializar tu pantalla principal
        // Por ejemplo, mostrar recomendaciones destacadas, novedades, etc.

        // Ejemplo de cómo configurar un botón de libro destacado (si tuvieras uno en tu layout)
        // binding.btnFeaturedBook.setOnClickListener {
        //     findNavController().navigate(R.id.action_homeFragment_to_bookDetailFragment)
        // }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}