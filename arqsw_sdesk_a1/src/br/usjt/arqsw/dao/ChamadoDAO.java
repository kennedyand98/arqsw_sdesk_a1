package br.usjt.arqsw.dao;

import java.io.IOException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

public class ChamadoDAO {
	
	public ArrayList<Chamado> listarChamados(Fila fila) throws IOException{
		String query = "SELECT ID_CHAMADO, DESCRICAO, STATUS, DT_ABERTURA, DT_FECHAMENTO, ID_FILA FROM CHAMADO WHERE ID_FILA = ?";
		ArrayList<Chamado> chamados = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement stm = conn.prepareStatement(query);){
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
		String query = "INSERT INTO CHAMADO (DESCRICAO, STATUS, DT_ABERTURA, ID_FILA) VALUES"
				+ "?, ?, ?, ? ";
		Date data = new java.sql.Date(new java.util.Date().getTime());
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement stm = conn.prepareStatement(query);){
			stm.setString(1, chamado.getDescricao().toUpperCase());
			stm.setString(2, "ABERTO");
			stm.setDate(3, data);
			stm.setInt(4, fila.getId());
			try(ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					chamado.setId(rs.getInt("ID_CHAMADO"));
				}
			}catch (SQLException e) {
				throw new IOException(e);
			}
		}catch (SQLException e) {
			throw new IOException(e);
		}
		return chamado;
	}

}
