package com.example.principal.model

data class User(
    val id: Long,
    val nombre: String,
    val email: String,
    val roles: List<Role>,
    val imagen: String? = null
)

data class Role(
    val id: Long,
    val nombre: String
)

data class LoginRequest(
    val correo: String,
    val password: String
)

data class LoginResponse(
    val token: String,
    val user: User
)

data class RegisterRequest(
    val nombre: String,
    val email: String,
    val password: String
)

data class UpdateProfileRequest(
    val nombre: String,
    val email: String
)

data class ChangePasswordRequest(
    val currentPassword: String,
    val password: String,
    val confirmPassword: String
)