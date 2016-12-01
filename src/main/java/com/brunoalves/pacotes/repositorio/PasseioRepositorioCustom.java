package com.brunoalves.pacotes.repositorio;

import java.util.List;

import com.brunoalves.pacotes.dominio.Passeio;

public interface PasseioRepositorioCustom {

	public Passeio buscarNomeExato(String nome);
	public List<Passeio> buscarTodosOrdenadosPorNome();
	public List<Passeio> buscarPorNome(String trecho);
}
