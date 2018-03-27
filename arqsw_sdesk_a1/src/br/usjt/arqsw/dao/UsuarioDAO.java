package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Usuario;

@Repository
public class UsuarioDAO {
	@PersistenceContext
	EntityManager manager;
	
	
	private Connection conn;
	
	@Autowired
	public UsuarioDAO (DataSource dataSource) throws IOException{
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}
	
	/*
	 * ESTA DANDO ERRO DE NULLPOINTER AO TENTAR PEGAR O USUARIO COM GETUSERNAME()
	 * 
	 * public Boolean validarLogin (Usuario usuario) throws IOException{
		//conecta o usuario com a persistencia
		usuario = manager.find(Usuario.class, usuario.getId());
		
		String sqlQuery = "SELECT u FROM Usuario u WHERE u.username = :username AND u.password = :password";
		
		Query query = manager.createQuery(sqlQuery);
		query.setParameter("username", usuario.getUsername());
		query.setParameter("password", usuario.getPassword());
		List<Usuario> result = query.getResultList();
		
		if(result.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}*/
	
	public Boolean validarLogin (Usuario usuario) throws IOException{
		String query = "SELECT username, password FROM usuario WHERE username = ? AND password = ?";
		try(PreparedStatement pst = conn.prepareStatement(query);){
			pst.setString(1, usuario.getUsername());
			pst.setString(2, usuario.getPassword());
			try(ResultSet rs = pst.executeQuery();) {
				if(rs.next()) {
					return true;
				} else {
					return false;
				}
			} catch (SQLException e) {
				throw new IOException(e);
			}
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}
	

}
