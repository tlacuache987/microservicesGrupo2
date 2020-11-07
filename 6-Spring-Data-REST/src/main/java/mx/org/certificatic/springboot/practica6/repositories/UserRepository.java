package mx.org.certificatic.springboot.practica6.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import mx.org.certificatic.springboot.practica6.entities.User;

// define rest repository
// Implementa JpaRepository
public interface UserRepository extends JpaRepository<User, Long> {

	// define rest resource
	// define query method findByName
}