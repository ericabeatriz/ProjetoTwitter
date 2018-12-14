package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
