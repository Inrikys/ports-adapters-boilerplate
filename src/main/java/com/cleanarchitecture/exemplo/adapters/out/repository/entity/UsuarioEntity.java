package com.cleanarchitecture.exemplo.adapters.out.repository.entity;

import com.cleanarchitecture.exemplo.application.core.domain.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String celular;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_endereco", referencedColumnName = "id")
    private EnderecoEntity endereco;

    public UsuarioEntity(Usuario usuario) {
        this.nome = usuario.getNome();
        this.sobrenome = usuario.getSobrenome();
        this.dataNascimento = usuario.getDataNascimento();
        this.celular = usuario.getCelular();
        this.endereco = new EnderecoEntity(usuario.getEndereco());
    }

    public Usuario toUsuario() {
        return Usuario.builder()
                .setId(id)
                .setNome(nome)
                .setSobrenome(sobrenome)
                .setDataNascimento(dataNascimento)
                .setCelular(celular)
                .setEndereco(endereco.toEndereco())
                .build();
    }
}
