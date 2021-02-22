package pt.ulosofona.cm.kotlin.challenge.models

import pt.ulosofona.cm.kotlin.challenge.interfaces.Ligavel
import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import java.text.SimpleDateFormat
import kotlin.jvm.Throws

class Carro(val motor:Motor, identificador: String) : Veiculo(identificador), Ligavel {


    override fun requerCarta() : Boolean {
        return true
    }

    @Throws(AlterarPosicaoException::class)
    override fun moverPara(x: Int, y: Int) {
        if(!motor.estaLigado()){
            motor.ligar()
        }
        posicao.alterarPosicaoPara(x, y)
        motor.desligar()
    }

    override fun ligar() {
        motor.ligar()
    }

    override fun desligar() {
        motor.desligar()
    }

    override fun estaLigado(): Boolean {
        return motor.estaLigado()
    }



    override fun toString(): String {
        val formatter = SimpleDateFormat("dd-MM-yyyy")
        val dtAqs = formatter.format(dataDeAquisicao)
        return "Carro | $identificador | $dtAqs | Posicao | x:${posicao.x} | y:${posicao.y}"
    }

}