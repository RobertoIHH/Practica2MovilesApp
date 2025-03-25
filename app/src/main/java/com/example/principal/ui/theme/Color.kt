package com.example.principal.ui.theme

import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.example.principal.R

/**
 * Clase de utilidad para manejar colores de la aplicación
 */
object Color {
    // Colores primarios
    @ColorRes val primaryColorRes = R.color.primary
    @ColorRes val primaryDarkColorRes = R.color.primary_dark
    @ColorRes val primaryLightColorRes = R.color.primary_light
    @ColorRes val accentColorRes = R.color.accent

    // Colores básicos
    @ColorRes val whiteColorRes = R.color.white
    @ColorRes val blackColorRes = R.color.black

    // Colores de interfaz
    @ColorRes val backgroundColorRes = R.color.gray_light
    @ColorRes val navBackgroundColorRes = R.color.nav_background
    @ColorRes val navItemColorRes = R.color.nav_item_color

    // Colores de estado
    @ColorRes val successColorRes = R.color.success_green
    @ColorRes val warningColorRes = R.color.warning_orange
    @ColorRes val errorColorRes = R.color.error_red
}