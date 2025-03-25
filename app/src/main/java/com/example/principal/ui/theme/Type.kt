package com.example.principal.ui.theme

import androidx.annotation.StyleRes
import com.example.principal.R

/**
 * Clase de utilidad para manejar tipografías de la aplicación
 */
object Type {
    // Estilos de texto usando recursos estándar de Android
    @StyleRes val headlineLargeStyle = android.R.style.TextAppearance_Material_Headline
    @StyleRes val headlineMediumStyle = android.R.style.TextAppearance_Material_Title
    @StyleRes val headlineSmallStyle = android.R.style.TextAppearance_Material_Subhead

    @StyleRes val titleLargeStyle = android.R.style.TextAppearance_Material_Title
    @StyleRes val titleMediumStyle = android.R.style.TextAppearance_Material_Subhead
    @StyleRes val titleSmallStyle = android.R.style.TextAppearance_Material_Body2

    @StyleRes val bodyLargeStyle = android.R.style.TextAppearance_Material_Body1
    @StyleRes val bodyMediumStyle = android.R.style.TextAppearance_Material_Body2
    @StyleRes val bodySmallStyle = android.R.style.TextAppearance_Material_Caption

    @StyleRes val buttonStyle = android.R.style.TextAppearance_Material_Button
}