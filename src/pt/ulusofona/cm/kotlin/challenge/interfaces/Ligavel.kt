package pt.ulosofona.cm.kotlin.challenge.interfaces

import pt.ulosofona.cm.kotlin.challenge.models.Carro

interface Ligavel {

    fun ligarMotor(carro: Carro){
        carro.motor.ligado = true
    }

    fun desligarMotor(carro: Carro) {
        carro.motor.ligado = false
    }
}