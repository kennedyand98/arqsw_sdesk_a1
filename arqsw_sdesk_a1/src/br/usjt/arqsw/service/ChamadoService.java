package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;


@Service
public class ChamadoService {
	private ChamadoDAO dao;
	
	@Autowired
	public ChamadoService(ChamadoDAO dao) {
		this.dao = dao;
	}
	
	public List<Chamado> listarChamados(Fila fila) throws IOException {
		return dao.listarChamados(fila);
	}
	
	public Chamado salvarNovoChamado(Chamado chamado) throws IOException {
		return dao.salvarNovoChamado(chamado);
	}
	
	public Chamado consultarChamado(int id) throws IOException {
		return dao.consultarChamado(id);
	}
	
	public int fecharChamado(Chamado chamado) throws IOException {
		return dao.fecharChamado(chamado);
	}

}
