package com.estudo.aws.api_reembolsos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.aws.api_reembolsos.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
    boolean existsByUsername(String username);


}
