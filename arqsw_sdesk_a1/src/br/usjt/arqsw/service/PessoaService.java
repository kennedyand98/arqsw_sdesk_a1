package br.usjt.arqsw.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.usjt.arqsw.entity.Pessoa;
import br.usjt.arqsw.entity.ResultadoWebService;

@Service
public class PessoaService {
	
	public List<Pessoa> puxarDadosPessoas(){
		List<Pessoa> pessoas = new ArrayList<>();
		ResultadoWebService resultado = buscaWebService();
		return pessoas;
	}
	
	private ResultadoWebService buscaWebService() {
		RestTemplate restTemplate = new RestTemplate();
		ResultadoWebService resultado = restTemplate.getForObject(
				montarURL(), ResultadoWebService.class);
		return resultado;
	}
	
	private String montarURL() {
		String url = "https://reqres.in/api/users?per_page=15&page=1";
		return url;
	}
	

}
