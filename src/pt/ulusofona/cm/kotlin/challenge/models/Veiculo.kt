package pt.ulosofona.cm.kotlin.challenge.models

import pt.ulosofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.*

abstract class Veiculo(val identificador: String) : Movimentavel {

    var posicao: Posicao
    var dataDeAquisicao: Date

    init {
        this.posicao = Posicao(0, 0)
        this.dataDeAquisicao = Date()
    }

    fun dataDeAquisicao(date: Date) {
        this.dataDeAquisicao = date
    }

    abstract fun requerCarta(): Boolean

    fun atuaalizaData() {
        this.dataDeAquisicao = Date()
    }

    override fun toString(): String {
        return "Veiculo | $identificador | $dataDeAquisicao | Posicao | x:$posicao.x | y:$posicao.y"
    }

}