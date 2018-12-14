package modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column (nullable=false)
	private String nome;
	
	@Column (nullable=false,  unique=true)
	private String email;
	
	@Column (nullable=false)
	private int telefone;
	
	@Column (nullable=false)
	private int senha;
	
	@Column
	private List<Postagem> listaPostagens;
	@Column
	private List<Seguidor> listaSeguidores;
	
	public Usuario() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}

	public List<Postagem> getListaPostagens() {
		return listaPostagens;
	}

	public void setListaPostagens(List<Postagem> listaPostagens) {
		this.listaPostagens = listaPostagens;
	}

	public List<Seguidor> getListaSeguidores() {
		return listaSeguidores;
	}

	public void setListaSeguidores(List<Seguidor> listaSeguidores) {
		this.listaSeguidores = listaSeguidores;
	}

	
	
}
