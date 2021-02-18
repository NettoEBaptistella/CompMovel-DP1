package pt.ulosofona.cm.kotlin.challenge.models

class Bicicleta(identificador: String) : Veiculo(identificador, x = 0, y = 0) {

    override fun requerCarta() : Boolean {
        return false
    }

    override fun toString(): String {
        return "Bicicleta | $identificador | $dataDeAquisicao | Posicao | x:$x | y:$y"
    }
}