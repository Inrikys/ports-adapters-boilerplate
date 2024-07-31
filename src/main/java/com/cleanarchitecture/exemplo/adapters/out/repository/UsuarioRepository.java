package com.cleanarchitecture.exemplo.adapters.out.repository;

import com.cleanarchitecture.exemplo.adapters.out.repository.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
