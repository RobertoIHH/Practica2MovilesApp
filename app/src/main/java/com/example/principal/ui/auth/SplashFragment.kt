package com.example.principal.ui.auth

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.principal.R
import com.example.principal.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Simular verificación de sesión tras un breve retraso
        Handler(Looper.getMainLooper()).postDelayed({
            checkSession()
        }, 2000) // 2 segundos de splash
    }

    private fun checkSession() {
        // En una implementación real, aquí verificarías si el usuario tiene una sesión activa
        // Por ejemplo, comprobando si hay un token guardado

        val isLoggedIn = false // Cambiar a true para simular que el usuario ya ha iniciado sesión

        if (isLoggedIn) {
            // Si hay sesión, ir directamente a la pantalla principal
            findNavController().navigate(R.id.action_splash_to_main)
        } else {
            // Si no hay sesión, ir a la pantalla de login
            findNavController().navigate(R.id.action_splash_to_login)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}