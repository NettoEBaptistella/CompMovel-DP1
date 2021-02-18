package pt.ulosofona.cm.kotlin.challenge.models

import java.util.*

class Pessoa(val nome: String, val dataDeNascimento: Date, x: Int, y: Int) : Posicao(x, y) {


    var carta: Carta? = null


    val veiculos = arrayListOf<Veiculo>()

    fun comprarVeiculo(veiculo: Veiculo) {
        veiculos.add(veiculo)
    }

    fun pesquisarVeiculo(identificador: String): Veiculo {
        val y: Veiculo = Veiculo("Nãotem", 0, 0)
        for (x in veiculos) {
            if (x.identificador == identificador) {
                return x
            }
        }
        return y
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa) {
        veiculos.remove(pesquisarVeiculo(identificador))
        comprador.comprarVeiculo(pesquisarVeiculo(identificador))
    }

    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        pesquisarVeiculo(identificador).alterarPosicaoPara(x, y)
    }

    fun temCarta(): Boolean {
        return carta != null
    }

    fun tirarCarta() {
        carta = Carta()
    }


    override fun toString(): String {
        return "Pessoa | $nome | $dataDeNascimento | Posicao | x:$x | y:$y"
    }


}


