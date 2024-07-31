package com.cleanarchitecture.exemplo.adapters.in.web;

import com.cleanarchitecture.exemplo.adapters.in.web.request.RegistrarUsuarioRequest;
import com.cleanarchitecture.exemplo.adapters.in.web.response.RegistrarUsuarioResponse;
import com.cleanarchitecture.exemplo.application.core.domain.Usuario;
import com.cleanarchitecture.exemplo.application.ports.in.RegistrarUsuarioInputPort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class RegistrarUsuarioController {

    private final RegistrarUsuarioInputPort registrarUsuarioInputPort;

    public RegistrarUsuarioController(RegistrarUsuarioInputPort registrarUsuarioInputPort) {
        this.registrarUsuarioInputPort = registrarUsuarioInputPort;
    }

    @PostMapping
    public ResponseEntity<RegistrarUsuarioResponse> registrar(@Valid @RequestBody RegistrarUsuarioRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Usuario novoUsuario = request.toUsuario();
        Usuario usuarioRegistrado = registrarUsuarioInputPort.executar(novoUsuario, request.getCep(), request.getNumero());

        RegistrarUsuarioResponse registrarUsuarioResponse = new RegistrarUsuarioResponse(usuarioRegistrado);

        URI location = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuarioRegistrado.getId()).toUri();
        return ResponseEntity.created(location).body(registrarUsuarioResponse);
    }

}
