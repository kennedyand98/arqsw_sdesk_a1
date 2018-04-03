package br.usjt.arqsw.dao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;



@Repository
public class ChamadoDAO {
	@PersistenceContext
	EntityManager manager;
	
	
	public List<Chamado> listarChamados(Fila fila) throws IOException{
		//conectei minha fila com a persistencia
		fila = manager.find(Fila.class, fila.getId());
		
		String sqlQuery = "SELECT c FROM Chamado c WHERE c.fila = :fila";
		
		Query query = manager.createQuery(sqlQuery);
		query.setParameter("fila", fila);
		
		List<Chamado> result = query.getResultList();
		return result;		
		
	}
	
	public Chamado salvarNovoChamado(Chamado chamado) throws IOException{
		chamado.setStatus(Chamado.ABERTO);
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
		Date dataAberta;
		
		try {
			dataAberta = sdf.parse(sdf.format(c.getTime()));
			chamado.setDataAbertura(dataAberta);
			System.out.println(dataAberta);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		manager.persist(chamado);
		return chamado;
	}
	
	public Chamado consultarChamado(int id) {
		String querySelect = "select c from Chamado c where c.id_chamado = :id";
		Query query = manager.createQuery(querySelect);
		query.setParameter("id", id);
		Chamado result = (Chamado)query.getSingleResult();
		return result;
	}
	
	public int fecharChamado(Chamado chamado) {
		manager.persist(chamado);
		return chamado.getNumero();
	}

}
