package br.usjt.arqsw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;
import br.usjt.arqsw.service.ChamadoService;
import br.usjt.arqsw.service.FilaService;
/**
 * 
 * @author Kennedy Mota
 *
 */
@Controller
public class ManterChamadosController {
	private FilaService filaService;
	private ChamadoService chamadoService;
	
	
	@Autowired
	public ManterChamadosController(FilaService filaService, ChamadoService chamadoService) {
		this.chamadoService = chamadoService;
		this.filaService = filaService;
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping("index")
	public String inicio() {
		return "index";
	}

	private List<Fila> listarFilas() throws IOException{
			return filaService.listarFilas();
	}
	
	/**
	 * 
	 * @param model Acesso à request http
	 * @return JSP de Listar Chamados
	 */
	@RequestMapping("/listar_filas_exibir")
	public String listarFilasExibir(Model model) {
		try {
			model.addAttribute("filas", listarFilas());
			return "ChamadoListar";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("/listar_chamados_exibir")
	public String listarChamadosExibir(Fila fila, BindingResult result, Model model) {
		try {
			if (result.hasFieldErrors("id")) {
				model.addAttribute("filas", listarFilas());
				System.out.println("Deu erro " + result.toString());
				return "ChamadoListar";
				//return "redirect:listar_filas_exibir";
			}
			fila = filaService.carregar(fila.getId());
			model.addAttribute("fila", fila);
			ArrayList<Chamado> chamados = new ArrayList<>();
			chamados = chamadoService.listarChamados(fila);
			
			model.addAttribute("chamados", chamados);
			
			return "ChamadoListarExibir"; //JSP

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	@RequestMapping("/criar_novo_chamado")
	public String criarNovoChamado(Model model) {
		
		try {
			model.addAttribute("filas", listarFilas());
			return "NovoChamado";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
		
	}
	@RequestMapping("/salvar_novo_chamado")
	public String salvarNovoChamado(Fila fila, Chamado chamado, BindingResult result, Model model) throws IOException {
		
		chamado = chamadoService.salvarNovoChamado(fila, chamado);
		
		model.addAttribute("chamado", chamado);
		
		return "ChamadoSalvo";
	}

}
