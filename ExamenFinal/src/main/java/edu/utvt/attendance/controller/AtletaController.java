package edu.utvt.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.utvt.attendance.persistence.entities.Atleta;
import edu.utvt.attendance.persistence.service.AtletaService;

@RestController
@RequestMapping("/api/v1/atletas")

public class AtletaController {
	
	@Autowired
	private AtletaService atletaService;
	
	@GetMapping
	public List<Atleta> get() {
		return this.atletaService.getAll();
	}
	
	@PostMapping
	public ResponseEntity<Atleta> save(@RequestBody Atleta atleta){
		return ResponseEntity.created(null).body(this.atletaService.save(atleta));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Atleta> update(@PathVariable ("id") String id, @RequestBody Atleta atleta){
		return ResponseEntity.ok(this.atletaService.update(id, atleta));
	}

	@DeleteMapping ("/{id}")
	public ResponseEntity<Atleta> delete(@PathVariable ("id") String id){
		return this.atletaService.deleteById(id);
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Atleta> findById(@PathVariable ("id") String id){
		return ResponseEntity.of(this.atletaService.findById(id));
	}
}
