package com.example.piedrapapelotijera

import android.os.Handler
import android.os.Looper

// Clase para gestionar la lógica del juego "Piedra, Papel o Tijera"
class JuegoManager(
    private val onContadorUpdate: (Int) -> Unit, // Callback para actualizar el contador en la UI
    private val onJuegoTerminado: (String, String) -> Unit, // Callback para mostrar el resultado y la opción de la máquina
    private val onPuntosUpdate: (Int, Int) -> Unit // Callback para actualizar los puntos del jugador y de la máquina
) {
    // Opciones disponibles en el juego
    private val opciones = listOf("Piedra", "Papel", "Tijera")
    // Handler para manejar tareas en segundo plano en el hilo principal
    private val handler = Handler(Looper.getMainLooper())

    // Variables para mantener el puntaje de ambos jugadores
    private var puntosJugador = 0
    private var puntosMaquina = 0

    // Método para iniciar el juego con la elección del usuario
    fun iniciarJuego(opcionUsuario: String) {
        var contador = 3 // Contador inicial para la cuenta regresiva

        // Objeto Runnable que maneja la lógica de la cuenta regresiva
        val contadorRunnable = object : Runnable {
            override fun run() {
                if (contador > 0) {
                    // Llama al callback para actualizar el contador en la UI
                    onContadorUpdate(contador)
                    contador-- // Decrementa el contador
                    // Vuelve a ejecutar el Runnable después de 500ms
                    handler.postDelayed(this, 500)
                } else {
                    // Una vez que el contador llega a 0, genera la opción de la máquina
                    val opcionMaquina = opciones.random()
                    // Determina el resultado del juego
                    val resultado = determinarResultado(opcionUsuario, opcionMaquina)

                    // Actualiza el puntaje según el resultado
                    when (resultado) {
                        "Ganaste" -> puntosJugador++
                        "Perdiste" -> puntosMaquina++
                    }

                    // Llama a los callbacks para actualizar los puntos y mostrar el resultado final
                    onPuntosUpdate(puntosJugador, puntosMaquina)
                    onJuegoTerminado(resultado, opcionMaquina)
                }
            }
        }

        // Inicia la cuenta regresiva
        handler.post(contadorRunnable)
    }

    // Método privado para determinar el resultado del juego basado en las reglas
    private fun determinarResultado(usuario: String, maquina: String): String {
        return when {
            usuario == maquina -> "Empate" // Caso de empate
            // Caso donde el jugador gana
            (usuario == "Piedra" && maquina == "Tijera") ||
                    (usuario == "Papel" && maquina == "Piedra") ||
                    (usuario == "Tijera" && maquina == "Papel") -> "Ganaste"
            // Si no es empate ni gana, entonces el jugador pierde
            else -> "Perdiste"
        }
    }
}
