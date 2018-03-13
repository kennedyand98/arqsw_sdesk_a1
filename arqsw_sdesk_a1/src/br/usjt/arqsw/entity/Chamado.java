package br.usjt.arqsw.entity;

import java.io.Serializable;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Chamado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull (message="O chamado precisa ter um ID")
	@Min(value=1, message="O chamado não pode ser vazio")
	private int id;
	
	@NotNull
	@Size(min=10, max=100, message="A descrição tem que ter entre 10 e 100 caracteres")
	private String descricao;
	
	@NotNull
	private String status;
	
	@NotNull
	private Date dataAbertura;
	
	private Date dataFechamento;
	
	
	@NotNull(message="Não pode ser vazio")
	private Fila fila;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getDataAbertura() {
		return dataAbertura;
	}


	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}


	public Date getDataFechamento() {
		return dataFechamento;
	}


	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}


	public Fila getFila() {
		return fila;
	}


	public void setFila(Fila fila) {
		this.fila = fila;
	}
	
	
	
	
	

}
