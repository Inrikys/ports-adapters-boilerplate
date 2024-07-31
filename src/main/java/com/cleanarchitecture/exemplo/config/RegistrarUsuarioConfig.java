package com.cleanarchitecture.exemplo.config;

import com.cleanarchitecture.exemplo.application.core.usecase.RegistrarUsuarioUseCase;
import com.cleanarchitecture.exemplo.application.ports.out.BuscarEnderecoPeloCepOutputPort;
import com.cleanarchitecture.exemplo.application.ports.out.RegistrarUsuarioOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegistrarUsuarioConfig {

    @Bean
    public RegistrarUsuarioUseCase registrarUsuarioUseCase(
            RegistrarUsuarioOutputPort registrarUsuarioOutputPort,
            BuscarEnderecoPeloCepOutputPort buscarEnderecoPeloCepOutputPort
    ) {
        return new RegistrarUsuarioUseCase(registrarUsuarioOutputPort, buscarEnderecoPeloCepOutputPort);
    }
}
