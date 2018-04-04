package br.usjt.arqsw.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "usuario")
public class Usuario{

	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@NotNull (message="Usuário não pode ser vázio!")
	@Size(min=5, max=50, message="Usuário minímo 5 - máximo 50 !")
	@Column(name="username")
	private String username;
	
	@NotNull (message="Senha não pode ser vázia!")
	@Size(min=5, max=50, message="Senha minímo 5 - máximo 50 !")
	@Column(name="password")
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
