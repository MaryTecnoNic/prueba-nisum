package com.nisum.demo.entity;

import com.nisum.demo.entity.DTO.UsuarioDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioPhone> phone;

    @Column(name = "created", nullable = false, updatable = false)
    private Date created;

     @Column(name = "modified")
     private Date modified;

     @Column(name = "last_login", nullable = false)
     private Date last_login;

     @Column(name = "token", nullable = false)
     private String token;

    @Column(name = "isactive", nullable = false)
    private Boolean isactive;

    public Usuario(UsuarioDTO oUsuarioDTO) {
        this.username = oUsuarioDTO.getUsername();
        this.email = oUsuarioDTO.getEmail();
        this.password = oUsuarioDTO.getPassword();
    }

    public Usuario(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Usuario(String username, String email, String password, Date created, Date last_login, String token, Boolean isactive) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.created = created;
        this.last_login = last_login;
        this.token = token;
        this.isactive = isactive;
    }
}
