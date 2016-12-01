package com.brunoalves.pacotes.repositorio;

import java.util.List;

import com.brunoalves.pacotes.dominio.Item;

public interface ItemRepositorioCustom {

	public Item buscarNomeExato(String nome);
	public List<Item> buscarTodosOrdenadosPorNome();
	public List<Item> buscarPorNome(String trecho);
}
