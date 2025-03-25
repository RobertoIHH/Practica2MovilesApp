package com.example.principal.ui.profile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.principal.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val PICK_IMAGE_REQUEST = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar los datos del perfil (en un caso real, obtendrías estos datos de tu backend)
        setupProfileData()

        // Configurar el botón para cambiar la imagen de perfil
        binding.fabChangeImage.setOnClickListener {
            openImageChooser()
        }

        // Aquí configurarías los botones para guardar cambios en el perfil, cambiar contraseña, etc.
        // según los elementos que tengas en tu layout
    }

    private fun setupProfileData() {
        // En una implementación real, estos datos vendrían de tu backend
        binding.tvProfileName.text = "Usuario Ejemplo"
        binding.tvProfileEmail.text = "usuario@ejemplo.com"

        // Si tienes campos editables, también podrías configurarlos aquí
        // binding.etUserName.setText("Usuario Ejemplo")
        // binding.etUserEmail.setText("usuario@ejemplo.com")
    }

    private fun openImageChooser() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            val imageUri: Uri = data.data!!

            // Aquí mostrarías la imagen seleccionada
            binding.ivProfileImage.setImageURI(imageUri)

            // En un caso real, aquí subirías la imagen a tu backend
            uploadImageToServer(imageUri)
        }
    }

    private fun uploadImageToServer(imageUri: Uri) {
        // Simular la subida de la imagen al servidor
        Toast.makeText(context, "Simulando subida de imagen...", Toast.LENGTH_SHORT).show()

        // En una implementación real, aquí harías la llamada a la API
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}