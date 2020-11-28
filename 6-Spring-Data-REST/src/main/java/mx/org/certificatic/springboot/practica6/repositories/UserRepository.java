package mx.org.certificatic.springboot.practica6.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import mx.org.certificatic.springboot.practica6.entities.User;

// define rest repository
@CrossOrigin
@RepositoryRestResource(path = "usuarios", collectionResourceRel = "amigos", itemResourceRel = "my_self")
public interface UserRepository extends JpaRepository<User, Long> { // Implementa JpaRepository

	// define rest resource
	// define query method findByName
	@RestResource(exported = true, rel = "find", path = "find_by_name")
	List<User> findByName(String name);
}