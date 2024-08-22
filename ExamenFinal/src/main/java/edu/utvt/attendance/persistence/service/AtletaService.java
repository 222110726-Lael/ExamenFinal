package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import edu.utvt.attendance.persistence.entities.Atleta;

public interface AtletaService {
	
	public Atleta save(Atleta atleta);
	
	public Atleta update(String id, Atleta atleta);
	
	public List<Atleta> getAll();
	
	public Optional<Atleta> findById(String id);
	
	public ResponseEntity<Atleta> deleteById(String id);

}
