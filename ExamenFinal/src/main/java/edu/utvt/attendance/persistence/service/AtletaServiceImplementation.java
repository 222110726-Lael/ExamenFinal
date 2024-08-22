package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.utvt.attendance.persistence.entities.Atleta;
import edu.utvt.attendance.persistence.repositories.AtletaRepository;

@Service
public class AtletaServiceImplementation implements AtletaService {
	
	@Autowired
	private AtletaRepository atletaRepository;

	@Override
	public Atleta save(Atleta atleta) {
		// TODO Auto-generated method stub
		return this.atletaRepository.save(atleta);
	}

	@Override
	public Atleta update(String id, Atleta atleta) {
		// TODO Auto-generated method stub
		Optional <Atleta> atletaOptional = null;
		atletaOptional = this.atletaRepository.findById(id);
		
		if(atletaOptional.isPresent()) {
			
			atletaOptional.get().setId(atleta.getId());
			atletaOptional.get().setFirstName(atleta.getFirstName());
			atletaOptional.get().setLastName(atleta.getLastName());
			atletaOptional.get().setAge(atleta.getAge());
			atletaOptional.get().setSport(atleta.getSport());
			atletaOptional.get().setEmail(atleta.getEmail());
			
			this.atletaRepository.save(atletaOptional.get());
		}
		
		return atletaRepository.save(atletaOptional.get());
	}

	@Override
	public List<Atleta> getAll() {
		return this.atletaRepository.findAll();
	}

	@Override
	public Optional<Atleta> findById(String id) {
		return this.atletaRepository.findById(id);
	}

	@Override
	public ResponseEntity<Atleta> deleteById(String id) {
		// TODO Auto-generated method stub
		Optional <Atleta> atletaOptional = null;
		ResponseEntity <Atleta> responseEntity = null;
		
		atletaOptional = this.atletaRepository.findById(id);
		
		if(atletaOptional.isPresent()) {
			this.atletaRepository.delete(atletaOptional.get());
			responseEntity = ResponseEntity.noContent().build();
		}else {
			responseEntity = ResponseEntity.notFound().build();
		}
				
		return null;
	}

}
