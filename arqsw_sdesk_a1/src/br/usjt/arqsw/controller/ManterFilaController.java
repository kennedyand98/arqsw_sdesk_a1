package br.usjt.arqsw.controller;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw.entity.Fila;
import br.usjt.arqsw.service.FilaService;

/**
 * 
 * @author Kennedy
 *
 */

@Controller
@Transactional
public class ManterFilaController {
	
	private FilaService filaService;
	private Fila fila;
	
	@Autowired
	public ManterFilaController (FilaService filaService) {
		this.filaService = filaService;
		this.fila = fila;
	}
	
	
	private List<Fila> listarFilas() throws IOException{
		return filaService.listarFilas();
	}
	
	@RequestMapping("/criar_nova_fila")
	public String criarNovaFila(Model model) {
		try {
			model.addAttribute("filas", listarFilas());
			return "NovaFila";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	@RequestMapping("/salvar_nova_fila")
	public String salvarNovaFila(Fila fila, BindingResult result, Model model) throws IOException {
		
		fila = filaService.salvarNovaFila(fila);
		
		model.addAttribute("fila", fila);
		
		return "FilaSalva";
	}
	
	
}
