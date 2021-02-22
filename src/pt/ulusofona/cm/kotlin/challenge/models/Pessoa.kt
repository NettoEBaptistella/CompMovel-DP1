package pt.ulosofona.cm.kotlin.challenge.models

import pt.ulosofona.cm.kotlin.challenge.interfaces.Movimentavel
import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*
import kotlin.jvm.Throws

data class Pessoa(val nome: String, private val dataDeNascimento: Date) : Movimentavel {

    var carta: Carta? = null
    val veiculos = arrayListOf<Veiculo>()
    var posicao: Posicao

    init {
        posicao = Posicao(0,0)
    }

    fun comprarVeiculo(veiculo: Veiculo) {
        veiculo.atuaalizaData()
        veiculos.add(veiculo)
    }

    @Throws(VeiculoNaoEncontradoException::class)
    fun pesquisarVeiculo(identificador: String): Veiculo {
        for (x in veiculos) {
            if (x.identificador.equals(identificador)) {
                return x
            }
        }
        return throw VeiculoNaoEncontradoException("Veiculo não encontrado")
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa) {
        veiculos.remove(pesquisarVeiculo(identificador))
        comprador.comprarVeiculo(pesquisarVeiculo(identificador))
    }

    fun ligarCarro(carro: Carro) {
        carro.motor.ligar()
    }

    fun desligaCarro(carro: Carro) {
        carro.motor.desligar()
    }

    @Throws(AlterarPosicaoException::class)
    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        for (veiculo in veiculos) {
            if (veiculo.identificador.equals(identificador)) {
                if (veiculo.requerCarta() && !temCarta()) {
                    throw PessoaSemCartaException("$nome não tem carta para conduzir o veículo indicado")
                }
                veiculo.moverPara(x, y)
                break
            }
        }
    }

    fun temCarta(): Boolean {
        return carta != null
    }

    @Throws(MenorDeIdadeException::class)
    fun tirarCarta() {
        val dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        val dateString = formatter.format(dataDeNascimento)
        val localDate = LocalDate.parse(dateString, dateTimeFormatter)
        val menorDeIdade = ChronoUnit.YEARS.between(localDate, LocalDate.now())
        if (menorDeIdade < 18) {
            throw MenorDeIdadeException("Não pode tirar a carta, Menor de idade")
        } else {
            carta = Carta()
        }
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicaoPara(x, y)
    }


    override fun toString(): String {
        val formatter = SimpleDateFormat("dd-MM-yyyy")
        val dtNasc = formatter.format(dataDeNascimento)
        return "Pessoa | $nome | $dtNasc | Posicao | x:${posicao.x} | y:${posicao.y}"
    }


}


