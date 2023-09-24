package com.nisum.demo.controller;

import com.nisum.demo.entity.DTO.UsuarioDTO;
import com.nisum.demo.entity.Usuario;
import com.nisum.demo.service.UsuarioService;
import com.nisum.demo.serviceImpl.UsuarioServiceImpl;
import com.nisum.demo.utils.Mensaje;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    private UsuarioService oUsuarioService;

    public UsuarioController(UsuarioServiceImpl oUsuarioService) {
        this.oUsuarioService = oUsuarioService;
    }

    @ApiOperation(value = "Lista los usuarios guardados.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. Muestra los usuaros guardados", response = Usuario.class),
            @ApiResponse(code = 401, message = "Desautorizazdo."),
            @ApiResponse(code = 403, message = "Prohibido."),
            @ApiResponse(code = 404, message = "No encontrado.")
    })
    @GetMapping("/verUsuario")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> getListUsuario() {
        return oUsuarioService.getListUsuario();
    }


//    @GetMapping("/buscar")
//    @ResponseStatus(HttpStatus.OK)
//    public Usuario buscarUsuario() {
//       return oUsuarioService.getUsuarioByUsername("admin");
//    }

    @ApiOperation(value = "Crea usuario.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Usuario creado correctamente.", response = Mensaje.class),
            @ApiResponse(code = 401, message = "Desautorizazdo."),
            @ApiResponse(code = 403, message = "Prohibido."),
            @ApiResponse(code = 404, message = "No encontrado.")
    })
    @PostMapping("/crearUsuario")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Mensaje> saveUser(@RequestBody UsuarioDTO oUsuarioDTO) {
        return oUsuarioService.guardarUsuario(oUsuarioDTO);
    }
}
