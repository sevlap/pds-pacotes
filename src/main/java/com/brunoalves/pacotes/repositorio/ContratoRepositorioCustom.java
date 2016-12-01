package com.brunoalves.pacotes.repositorio;

import java.util.List;

import com.brunoalves.pacotes.dominio.Contrato;

public interface ContratoRepositorioCustom {

	public Contrato buscarNomeExato(String nome);
	public List<Contrato> buscarTodosOrdenadosPorNome();
	public List<Contrato> buscarPorNome(String trecho);
}
