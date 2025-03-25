package com.example.principal.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.principal.databinding.FragmentMoviesBinding

class MoviesFragment : Fragment() {

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Aquí implementarías la lógica para mostrar el listado de películas
        // Muy similar a BooksFragment, pero con datos de películas

        // Ejemplo de cómo configurar categorías de películas (si tuvieras esos botones)
        // binding.btnActionMovies.setOnClickListener { filterMoviesByGenre("action") }
        // binding.btnComedyMovies.setOnClickListener { filterMoviesByGenre("comedy") }
        // binding.btnDramaMovies.setOnClickListener { filterMoviesByGenre("drama") }
    }

    // Función para simular el filtrado de películas por género
    private fun filterMoviesByGenre(genre: String) {
        // Implementar lógica de filtrado
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}