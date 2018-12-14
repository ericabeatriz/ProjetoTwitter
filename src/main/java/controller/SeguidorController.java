package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.ResourceAccessException;

import modelo.Seguidor;
import repository.SeguidorRepository;

public class SeguidorController {


	@Autowired
	private SeguidorRepository seguidorRepository;

	@GetMapping("/seguidor")
	public Page<Seguidor> getSeguidor (Pageable pageable){
		return seguidorRepository.findAll(pageable);

	}

	@PostMapping("/seguidor")
	public Seguidor createSeguidor(@Valid @RequestBody Seguidor seguidor) {
					return seguidorRepository.save(seguidor);

	}
	
	@PutMapping("/seguidor/{seguidorId}")
	public  Seguidor uptadeSeguidor(@PathVariable long seguidorId,	
			@Valid @RequestBody Seguidor seguidorRequest){
		return seguidorRepository.findById(seguidorId)
				.map(seguidorInsert ->{
					seguidorInsert.setId(seguidorRequest.getId());
				
					return seguidorRepository.save(seguidorInsert);

				}).orElseThrow(() -> new ResourceAccessException("Postagem nao achado:" + seguidorId));

}
	@DeleteMapping("/postagem/{postagemId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable long postagemId){
		return seguidorRepository.findById(postagemId)
				.map( postagem -> {
					seguidorRepository.delete(postagem);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceAccessException("postagem nao encontrado" + postagemId));
	}
}
