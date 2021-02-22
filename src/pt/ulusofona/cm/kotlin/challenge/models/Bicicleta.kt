package pt.ulosofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import java.text.SimpleDateFormat
import kotlin.jvm.Throws

class Bicicleta(identificador: String) : Veiculo(identificador) {

    override fun requerCarta() : Boolean {
        return false
    }

    override fun toString(): String {
        val formatter = SimpleDateFormat("dd-MM-yyyy")
        val dtAqs = formatter.format(dataDeAquisicao)
        return "Bicicleta | $identificador | $dtAqs | Posicao | x:${posicao.x} | y:${posicao.y}"
    }

    @Throws(AlterarPosicaoException::class)
    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicaoPara(x, y)
    }
}