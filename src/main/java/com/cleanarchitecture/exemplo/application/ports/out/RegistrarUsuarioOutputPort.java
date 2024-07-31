package com.cleanarchitecture.exemplo.application.ports.out;

import com.cleanarchitecture.exemplo.application.core.domain.Usuario;

public interface RegistrarUsuarioOutputPort {

    Usuario registrar(Usuario usuario);

}
