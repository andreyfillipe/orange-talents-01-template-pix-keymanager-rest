package io.github.andreyfillipe.pix.consultar

import io.github.andreyfillipe.ConsultarPixRequest
import io.github.andreyfillipe.KeyManagerConsultarGrpcServiceGrpc
import io.github.andreyfillipe.KeyManagerListarGrpcServiceGrpc
import io.github.andreyfillipe.pix.listar.ChavePixResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import java.util.*

@Controller("/api/clientes/{clienteId}/pix/{pixId}")
class ConsultarChavePixController(
    private val grpcClient: KeyManagerConsultarGrpcServiceGrpc.KeyManagerConsultarGrpcServiceBlockingStub
) {

    @Get
    fun consultar(@PathVariable clienteId: UUID,
                  @PathVariable pixId: UUID) : HttpResponse<Any>{
        val response = grpcClient.consultar(ConsultarPixRequest.newBuilder()
            .setPixId(ConsultarPixRequest.FiltroPorPixId.newBuilder()
                .setClienteId(clienteId.toString())
                .setPixId(pixId.toString())
                .build()
            )
            .build()
        )

        return HttpResponse.ok(DetalhesChavePixResponse(response))
    }
}