package io.github.andreyfillipe.pix.cadastrar

import io.github.andreyfillipe.CadastrarPixRequest
import io.github.andreyfillipe.pix.TipoChave
import io.github.andreyfillipe.pix.TipoConta
import io.github.andreyfillipe.validacao.beanValidation.ValidarChavePix
import io.micronaut.core.annotation.Introspected
import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@ValidarChavePix
@Introspected
class NovaChavePixRequest(
    @field:NotNull
    val tipoChave: TipoChave?,
    @field:NotBlank
    @field:Size(max = 77)
    val valorChave: String?,
    @field:NotNull
    val tipoConta: TipoConta?
) {

    fun toCadastrarPixRequest(clienteId: UUID): CadastrarPixRequest {
        return CadastrarPixRequest.newBuilder()
            .setClienteId(clienteId.toString())
            .setTipoChave(io.github.andreyfillipe.TipoChave.valueOf(tipoChave!!.name))
            .setValorChave(valorChave)
            .setTipoConta(io.github.andreyfillipe.TipoConta.valueOf(tipoConta!!.name))
            .build()
    }
}