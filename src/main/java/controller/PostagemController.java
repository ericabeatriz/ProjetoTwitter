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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;


import modelo.Postagem;
import repository.PostagemRepository;

@RestController
public class PostagemController {

	

		@Autowired
		private PostagemRepository postagemRepository;

		@GetMapping("/postagem")
		public Page<Postagem> getPostagem (Pageable pageable){
			return postagemRepository.findAll(pageable);

		}

		@PostMapping("/postagem")
		public Postagem createPostagem(@Valid @RequestBody Postagem postagem) {
						return postagemRepository.save(postagem);

		}
		
		@PutMapping("/postagem/{postagemId}")
		public Postagem uptadePostagem(@PathVariable long postagemId,	
				@Valid @RequestBody Postagem postagemRequest){
			return postagemRepository.findById(postagemId)
					.map(postagemInsert ->{
						postagemInsert.setMessagem(postagemRequest.getMessagem());
						postagemInsert.setDescricao(postagemRequest.getDescricao());
						return postagemRepository.save(postagemInsert);

					}).orElseThrow(() -> new ResourceAccessException("Postagem nao achado:" + postagemId));

}
		@DeleteMapping("/postagem/{postagemId}")
		public ResponseEntity<?> deleteQuestion(@PathVariable long postagemId){
			return postagemRepository.findById(postagemId)
					.map( postagem -> {
						postagemRepository.delete(postagem);
						return ResponseEntity.ok().build();
					}).orElseThrow(() -> new ResourceAccessException("postagem nao encontrado" + postagemId));
		}

}

