package com.cleanarchitecture.exemplo.adapters.out;

import com.cleanarchitecture.exemplo.adapters.out.repository.UsuarioRepository;
import com.cleanarchitecture.exemplo.adapters.out.repository.entity.UsuarioEntity;
import com.cleanarchitecture.exemplo.application.core.domain.Usuario;
import com.cleanarchitecture.exemplo.application.ports.out.RegistrarUsuarioOutputPort;
import org.springframework.stereotype.Component;

@Component
public class RegistrarUsuarioAdapter implements RegistrarUsuarioOutputPort {

    private final UsuarioRepository usuarioRepository;

    public RegistrarUsuarioAdapter(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario registrar(Usuario usuario) {

        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        UsuarioEntity usuarioEntitySalvo = this.usuarioRepository.save(usuarioEntity);

        return usuarioEntitySalvo.toUsuario();
    }
}
