package com.nisum.demo;

import com.nisum.demo.DAO.UsuarioDAO;
import com.nisum.demo.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class PruebaApplication {

	@Autowired
	UsuarioDAO oUsuarioDAO;

	@Autowired
	PasswordEncoder passwordEncoder;
	private final java.sql.Date fechaActual = new java.sql.Date(new java.util.Date().getTime());

	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}

	@Bean
	CommandLineRunner init(){
		return args -> {
			Usuario oUsuario = new Usuario("admin",
					"admin@gmail.com",
					new BCryptPasswordEncoder().encode("123456"),
					fechaActual,
					fechaActual,
					"prueba",
					true);

			oUsuarioDAO.save(oUsuario);
		};
	}


}
