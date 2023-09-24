package com.nisum.demo.DAO;

import com.nisum.demo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findOneByEmail(String email);

    Optional<Usuario> findOneByUsername(String username);
}
