package com.nisum.demo.service;

import com.nisum.demo.entity.DTO.UsuarioDTO;
import com.nisum.demo.entity.Usuario;
import com.nisum.demo.utils.Mensaje;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuarioService {

    List<Usuario> getListUsuario();

    ResponseEntity<Mensaje> guardarUsuario(UsuarioDTO oUsuarioDTO);
}
