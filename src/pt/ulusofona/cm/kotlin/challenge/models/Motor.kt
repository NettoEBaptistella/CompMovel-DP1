package pt.ulosofona.cm.kotlin.challenge.models

import pt.ulosofona.cm.kotlin.challenge.interfaces.Ligavel
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException

class Motor(val cavalos:Int, val cilindradas:Int) : Ligavel {
    var ligado: Boolean = false

    override fun toString(): String {
        return "Motor | $cavalos | $cilindradas"
    }

    override fun ligar() {
        if (this.ligado) {
            throw VeiculoLigadoException("Veiculo já se encontra ligado")
        } else {
            this.ligado= true
        }
    }


    override fun desligar() {
        if (!this.ligado) {
            throw VeiculoDesligadoException("Veiculo já se encontra desligado")
        } else {
            this.ligado = false
        }
    }

    override fun estaLigado(): Boolean {
        return this.ligado
    }
}