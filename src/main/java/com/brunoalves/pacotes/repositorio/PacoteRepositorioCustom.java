package com.brunoalves.pacotes.repositorio;

import java.util.List;

import com.brunoalves.pacotes.dominio.Pacote;

public interface PacoteRepositorioCustom {

	public Pacote buscarNomeExato(String nome);
	public List<Pacote> buscarTodosOrdenadosPorNome();
	public List<Pacote> buscarPorNome(String trecho);
}
