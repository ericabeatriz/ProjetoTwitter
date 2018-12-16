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
		

	
	
}
