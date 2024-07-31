package com.cleanarchitecture.exemplo.adapters.in.web.request;

import com.cleanarchitecture.exemplo.application.core.domain.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrarUsuarioRequest {

    @NotBlank
    @JsonProperty("nome")
    private String nome;

    @NotBlank
    @JsonProperty("sobrenome")
    private String sobrenome;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonProperty("data_nascimento")
    private LocalDate dataNascimento;

    @NotBlank
    @JsonProperty("celular")
    private String celular;

    @NotBlank
    @JsonProperty("cep")
    private String cep;

    @NotBlank
    @JsonProperty("numero")
    private String numero;

    public Usuario toUsuario() {
        return Usuario.builder()
                .setNome(nome)
                .setSobrenome(sobrenome)
                .setDataNascimento(dataNascimento)
                .setCelular(celular)
                .build();
    }
}
