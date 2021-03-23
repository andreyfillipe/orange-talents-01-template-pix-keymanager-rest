package io.github.andreyfillipe.pix.consultar

import io.github.andreyfillipe.ConsultarPixResponse
import io.github.andreyfillipe.TipoConta
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

class DetalhesChavePixResponse(
    response: ConsultarPixResponse
) {
    val pixId = response.pixId
    val tipoChave = response.chave.tipoChave
    val valorChave = response.chave.valorChave
    val criadoEm = response.chave.criadoEm.let {
        LocalDateTime.ofInstant(Instant.ofEpochSecond(it.seconds, it.nanos.toLong()), ZoneOffset.UTC)
    }
    val tipoConta = response.chave.conta.tipoConta.name
    val conta = mapOf(
        Pair("tipo", tipoConta),
        Pair("instituicao", response.chave.conta.instituicao),
        Pair("nomeTitular", response.chave.conta.nomeTitular),
        Pair("cpfTitular", response.chave.conta.cpfTitular),
        Pair("agencia", response.chave.conta.agencia),
        Pair("numeroConta", response.chave.conta.numeroConta)
    )
}