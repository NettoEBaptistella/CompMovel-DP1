package pt.ulosofona.cm.kotlin.challenge.models

import java.util.*

open class Veiculo(val identificador: String, x: Int, y: Int) : Posicao(x, y) {
    var dataDeAquisicao: Date? = null

    fun dataDeAquisicao(date: Date) {
        this.dataDeAquisicao = date
    }

    open fun requerCarta(): Boolean {
        return true
    }

    override fun toString(): String {
        return "Veiculo | $identificador | $dataDeAquisicao | Posicao | x:$x | y:$y"
    }

}