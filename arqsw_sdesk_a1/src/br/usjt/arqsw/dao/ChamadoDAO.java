package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Statement;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;



@Repository
public class ChamadoDAO {
	private Connection conn;
	
	@Autowired
	public ChamadoDAO(DataSource dataSource) throws IOException{
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}
	
	public ArrayList<Chamado> listarChamados(Fila fila) throws IOException{
		String query = "SELECT ID_CHAMADO, DESCRICAO, STATUS, DT_ABERTURA, DT_FECHAMENTO, ID_FILA FROM CHAMADO WHERE ID_FILA = ?";
		ArrayList<Chamado> chamados = new ArrayList<>();
		try(PreparedStatement stm = conn.prepareStatement(query);){
			stm.setInt(1, fila.getId());
				try(ResultSet rs = stm.executeQuery();) {
					while(rs.next()) {
						Chamado chamado = new Chamado();
						chamado.setId(rs.getInt("ID_CHAMADO"));
						chamado.setDescricao(rs.getString("DESCRICAO"));
						chamado.setStatus(rs.getString("STATUS"));
						chamado.setDataAbertura(rs.getDate("DT_ABERTURA"));
						chamado.setDataFechamento(rs.getDate("DT_FECHAMENTO"));
						chamado.setFila(new Fila());
						chamado.getFila().setId(rs.getInt("ID_FILA"));
						chamados.add(chamado);
					}
				} catch (SQLException e) {
					throw new IOException(e);
				}
		} catch (SQLException e) {
			throw new IOException(e);
		}		
		return chamados;
	}
	
	public Chamado salvarNovoChamado(Fila fila, Chamado chamado) throws IOException {
		String query = "INSERT INTO chamado (DESCRICAO, STATUS, DT_ABERTURA, ID_FILA) VALUES"
				+ " (?, ?, ?, ?)";
		
		Date date = new Date();		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try (PreparedStatement stm = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);){
			stm.setString(1, chamado.getDescricao().toUpperCase());
			stm.setString(2, "ABERTO");
			stm.setString(3, format.format(date));
			stm.setInt(4, fila.getId());
			stm.execute();
			ResultSet rs = stm.getGeneratedKeys();
			if(rs.next()) {
				chamado.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			throw new IOException(e);
		}
		return chamado;
	}

}
