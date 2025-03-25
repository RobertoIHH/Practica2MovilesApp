package com.example.principal.api

import com.example.principal.model.LoginRequest
import com.example.principal.model.LoginResponse
import com.example.principal.model.RegisterRequest
import com.example.principal.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("api/auth/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @POST("api/register")
    fun register(@Body request: RegisterRequest): Call<User>
}