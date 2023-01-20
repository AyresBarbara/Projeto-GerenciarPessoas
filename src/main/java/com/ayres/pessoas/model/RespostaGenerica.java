package com.ayres.pessoas.model;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class RespostaGenerica{

	private String codigoRetorno;
	
	private String retornoCadastrado;

	
	public RespostaGenerica(String codigoRetorno, String retornoCadastrado) {
		super();
		this.codigoRetorno = codigoRetorno;
		this.retornoCadastrado = retornoCadastrado;
	}

	public RespostaGenerica() {
		super();
	}


	public String getCodigoRetorno() {
		return codigoRetorno;
	}

	public void setCodigoRetorno(String codigoRetorno) {
		this.codigoRetorno = codigoRetorno;
	}

	public String getRetornoCadastrado() {
		return retornoCadastrado;
	}

	public void setRetornoCadastrado(String retornoCadastrado) {
		this.retornoCadastrado = retornoCadastrado;
	} 
	
	
}
