package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.arqsw.entity.Fila;

public class FilaDAO {

	public ArrayList<Fila> listarFilas() throws IOException {
		String query = "select id_fila, nm_fila from fila";
		ArrayList<Fila> lista = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();){
			
			while(rs.next()) {
				Fila fila = new Fila();
				fila.setId(rs.getInt("id_fila"));
				fila.setNome(rs.getString("nm_fila"));
				lista.add(fila);
			}
			
		} catch (SQLException e) {
			throw new IOException(e);
		}
		return lista;
	}
	
	public Fila carregar(int id) throws IOException {
		Fila fila = new Fila();
		String query = "select id_fila, nm_fila from fila WHERE id_fila = ?";
		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(query);){
			stm.setInt(1, id);
			try(ResultSet rs = stm.executeQuery();){
				if(rs.next()) {
					fila.setId(rs.getInt("id_fila"));
					fila.setNome(rs.getString("nm_fila"));
				}else {
					fila.setId(-1);
					fila.setNome("Não teve resultados na busca");
				}
			} catch (SQLException e) {
				/**throw new IOException(e);
				 * 
				 */
				e.printStackTrace();
			}
		}catch (SQLException e) {
			/**throw new IOException(e);
			/
			 * 
			 */
			e.printStackTrace();
		}
		return fila;
	}
}
