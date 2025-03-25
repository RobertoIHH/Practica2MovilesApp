package com.example.principal.api

import com.example.principal.model.ChangePasswordRequest
import com.example.principal.model.UpdateProfileRequest
import com.example.principal.model.User
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface UserService {
    @GET("perfil")
    fun getUserProfile(): Call<User>

    @POST("perfil/actualizar-info")
    fun updateProfile(@Body request: UpdateProfileRequest): Call<User>

    @POST("perfil/actualizar-password")
    fun changePassword(@Body request: ChangePasswordRequest): Call<Void>

    @Multipart
    @POST("perfil/actualizar-imagen")
    fun updateProfileImage(@Part image: MultipartBody.Part): Call<User>
}