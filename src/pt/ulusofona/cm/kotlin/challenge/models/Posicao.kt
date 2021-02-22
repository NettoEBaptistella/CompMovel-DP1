package pt.ulosofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException

data class Posicao (var x: Int,var y: Int ){

    fun alterarPosicaoPara(x: Int, y: Int) {
        if (this.x == x && this.y == y) {
            throw AlterarPosicaoException("A posição selecionada é a que o veiculo se encontra no momento")
        } else {
            this.x = x
            this.y = y
        }
    }

    override fun toString(): String {
        return "Posicao | x:${this.x} | y:${this.y}"
    }


    init {
        this.x = 0
        this.y = 0
    }
}