package com.cleanarchitecture.exemplo.application.core.usecase;

import com.cleanarchitecture.exemplo.application.core.domain.Endereco;
import com.cleanarchitecture.exemplo.application.core.domain.Usuario;
import com.cleanarchitecture.exemplo.application.ports.in.RegistrarUsuarioInputPort;
import com.cleanarchitecture.exemplo.application.ports.out.BuscarEnderecoPeloCepOutputPort;
import com.cleanarchitecture.exemplo.application.ports.out.RegistrarUsuarioOutputPort;

public class RegistrarUsuarioUseCase implements RegistrarUsuarioInputPort {

    private final RegistrarUsuarioOutputPort registrarUsuarioOutputPort;

    private final BuscarEnderecoPeloCepOutputPort buscarEnderecoPeloCepOutputPort;

    public RegistrarUsuarioUseCase(RegistrarUsuarioOutputPort registrarUsuarioOutputPort, BuscarEnderecoPeloCepOutputPort buscarEnderecoPeloCepOutputPort) {
        this.registrarUsuarioOutputPort = registrarUsuarioOutputPort;
        this.buscarEnderecoPeloCepOutputPort = buscarEnderecoPeloCepOutputPort;
    }

    public Usuario executar(Usuario novoUsuario, String cep, String numero) {
        Endereco endereco = this.buscarEnderecoPeloCepOutputPort.buscar(cep);
        novoUsuario.setEndereco(endereco, numero);
        return this.registrarUsuarioOutputPort.registrar(novoUsuario);
    }

}
