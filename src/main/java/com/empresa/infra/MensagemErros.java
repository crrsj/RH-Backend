package com.empresa.infra;

import org.springframework.http.HttpStatus;

public record MensagemErros(
		
		HttpStatus status,
		
		String mensagem) {
	
  public MensagemErros(HttpStatus status, String mensagem) {
	  this.status = status;
	  this.mensagem = mensagem;
  }
}
