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

import modelo.Usuario;
import repository.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/usuario")
	public Page<Usuario> getUsuario (Pageable pageable){
		return usuarioRepository.findAll(pageable);

	}

	@PostMapping("/usuario")
	public Usuario createUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);

	}

	@PutMapping("/usuario/{usuarioId}")
	public Usuario uptadeUsuario(@PathVariable long usuarioId,	
			@Valid @RequestBody Usuario usuarioRequest){
		return usuarioRepository.findById(usuarioId)
				.map(usuarioInsert ->{
					usuarioInsert.setNome(usuarioRequest.getNome());
					usuarioInsert.setEmail(usuarioRequest.getEmail());
					usuarioInsert.setTelefone(usuarioRequest.getTelefone());
					usuarioInsert.setSenha(usuarioRequest.getSenha());
					return usuarioRepository.save(usuarioInsert);

				}).orElseThrow(() -> new ResourceAccessException("Usuario nao achado:" + usuarioId));
	}


	@DeleteMapping("/usuario/{usuarioId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable long usuarioId){
		return usuarioRepository.findById(usuarioId)
				.map( usuario -> {
					usuarioRepository.delete(usuario);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceAccessException("usuario nao encontrado" + usuarioId));
	}

}

