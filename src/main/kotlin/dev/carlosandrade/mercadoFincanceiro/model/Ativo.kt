package dev.carlosandrade.mercadoFincanceiro.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "ativos")
data class Ativo (

    @Id
    val ticker : String,
    val nome : String,
    val tipoAtivo : String,
    var cnpj : String ? = null,
    val setor : String ? = null,
    var subSetor : String ? = null
) {


}