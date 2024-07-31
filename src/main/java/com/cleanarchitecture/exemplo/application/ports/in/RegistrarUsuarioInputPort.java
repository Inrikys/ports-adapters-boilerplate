package com.cleanarchitecture.exemplo.application.ports.in;

import com.cleanarchitecture.exemplo.application.core.domain.Usuario;

public interface RegistrarUsuarioInputPort {

    Usuario executar(Usuario novoUsuario, String cep, String numero);

}
