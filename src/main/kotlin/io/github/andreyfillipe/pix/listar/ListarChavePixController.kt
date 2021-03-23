package io.github.andreyfillipe.pix.listar

import io.github.andreyfillipe.KeyManagerListarGrpcServiceGrpc
import io.github.andreyfillipe.ListarPixRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import java.util.*

@Controller("/api/clientes/{clienteId}/pix")
class ListarChavePixController(
    private val grpcClient: KeyManagerListarGrpcServiceGrpc.KeyManagerListarGrpcServiceBlockingStub
) {

    @Get
    fun listar(@PathVariable clienteId: UUID) : HttpResponse<Any> {
        val response = grpcClient.listar(
            ListarPixRequest.newBuilder()
                .setClienteId(clienteId.toString())
                .build()
        )

        val lista = response.chavePixList.map { ChavePixResponse(it) }

        return HttpResponse.ok(lista)
    }
}