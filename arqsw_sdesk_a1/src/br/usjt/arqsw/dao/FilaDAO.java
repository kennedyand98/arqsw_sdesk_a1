package br.usjt.arqsw.dao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;


@Repository
public class FilaDAO {
	
	@PersistenceContext
	EntityManager manager;
	
	public List<Fila> listarFilas() throws IOException{
		return manager.createQuery("select f from Fila f").getResultList();
	}
	
	public Fila carregar(int id) throws IOException {
		return manager.find(Fila.class, id);
	}
	
	public Fila salvarNovaFila(Fila fila) throws IOException{
		manager.persist(fila);
		return fila;
	}

	public void deletar(Fila fila) {
		manager.remove(fila);
	}

	public void alterar(Fila fila) {
		manager.merge(fila);
	}
}
