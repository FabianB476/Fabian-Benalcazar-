package com.example.piedrapapelotijera

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

// Actividad que muestra una pantalla de bienvenida (splash screen) al iniciar la app
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Asigna el diseño correspondiente a la pantalla de bienvenida
        setContentView(R.layout.splash_screen)

        // Navega automáticamente a MainActivity después de 3 segundos
        Handler(Looper.getMainLooper()).postDelayed({
            // Crea un intent para abrir MainActivity
            startActivity(Intent(this, MainActivity::class.java))
            // Finaliza la actividad actual para que no permanezca en la pila de actividades
            finish()
        }, 3000) // Tiempo de retraso en milisegundos (3 segundos)
    }
}
