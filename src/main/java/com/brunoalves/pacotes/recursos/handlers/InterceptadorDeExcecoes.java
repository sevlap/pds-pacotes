package com.brunoalves.pacotes.recursos.handlers;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.brunoalves.pacotes.servico.excecoes.NaoEncontradoException;
import com.brunoalves.pacotes.servico.excecoes.ServicoException;
import com.brunoalves.pacotes.servico.excecoes.ValidacaoException;


@ControllerAdvice
public class InterceptadorDeExcecoes {


	@ExceptionHandler(NaoEncontradoException.class)
	public ResponseEntity<ErroRecurso> handlerNaoEncontrado(NaoEncontradoException e, HttpServletRequest request) {
		
		HttpStatus hs = HttpStatus.NOT_FOUND;
		ErroRecurso erro = new ErroRecurso(hs.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(hs).body(erro);
	}
	
	@ExceptionHandler(ValidacaoException.class)
	public ResponseEntity<ErroRecurso> handlerValidacao(ValidacaoException e, HttpServletRequest request) {
		
		HttpStatus hs = HttpStatus.BAD_REQUEST;
		ErroRecurso erro = new ErroRecurso(hs.value(), e.getMessage(), System.currentTimeMillis());
		erro.setMensagens(e.getErros());
		return ResponseEntity.status(hs).body(erro);
	}
	
	@ExceptionHandler(ServicoException.class)
	public ResponseEntity<ErroRecurso> handlerServico(ServicoException e, HttpServletRequest request) {
		
		HttpStatus hs = HttpStatus.BAD_REQUEST;
		ErroRecurso erro = new ErroRecurso(hs.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(hs).body(erro);
	}
}
