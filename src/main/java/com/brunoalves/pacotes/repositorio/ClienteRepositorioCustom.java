package com.brunoalves.pacotes.repositorio;

import java.util.List;

import com.brunoalves.pacotes.dominio.Cliente;

public interface ClienteRepositorioCustom {

	public Cliente buscarNomeExato(String nome);
	public List<Cliente> buscarTodosOrdenadosPorNome();
	public List<Cliente> buscarPorNome(String trecho);
	public Cliente buscarPorCpf(String cpf);
}
