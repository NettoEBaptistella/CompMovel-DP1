package pt.ulosofona.cm.kotlin.challenge.models

class Carro(val motor:Motor, identificador: String, x: Int, y: Int) : Veiculo(identificador, x, y) {


    override fun requerCarta() : Boolean {
        return true
    }

    override fun toString(): String {
        return "Carro | $identificador | $dataDeAquisicao | Posicao | x:$x | y:$y"
    }

}