package io.github.andreyfillipe.pix

import io.github.andreyfillipe.KeyManagerCadastrarGrpcServiceGrpc
import io.github.andreyfillipe.KeyManagerConsultarGrpcServiceGrpc
import io.github.andreyfillipe.KeyManagerExcluirGrpcServiceGrpc
import io.github.andreyfillipe.KeyManagerListarGrpcServiceGrpc
import io.grpc.ManagedChannel
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel
import javax.inject.Singleton

@Factory
class GrpcClientFactory(@GrpcChannel("pix") val channel: ManagedChannel) {

    @Singleton
    fun cadastrarChavePix () = KeyManagerCadastrarGrpcServiceGrpc.newBlockingStub(channel)

    @Singleton
    fun excluirChavePix () = KeyManagerExcluirGrpcServiceGrpc.newBlockingStub(channel)

    @Singleton
    fun consultarChavePix () = KeyManagerConsultarGrpcServiceGrpc.newBlockingStub(channel)

    @Singleton
    fun listarChavePix () = KeyManagerListarGrpcServiceGrpc.newBlockingStub(channel)
}