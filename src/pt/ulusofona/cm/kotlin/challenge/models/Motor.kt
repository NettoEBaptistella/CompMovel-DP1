package pt.ulosofona.cm.kotlin.challenge.models

abstract class Motor(val cavalos:Int, val cilindradas:Int) {
    var ligado: Boolean = false

    override fun toString(): String {
        return "Motor | $cavalos | $cilindradas"
    }
}