package com.example.piedrapapelotijera

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

// Actividad que maneja la lógica y la interfaz del juego
class JuegoActivity : AppCompatActivity() {

    // Declaración de variables para las vistas de la interfaz
    private lateinit var tvContador: TextView // Muestra el conteo regresivo
    private lateinit var tvResultado: TextView // Muestra el resultado del juego
    private lateinit var ivRespuestaMaquina: ImageView // Imagen que muestra la opción de la máquina
    private lateinit var juegoManager: JuegoManager // Maneja la lógica del juego
    private lateinit var tvPuntosJugador: TextView // Puntos del jugador
    private lateinit var tvPuntosMaquina: TextView // Puntos de la máquina

    // Método que se ejecuta al crear la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)

        // Enlazar vistas del diseño XML con las variables declaradas
        tvPuntosJugador = findViewById(R.id.tvPuntosJugador)
        tvPuntosMaquina = findViewById(R.id.tvPuntosMaquina)
        tvContador = findViewById(R.id.tvContador)
        tvResultado = findViewById(R.id.tvResultado)
        ivRespuestaMaquina = findViewById(R.id.ivRespuestaMaquina)

        // Crear una instancia del gestor visual para manejar la imagen de la opción de la máquina
        val gestorVisual = GestorVisual(ivRespuestaMaquina)

        // Inicializar el manejador del juego con funciones callback para actualizar la interfaz
        juegoManager = JuegoManager(
            onContadorUpdate = { contador ->
                // Actualiza el TextView con el valor del contador
                tvContador.text = " $contador"
            },
            onJuegoTerminado = { resultado, opcionMaquina ->
                // Muestra el resultado del juego (Ganaste, Perdiste, Empate)
                tvResultado.text = resultado
                // Actualiza la imagen de la opción elegida por la máquina
                gestorVisual.mostrarOpcion(opcionMaquina)
            },
            onPuntosUpdate = { puntosJugador, puntosMaquina ->
                // Actualiza los puntos del jugador y de la máquina
                tvPuntosJugador.text = "Jugador: $puntosJugador"
                tvPuntosMaquina.text = "Máquina: $puntosMaquina"
            }
        )

        // Configurar botones para manejar las elecciones del jugador
        findViewById<ImageButton>(R.id.btnPiedra).setOnClickListener {
            // Inicia el juego con la opción "Piedra"
            juegoManager.iniciarJuego("Piedra")
        }
        findViewById<ImageButton>(R.id.btnPapel).setOnClickListener {
            // Inicia el juego con la opción "Papel"
            juegoManager.iniciarJuego("Papel")
        }
        findViewById<ImageButton>(R.id.btnTijera).setOnClickListener {
            // Inicia el juego con la opción "Tijera"
            juegoManager.iniciarJuego("Tijera")
        }
    }
}
