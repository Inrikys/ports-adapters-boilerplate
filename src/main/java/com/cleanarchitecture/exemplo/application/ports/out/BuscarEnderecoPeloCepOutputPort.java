package com.cleanarchitecture.exemplo.application.ports.out;

import com.cleanarchitecture.exemplo.application.core.domain.Endereco;

public interface BuscarEnderecoPeloCepOutputPort {

    Endereco buscar(String cep);

}
