package com.example.piedrapapelotijera

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

// Clase principal de la aplicación que representa la pantalla inicial
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Asocia el layout de la pantalla principal con esta actividad
        setContentView(R.layout.pantalla_principal)

        // Busca el botón "Play" en el layout mediante su ID
        val btnPlay: Button = findViewById(R.id.btnPlay)

        // Configura un listener para manejar clics en el botón
        btnPlay.setOnClickListener {
            // Crea un intento para navegar a la actividad `SplashGameActivity`
            val intent = Intent(this, SplashGameActivity::class.java)
            // Inicia la nueva actividad
            startActivity(intent)
        }
    }
}
