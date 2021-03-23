package io.github.andreyfillipe.pix.listar

import io.github.andreyfillipe.ListarPixResponse
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

class ChavePixResponse(
    response: ListarPixResponse.ChavePix
) {
    val pixId = response.pixId
    val tipoChave = response.tipoChave
    val valorChave = response.valorChave
    val tipoConta = response.tipoConta.name
    val criadoEm = response.criadoEm.let {
        LocalDateTime.ofInstant(Instant.ofEpochSecond(it.seconds, it.nanos.toLong()), ZoneOffset.UTC)
    }
}