package edu.utvt.attendance.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.utvt.attendance.persistence.entities.Atleta;

public interface AtletaRepository extends JpaRepository<Atleta, String> {

}
