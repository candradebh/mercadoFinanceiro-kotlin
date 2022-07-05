package dev.carlosandrade.mercadoFincanceiro.repository

import dev.carlosandrade.mercadoFincanceiro.model.Ativo
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface AtivoRepository : JpaRepository <Ativo,String> {

    fun findByTicker(ticker:String) : Optional<Ativo>

}