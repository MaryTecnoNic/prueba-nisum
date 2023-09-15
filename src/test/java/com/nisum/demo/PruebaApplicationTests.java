package com.nisum.demo;

import com.nisum.demo.DAO.UsuarioDAO;
import com.nisum.demo.entity.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DataJpaTest
class PruebaApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	UsuarioDAO repository;

	@BeforeEach
	void setUp() {
	}

	@Test
	public void getListUsuario() {
		Iterable tutorials = repository.findAll();

		assertThat(tutorials).isEmpty();
	}

	@Test
	public void saveUsuario() {
		Usuario oUsuario = repository.save(new Usuario("Username", "marytecnonic@gmail.com","Marca123"));

		assertThat(oUsuario).hasFieldOrPropertyWithValue("username", "Username");
		assertThat(oUsuario).hasFieldOrPropertyWithValue("email", "marytecnonic@gmail.com");
		assertThat(oUsuario).hasFieldOrPropertyWithValue("password", "Marca123");
	}

	@Test
	public void findById() {
		Usuario tut1 = new Usuario("Username", "marytecnonic@gmail.com","Marca123");
		entityManager.persist(tut1);

		Usuario tut2 = new Usuario("Username2", "marytecnonic2@gmail.com","Marca2123");
		entityManager.persist(tut2);

		Usuario foundTutorial = repository.findById(tut2.getId()).get();

		assertThat(foundTutorial).isEqualTo(tut2);
	}

	@Test
	public void verificarCorreExistente() {
		java.sql.Date date = new java.sql.Date(new Date().getTime());

		Usuario tut2 = new Usuario("Username2", "marytecnonic2@gmail.com","Marca2123", date, date,"ss",true );
		String email =   entityManager.persist(tut2).getEmail();

		Optional<Usuario> tutorials = repository.findOneByEmail(email);
		assertThat(tutorials.get().getEmail());
	}
}
