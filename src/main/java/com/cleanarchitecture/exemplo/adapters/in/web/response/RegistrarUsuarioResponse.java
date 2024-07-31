package com.cleanarchitecture.exemplo.adapters.in.web.response;

import com.cleanarchitecture.exemplo.application.core.domain.Endereco;
import com.cleanarchitecture.exemplo.application.core.domain.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrarUsuarioResponse {

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("sobrenome")
    private String sobrenome;

    @JsonProperty("data_nascimento")
    private LocalDate dataNascimento;

    @JsonProperty("celular")
    private String celular;

    @JsonProperty("endereco")
    private RegistrarUsuarioEnderecoResponse endereco;

    public RegistrarUsuarioResponse(Usuario usuarioRegistrado) {
        this.nome = usuarioRegistrado.getNome();
        this.sobrenome = usuarioRegistrado.getSobrenome();
        this.dataNascimento = usuarioRegistrado.getDataNascimento();
        this.celular = usuarioRegistrado.getCelular();
        this.endereco = new RegistrarUsuarioEnderecoResponse(usuarioRegistrado.getEndereco());
    }
}
