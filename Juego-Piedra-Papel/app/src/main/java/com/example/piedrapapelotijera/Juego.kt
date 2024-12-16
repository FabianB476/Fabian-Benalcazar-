package com.example.piedrapapelotijera

// Clase que representa la lógica principal del juego "Piedra, Papel o Tijera"
class Juego {
    // Lista de opciones disponibles en el juego
    private val opciones = listOf("Piedra", "Papel", "Tijera")


    //  Método principal para ejecutar el juego.

    fun jugar(usuario: String): Pair<String, String> {
        // Genera una opción aleatoria para la máquina
        val maquina = generarOpcionMaquina()

        // Determina el resultado comparando la elección del usuario con la de la máquina
        val resultado = when {
            usuario == maquina -> "Empate" // Si ambas opciones son iguales
            (usuario == "Piedra" && maquina == "Tijera") || // Gana el usuario
                    (usuario == "Papel" && maquina == "Piedra") ||
                    (usuario == "Tijera" && maquina == "Papel") -> "Ganaste"
            else -> "Perdiste" // Si no es empate ni gana el usuario, pierde
        }

        // Retorna el resultado y la opción de la máquina como un par (resultado, opciónMaquina)
        return Pair(resultado, maquina)
    }

    /**
     * Genera una opción aleatoria para la máquina a partir de la lista de opciones.
     * @return Una de las opciones: "Piedra", "Papel" o "Tijera".
     */
    private fun generarOpcionMaquina(): String {
        return opciones.random() // Selecciona un elemento aleatorio de la lista
    }
}
