package com.example.piedrapapelotijera

import android.widget.ImageView

// Clase encargada de gestionar la visualización de las imágenes en la interfaz
class GestorVisual(private val ivRespuestaMaquina: ImageView) {

    // Método para mostrar la opción seleccionada en el juego
    fun mostrarOpcion(opcion: String) {
        // Determina el recurso de imagen (drawable) según la opción dada
        val drawableId = when (opcion) {
            "Piedra" -> R.drawable.piedra // Imagen para "Piedra"
            "Papel" -> R.drawable.papel   // Imagen para "Papel"
            "Tijera" -> R.drawable.tijera // Imagen para "Tijera"
            else -> R.drawable.ic_launcher_background // Imagen por defecto
        }
        // Establece la imagen correspondiente en el ImageView
        ivRespuestaMaquina.setImageResource(drawableId)
    }
}
