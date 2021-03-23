package io.github.andreyfillipe.pix.excluir

import io.github.andreyfillipe.ExcluirPixRequest
import io.github.andreyfillipe.KeyManagerExcluirGrpcServiceGrpc
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.PathVariable
import java.util.*

@Controller("/api/clientes/{clienteId}/pix/{pixId}")
class ExcluirChavePixController(
    private val grpcClient: KeyManagerExcluirGrpcServiceGrpc.KeyManagerExcluirGrpcServiceBlockingStub
) {
    @Delete
    fun excluir(@PathVariable clienteId: UUID,
                @PathVariable pixId: UUID) : HttpResponse<Any> {
        grpcClient.excluir(ExcluirPixRequest.newBuilder()
                                .setClienteId(clienteId.toString())
                                .setPixId(pixId.toString())
                                .build()
        )

        return HttpResponse.noContent()
    }
}