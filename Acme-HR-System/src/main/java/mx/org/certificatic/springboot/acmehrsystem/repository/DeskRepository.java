package mx.org.certificatic.springboot.acmehrsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.org.certificatic.springboot.acmehrsystem.model.Desk;

public interface DeskRepository extends JpaRepository<Desk, Long> {

}
