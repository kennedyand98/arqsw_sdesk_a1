package br.usjt.arqsw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;
import br.usjt.arqsw.service.ChamadoService;
import br.usjt.arqsw.service.FilaService;

@RestController
public class ManterChamadosRest {
	
	@Autowired
	private ChamadoService  chamadoService;
	private FilaService		filaService;
		
	@RequestMapping(method = RequestMethod.POST, value = "/rest/incluirChamado")
	public ResponseEntity<Chamado> incluirChamado(@RequestBody Chamado chamado) {
		try {
			int chamadoCriado = chamadoService.salvarNovoChamado(chamado).getNumero();
			chamado = chamadoService.consultarChamado(chamadoCriado);
			return ResponseEntity.ok(chamado);
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(chamado);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/rest/fecharChamado/{idChamado}")
	public ResponseEntity<Chamado> fecharChamado(@PathVariable("idChamado") Long idChamado) {
		Chamado chamado = null, param;
		try {			
			param = new Chamado();
			param.setNumero(idChamado.intValue());
			int fechado = chamadoService.fecharChamado(param);
			param = chamadoService.consultarChamado(fechado);
			return ResponseEntity.ok(param);
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(chamado);
		}
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="rest/listarChamado/{idFila}")
	public @ResponseBody List<Chamado> listarChamados(@PathVariable("idFila") Long idFila) throws IOException{
		Fila fila = null, param;
		List<Chamado> lista = null;
		try {			
			param = new Fila();
			param.setId(idFila.intValue());
			lista = chamadoService.listarChamados(param);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return lista;		
	}
	
	@RequestMapping(value = "/rest/fila", method = RequestMethod.GET)
	public @ResponseBody List<Fila> listarFila() {
		List<Fila> fila = new ArrayList<>();
		try {
			fila = filaService.listarFilas();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fila;
	}

}