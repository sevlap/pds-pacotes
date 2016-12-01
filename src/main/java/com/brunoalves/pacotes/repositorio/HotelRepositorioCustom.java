package com.brunoalves.pacotes.repositorio;

import java.util.List;

import com.brunoalves.pacotes.dominio.Hotel;

public interface HotelRepositorioCustom {

	public Hotel buscarNomeExato(String nome);
	public List<Hotel> buscarTodosOrdenadosPorNome();
	public List<Hotel> buscarPorNome(String trecho);
}
