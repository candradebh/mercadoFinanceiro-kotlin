package dev.carlosandrade.mercadoFincanceiro.controllers

import dev.carlosandrade.mercadoFincanceiro.model.Ativo
import dev.carlosandrade.mercadoFincanceiro.repository.AtivoRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/ativos")
class AtivoController (val repository: AtivoRepository) {

    @GetMapping("/all")
    fun all () = ResponseEntity.ok(repository.findAll())

    @PostMapping
    fun create (@RequestBody ativo : Ativo) = ResponseEntity.ok(repository.save(ativo))

    @GetMapping ("{ticker}")
    fun read (@PathVariable ticker:String) = ResponseEntity.ok(repository.findByTicker(ticker))

    @PutMapping("{ticker}")
    fun update (@PathVariable ticker : String, @Validated @RequestBody ativo : Ativo) : ResponseEntity<Ativo> {
        return repository.findByTicker(ticker).map { existingAtivo ->
            val updatedAtivo: Ativo = existingAtivo
                .copy(nome= ativo.nome, cnpj = ativo.cnpj, setor = ativo.setor, subSetor = ativo.subSetor)
            ResponseEntity.ok().body(repository.save(updatedAtivo))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("{ticker}")
    fun deletePostById(@PathVariable ticker: String): ResponseEntity<Void> {

        return repository.findByTicker(ticker).map { ativo  ->
            repository.delete(ativo)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

    }


}