package pt.ulosofona.cm.kotlin.challenge.interfaces

import pt.ulosofona.cm.kotlin.challenge.models.Pessoa
import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import kotlin.jvm.Throws

interface Movimentavel {

    @Throws(AlterarPosicaoException::class)
    fun moverPara(x: Int, y: Int)
}