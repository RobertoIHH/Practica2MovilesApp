package com.example.principal.ui.theme

import android.content.Context
import android.content.res.Resources
import androidx.appcompat.app.AppCompatDelegate
import com.example.principal.R

/**
 * Clase de utilidad para manejar temas de la aplicación
 */
object Theme {
    // Constantes para temas
    const val THEME_LIGHT = 1
    const val THEME_DARK = 2
    const val THEME_SYSTEM = 0

    /**
     * Aplica el tema seleccionado
     * @param themeMode el modo de tema (LIGHT, DARK, o SYSTEM)
     */
    fun applyTheme(themeMode: Int) {
        when (themeMode) {
            THEME_LIGHT -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            THEME_DARK -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            THEME_SYSTEM -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
    }

    /**
     * Obtiene el estilo de tema actual
     * @return el ID del recurso de estilo
     */
    fun getCurrentThemeStyle(): Int {
        return R.style.Theme_SistemaRecomendaciones
    }
}