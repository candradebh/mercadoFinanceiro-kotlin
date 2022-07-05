package dev.carlosandrade.mercadoFincanceiro

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MercadoFincanceiroApplication

fun main(args: Array<String>) {
	runApplication<MercadoFincanceiroApplication>(*args)
	println("No ar")
}
