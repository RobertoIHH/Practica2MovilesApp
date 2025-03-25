package com.example.principal.api

import com.example.principal.model.User
import retrofit2.Call
import retrofit2.http.*

interface AdminService {
    @GET("admin/usuarios")
    fun getAllUsers(): Call<List<User>>

    @GET("admin/usuarios/{id}")
    fun getUserById(@Path("id") id: Long): Call<User>

    @POST("admin/usuarios/guardar")
    fun saveUser(@Body user: User): Call<User>

    @POST("admin/usuarios/eliminar/{id}")
    fun deleteUser(@Path("id") id: Long): Call<Void>
}