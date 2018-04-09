package br.usjt.arqsw.controller;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;
import br.usjt.arqsw.service.ChamadoService;
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
	private ChamadoDAO chamadoDAO;
	private ChamadoService chamadoService;
	
	@Autowired
	public ManterFilaController (FilaService filaService, ChamadoDAO chamadoDAO, ChamadoService chamadoService) {
		this.filaService = filaService;
		this.chamadoDAO = chamadoDAO;
		this.chamadoService = chamadoService;	
	}
	
	
	private List<Fila> listarFilas() throws IOException{
		return filaService.listarFilas();
	}
	
	private List<Chamado> listarChamadosAbertos(Fila fila) throws IOException {
		return chamadoDAO.listarChamados(fila);
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
	
	@Transactional
	@RequestMapping("/editar_fila")
	public String editarFila(Fila fila, BindingResult result, Model model) throws IOException{
		filaService.alterar(fila);
		return "FilaAlterada";
	}
	
	@RequestMapping("/form_editar_fila")
	public String formEditarFila(Fila fila, Model model) throws IOException {
		try {
			fila = filaService.carregar(fila.getId());
			model.addAttribute("fila", fila);
			return "EditarFila";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	
	@Transactional
	@RequestMapping("/excluir_fila")
	public String excluirFila(Fila fila, Model model) {
		try {
			fila = filaService.carregar(fila.getId());
			List<Chamado> chamadosAbertosFila = chamadoService.listarChamados(fila);
			model.addAttribute("filas", listarFilas());
			if (!chamadosAbertosFila.isEmpty()) {
				model.addAttribute("chamadosAbertosFila", chamadosAbertosFila);
				model.addAttribute("fila", fila);
				return "NovaFila";
			}
			filaService.deletar(fila);
			return "FilaExcluida";
			
		}catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
}
