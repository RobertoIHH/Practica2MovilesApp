package com.example.principal.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.principal.R
import com.example.principal.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar el botón de registro
        binding.btnRegister.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val confirmPassword = binding.etConfirmPassword.text.toString()

            // Validaciones básicas
            when {
                name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() -> {
                    Toast.makeText(context, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                password != confirmPassword -> {
                    Toast.makeText(context, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    Toast.makeText(context, "Email inválido", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            // Simulación de registro exitoso
            simulateRegister(name, email, password)
        }

        // Configurar el enlace a login
        binding.tvLogin.setOnClickListener {
            findNavController().navigate(R.id.action_register_to_login)
        }
    }

    private fun simulateRegister(name: String, email: String, password: String) {
        // Aquí es donde conectarías con tu API de backend
        binding.progressBar.visibility = View.VISIBLE
        binding.btnRegister.isEnabled = false

        // Simulamos una respuesta exitosa después de un breve retraso
        view?.postDelayed({
            binding.progressBar.visibility = View.GONE
            binding.btnRegister.isEnabled = true

            Toast.makeText(context, "Registro exitoso! Inicia sesión con tu nueva cuenta", Toast.LENGTH_LONG).show()

            // Volver a la pantalla de login
            findNavController().navigate(R.id.action_register_to_login)
        }, 1500)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}