package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import modelo.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {

}
