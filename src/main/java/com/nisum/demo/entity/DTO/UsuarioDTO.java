package com.nisum.demo.entity.DTO;

import lombok.Data;

import java.util.List;

@Data
public class UsuarioDTO {

    private String username;
    private String email;
    private String password;
    private List<PhoneDTO> phone;
}
