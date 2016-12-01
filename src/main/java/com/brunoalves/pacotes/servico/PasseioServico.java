
package com.brunoalves.pacotes.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunoalves.pacotes.dominio.Passeio;
import com.brunoalves.pacotes.repositorio.PasseioRepositorio;
import com.brunoalves.pacotes.servico.excecoes.NaoEncontradoException;
import com.brunoalves.pacotes.servico.excecoes.ServicoException;
import com.brunoalves.pacotes.servico.excecoes.ValidacaoException;

@Service
public class PasseioServico {

	@Autowired
	private PasseioRepositorio repo;

	public void validar(Passeio x) {
		List<String> erros = new ArrayList<>();

		if (x.getNome() == null) {
			erros.add("Favor preencher o campo nome");
		}

		if (x.getPreco() == null) {
			erros.add("Favor preencher o campo Preço");
		}
		if (x.getCidade() == null) {
			erros.add("Favor preencher o campo Cidade");
		}

		if (!erros.isEmpty()) {
			throw new ValidacaoException("Erro de validação", erros);
		}
	}

	public Passeio inserir(Passeio x) throws ServicoException {
		Passeio aux = repo.buscarNomeExato(x.getNome());
		if (aux != null) {
			throw new ServicoException("Já existe um Passeio com esse nome!", 1);
		}
		validar(x);
		return repo.save(x);
	}

	public Passeio atualizar(Passeio x) throws ServicoException {
		Passeio aux = repo.findOne(x.getCodPasseio());
		if (aux == null) {
			throw new NaoEncontradoException("Passeio não encontrado!", 1);
		}
		aux = repo.buscarNomeExato(x.getNome());
		if (aux != null && aux.getCodPasseio() != x.getCodPasseio()) {
			throw new ServicoException("Já existe um outro Passeio com esse nome!", 1);
		}
		validar(x);
		return repo.save(x);
	}

	public void excluir(int cod) throws ServicoException {
		Passeio pss = repo.findOne(cod);
		if (pss == null) {
			throw new NaoEncontradoException("Passeio não encontrado!", 1);
		} 
			//if (!hot.getPacotes().isEmpty()) { throw new
			  //ServicoException("Exclusão não permitida: este hotel possui pacotes!"
			// , 2); }
			 
		repo.delete(pss);
	}

	public Passeio buscar(int cod) {
		Passeio pss = repo.findOne(cod);
		if (pss == null) {
			throw new NaoEncontradoException("Passeio não encontrado!", 1);
		}
		return pss;
	}

	public List<Passeio> buscarTodosOrdenadosPorNome() {
		return repo.buscarTodosOrdenadosPorNome();
	}

	public List<Passeio> buscarPorNome(String trecho) {
		return repo.buscarPorNome(trecho);
	}
}
