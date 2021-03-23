package io.github.andreyfillipe.pix.cadastrar

import io.github.andreyfillipe.KeyManagerCadastrarGrpcServiceGrpc
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import java.util.*
import javax.validation.Valid

@Validated
@Controller("/api/clientes/{clienteId}/pix")
class CadastrarPixController(
    private val grpcClient: KeyManagerCadastrarGrpcServiceGrpc.KeyManagerCadastrarGrpcServiceBlockingStub
) {

    @Post
    fun salvar(@PathVariable clienteId: UUID,
               @Body @Valid request: NovaChavePixRequest) : HttpResponse<Any> {
        val requestClient = request.toCadastrarPixRequest(clienteId)

        val grpcResponse = grpcClient.cadastrar(requestClient)

        return HttpResponse.created(HttpResponse.uri("/api/clientes/${clienteId}/pix/${grpcResponse.pixId}"))
    }
}