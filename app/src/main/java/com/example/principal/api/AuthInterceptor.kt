package com.example.principal.api

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    private var sessionManager: SessionManager? = null

    fun setSessionManager(context: Context) {
        if (sessionManager == null) {
            sessionManager = SessionManager(context)
        }
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        // Si hay un token, lo añadimos al header
        sessionManager?.fetchAuthToken()?.let {
            requestBuilder.addHeader("Authorization", "Bearer $it")
        }

        return chain.proceed(requestBuilder.build())
    }
}