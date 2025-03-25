package com.example.principal.api

import android.content.Context
import android.content.SharedPreferences
import com.example.principal.model.User
import com.google.gson.Gson

class SessionManager(context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    private val gson = Gson()

    companion object {
        const val PREF_NAME = "AppPrefs"
        const val USER_TOKEN = "user_token"
        const val USER_INFO = "user_info"
    }

    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    fun fetchAuthToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }

    fun saveUserInfo(user: User) {
        val userJson = gson.toJson(user)
        val editor = prefs.edit()
        editor.putString(USER_INFO, userJson)
        editor.apply()
    }

    fun getUserInfo(): User? {
        val userJson = prefs.getString(USER_INFO, null) ?: return null
        return gson.fromJson(userJson, User::class.java)
    }

    fun isAdmin(): Boolean {
        val user = getUserInfo() ?: return false
        return user.roles.any { it.nombre == "ROLE_ADMIN" }
    }

    fun clearSession() {
        val editor = prefs.edit()
        editor.clear()
        editor.apply()
    }
}