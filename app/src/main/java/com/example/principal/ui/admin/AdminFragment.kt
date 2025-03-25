package com.example.principal.ui.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.principal.databinding.FragmentAdminBinding

class AdminFragment : Fragment() {

    private var _binding: FragmentAdminBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdminBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Cargar la lista de usuarios (en un caso real, obtendrías estos datos de tu backend)
        loadUsers()

        // Configurar botón para añadir nuevo usuario (si tienes uno)
        // binding.btnAddUser.setOnClickListener {
        //     showAddUserDialog()
        // }
    }

    private fun loadUsers() {
        // En una implementación real, aquí cargarías los usuarios desde tu API

        // Ejemplo de cómo podrías configurar un RecyclerView con usuarios
        // val users = fetchMockUsers()
        // val adapter = UserAdapter(users) { user -> onUserClicked(user) }
        // binding.recyclerUsers.adapter = adapter
    }

    // Ejemplo de cómo manejar el clic en un usuario
    private fun onUserClicked(userId: Long) {
        // Navegar a los detalles del usuario o mostrar un diálogo de edición
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}