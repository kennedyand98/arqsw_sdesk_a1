package br.usjt.arqsw.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private int id;
	
	@NotNull (message="Usuário não pode ser vázio!")
	@Size(min=5, max=50, message="Usuário minímo 5 - máximo 50 !")
	private String username;
	
	@NotNull (message="Senha não pode ser vázia!")
	@Size(min=5, max=50, message="Senha minímo 5 - máximo 50 !")
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
