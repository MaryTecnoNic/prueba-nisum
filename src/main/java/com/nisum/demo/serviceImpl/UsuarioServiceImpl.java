package com.nisum.demo.serviceImpl;

import com.nisum.demo.DAO.UsuarioDAO;
import com.nisum.demo.entity.DTO.PhoneDTO;
import com.nisum.demo.entity.DTO.UsuarioDTO;
import com.nisum.demo.entity.Usuario;
import com.nisum.demo.service.UsuarioPhoneService;
import com.nisum.demo.utils.Mensaje;
import com.nisum.demo.utils.RegularExpression;
import com.nisum.demo.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioServiceImpl implements com.nisum.demo.service.UsuarioService {

    @Autowired
    private UsuarioDAO oUsuarioDAO;

    @Autowired
    private UsuarioPhoneService oUsuarioPhoneService;

    @Override
    public List<Usuario> getListUsuario() {
        return oUsuarioDAO.findAll();
    }

    private Usuario saveUsuario(Usuario usuario) {
        return oUsuarioDAO.save(usuario);
    }

    private Optional<Usuario> findById(UUID id) {
        return oUsuarioDAO.findById(id);
    }

    private Optional<Usuario> verificarCorreExistente(String email){
        return oUsuarioDAO.findOneByEmail(email);
    }

    @Transactional
    @Override
    public ResponseEntity<Mensaje> guardarUsuario(UsuarioDTO oUsuarioDTO) {
        Mensaje oMensaje;
       try {

           if(oUsuarioDTO.getUsername() == null || oUsuarioDTO.getEmail() == null ||  oUsuarioDTO.getPassword() == null || oUsuarioDTO.getPhone() == null || oUsuarioDTO.getPhone() == null){
               oMensaje = new Mensaje.Builder()
                       .mensaje("Los campos no permite nulo.")
                       .builder();
               return new ResponseEntity<>(oMensaje, HttpStatus.BAD_REQUEST);
           }

           if(oUsuarioDTO.getUsername().trim().equals("") || oUsuarioDTO.getEmail().trim().equals("") ||  oUsuarioDTO.getPassword().trim().equals("")){
               oMensaje = new Mensaje.Builder()
                       .mensaje("Los campos no permite vacío.")
                       .builder();
               return new ResponseEntity<>(oMensaje, HttpStatus.BAD_REQUEST);
           }

           if(oUsuarioDTO.getPhone().size() == 0){
               oMensaje = new Mensaje.Builder()
                       .mensaje("Debe ingresar telefonos de contacto.")
                       .builder();
               return new ResponseEntity<>(oMensaje, HttpStatus.BAD_REQUEST);
           }

           //verificar si el correo existe en BD
           if (this.verificarCorreExistente(oUsuarioDTO.getEmail()).isPresent()) {
               oMensaje = new Mensaje.Builder()
                       .mensaje("El correo ya fue registrado.")
                       .builder();
               return new ResponseEntity<>(oMensaje, HttpStatus.BAD_REQUEST);
           }

           if (!Utilities.validarPasswordString(oUsuarioDTO.getEmail(), RegularExpression.REG_EXPRESSION_EMAIL).find()) {
               oMensaje = new Mensaje.Builder()
                       .mensaje("El email ingresado es inválido.")
                       .builder();
               return new ResponseEntity<>(oMensaje, HttpStatus.BAD_REQUEST);
           }

           if (!Utilities.validarPasswordString(oUsuarioDTO.getPassword(), RegularExpression.REG_EXPRESSION_PASSWORD).find()) {
               oMensaje = new Mensaje.Builder()
                       .mensaje("El password ingresado es invalido.")
                       .builder();
               return new ResponseEntity<>(oMensaje, HttpStatus.BAD_REQUEST);
           }

           Usuario oUsuario = new Usuario(oUsuarioDTO);
           java.sql.Date date = new java.sql.Date(new Date().getTime());
           oUsuario.setIsactive(true);
           oUsuario.setCreated(date);
           oUsuario.setLast_login(date);
           oUsuario.setToken(Utilities.getJWTToken(oUsuarioDTO.getUsername()));
           Usuario oUsuarioConID = this.saveUsuario(oUsuario);

           List<PhoneDTO> list = oUsuarioDTO.getPhone();
           try{
               oUsuarioPhoneService.savePhone(list, oUsuarioConID);
           }catch (Exception e){
               oMensaje = new Mensaje.Builder()
                       .mensaje("Los campos de telefono no permiten nulo ni vacío.")
                       .builder();
               return new ResponseEntity<>(oMensaje, HttpStatus.BAD_REQUEST);
           }

           Optional<Usuario> usuarioGuardado = this.findById(oUsuarioConID.getId());
           if (usuarioGuardado.isPresent()) {
               oMensaje = new Mensaje.Builder()
                       .id(usuarioGuardado.get().getId())
                       .created(usuarioGuardado.get().getCreated())
                       .modified(usuarioGuardado.get().getModified() == null ? "" : usuarioGuardado.get().getModified().toString())
                       .last_login(usuarioGuardado.get().getLast_login())
                       .token(usuarioGuardado.get().getToken())
                       .isactive(usuarioGuardado.get().getIsactive())
                       .builder();
               return new ResponseEntity<>(oMensaje, HttpStatus.CREATED);
           } else {
               oMensaje = new Mensaje.Builder()
                       .mensaje("El correo ya fue registrado.")
                       .builder();
               return new ResponseEntity<>(oMensaje, HttpStatus.BAD_REQUEST);
           }

       } catch (Exception e){
           oMensaje = new Mensaje.Builder()
                   .mensaje("Erro al guardar el usuario.")
                   .builder();
           return new ResponseEntity<>(oMensaje, HttpStatus.BAD_REQUEST);
       }
    }



}
