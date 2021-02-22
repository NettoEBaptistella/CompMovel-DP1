package pt.ulosofona.cm.kotlin.challenge.interfaces

import pt.ulosofona.cm.kotlin.challenge.models.Carro
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import kotlin.jvm.Throws

interface Ligavel {
    @Throws(VeiculoLigadoException::class)
    fun ligar()

    @Throws(VeiculoDesligadoException::class)
    fun desligar()
    fun estaLigado(): Boolean

}