
package com.brunoalves.pacotes.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunoalves.pacotes.dominio.Hotel;
import com.brunoalves.pacotes.repositorio.HotelRepositorio;
import com.brunoalves.pacotes.servico.excecoes.NaoEncontradoException;
import com.brunoalves.pacotes.servico.excecoes.ServicoException;
import com.brunoalves.pacotes.servico.excecoes.ValidacaoException;

@Service
public class HotelServico {

	@Autowired
	private HotelRepositorio repo;

	public void validar(Hotel x) {
		List<String> erros = new ArrayList<>();

		if (x.getNome() == null) {
			erros.add("Favor preencher o campo nome");
		}
		if (x.getCidade() == null) {
			erros.add("Favor preencher o campo cidade");
		}
		if (x.getDiaria() == null) {
			erros.add("Favor preencher o campo diaria");
		}
		

		if (!erros.isEmpty()) {
			throw new ValidacaoException("Erro de validação", erros);
		}
	}

	public Hotel inserir(Hotel x) throws ServicoException {
		Hotel aux = repo.buscarNomeExato(x.getNome());
		if (aux != null) {
			throw new ServicoException("Já existe um Hotel com esse nome!", 1);
		}
		validar(x);
		return repo.save(x);
	}

	public Hotel atualizar(Hotel x) throws ServicoException {
		Hotel aux = repo.findOne(x.getCodHotel());
		if (aux == null) {
			throw new NaoEncontradoException("Hotel não encontrado!", 1);
		}
		aux = repo.buscarNomeExato(x.getNome());
		if (aux != null && aux.getCodHotel() != x.getCodHotel()) {
			throw new ServicoException("Já existe um outro Hotel com esse nome!", 1);
		}
		validar(x);
		return repo.save(x);
	}

	public void excluir(int cod) throws ServicoException {
		Hotel hot = repo.findOne(cod);
		if (hot == null) {
			throw new NaoEncontradoException("Hotel não encontrado!", 1);
		} 
			 /* if (!hot.getPacotes().isEmpty()) { throw new
			  ServicoException("Exclusão não permitida: este hotel possui pacotes!"
			 , 2); }
			 */
		repo.delete(hot);
	}

	public Hotel buscar(int cod) {
		Hotel hot = repo.findOne(cod);
		if (hot == null) {
			throw new NaoEncontradoException("Hotel não encontrado!", 1);
		}
		return hot;
	}

	public List<Hotel> buscarTodosOrdenadosPorNome() {
		return repo.buscarTodosOrdenadosPorNome();
	}

	public List<Hotel> buscarPorNome(String trecho) {
		return repo.buscarPorNome(trecho);
	}
}
