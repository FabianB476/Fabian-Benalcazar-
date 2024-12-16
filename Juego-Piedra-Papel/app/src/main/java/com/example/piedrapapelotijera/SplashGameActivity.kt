package com.example.piedrapapelotijera

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

// Actividad que muestra una pantalla de bienvenida específica antes de iniciar el juego
class SplashGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece el diseño para la pantalla de bienvenida del juego
        setContentView(R.layout.splash_game)

        // Simula una breve pantalla de carga antes de abrir la actividad principal del juego
        Handler(Looper.getMainLooper()).postDelayed({
            // Crea un intent para iniciar la actividad del juego
            val intent = Intent(this, JuegoActivity::class.java)
            startActivity(intent) // Abre la actividad del juego
            finish() // Finaliza esta actividad para que no quede en la pila de actividades
        }, 2000) // Retraso de 2 segundos antes de cambiar de actividad
    }
}
