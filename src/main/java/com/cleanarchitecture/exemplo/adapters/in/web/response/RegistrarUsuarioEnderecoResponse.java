package com.cleanarchitecture.exemplo.adapters.in.web.response;

import com.cleanarchitecture.exemplo.application.core.domain.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrarUsuarioEnderecoResponse {

    private String cep;

    private String numero;

    private String logradouro;

    private String complemento;

    private String bairro;

    private String localidade;

    private String uf;

    public RegistrarUsuarioEnderecoResponse(Endereco endereco) {
        this.cep = endereco.getCep();
        this.numero = endereco.getNumero();
        this.logradouro = endereco.getLogradouro();
        this.complemento = endereco.getComplemento();
        this.bairro = endereco.getBairro();
        this.localidade = endereco.getLocalidade();
        this.uf = endereco.getUf();
    }
}
