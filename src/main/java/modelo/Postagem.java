package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Postagem {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Column
	private String messagem;
	@Column
	private String descricao;
	
	public Postagem() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMessagem() {
		return messagem;
	}
	public void setMessagem(String messagem) {
		this.messagem = messagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

	
	
}
