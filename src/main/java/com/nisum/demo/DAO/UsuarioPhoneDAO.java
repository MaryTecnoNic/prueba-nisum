package com.nisum.demo.DAO;

import com.nisum.demo.entity.UsuarioPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioPhoneDAO extends JpaRepository<UsuarioPhone, UUID> {
}
