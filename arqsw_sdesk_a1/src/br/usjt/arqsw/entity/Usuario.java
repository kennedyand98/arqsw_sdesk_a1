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
	
	@NotNull (message="Usu�rio n�o pode ser v�zio!")
	@Size(min=5, max=50, message="Usu�rio min�mo 5 - m�ximo 50 !")
	private String username;
	
	@NotNull (message="Senha n�o pode ser v�zia!")
	@Size(min=5, max=50, message="Senha min�mo 5 - m�ximo 50 !")
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
