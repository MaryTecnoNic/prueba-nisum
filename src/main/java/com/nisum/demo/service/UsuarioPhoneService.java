package com.nisum.demo.service;

import com.nisum.demo.entity.DTO.PhoneDTO;
import com.nisum.demo.entity.Usuario;
import com.nisum.demo.entity.UsuarioPhone;

import java.util.List;

public interface UsuarioPhoneService {

    List<UsuarioPhone> savePhone(List<PhoneDTO> listUsuarioPhone, Usuario oUsuario);
}
