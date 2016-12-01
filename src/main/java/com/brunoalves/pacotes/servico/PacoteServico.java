
package com.brunoalves.pacotes.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunoalves.pacotes.dominio.Pacote;
import com.brunoalves.pacotes.repositorio.PacoteRepositorio;
import com.brunoalves.pacotes.servico.excecoes.NaoEncontradoException;
import com.brunoalves.pacotes.servico.excecoes.ServicoException;
import com.brunoalves.pacotes.servico.excecoes.ValidacaoException;

@Service
public class PacoteServico {

	@Autowired
	private PacoteRepositorio repo;

	public void validar(Pacote x) {
		List<String> erros = new ArrayList<>();

		if (x.getNome() == null) {
			erros.add("Favor preencher o campo nome");
		}

		if (x.getDiarias() == null) {
			erros.add("Favor preencher o campo diaria");
		}
		

		if (!erros.isEmpty()) {
			throw new ValidacaoException("Erro de validação", erros);
		}
	}

	public Pacote inserir(Pacote x) throws ServicoException {
		Pacote aux = repo.buscarNomeExato(x.getNome());
		if (aux != null) {
			throw new ServicoException("Já existe um Pacote com esse nome!", 1);
		}
		validar(x);
		return repo.save(x);
	}

	public Pacote atualizar(Pacote x) throws ServicoException {
		Pacote aux = repo.findOne(x.getCodPacote());
		if (aux == null) {
			throw new NaoEncontradoException("Pacote não encontrado!", 1);
		}
		aux = repo.buscarNomeExato(x.getNome());
		if (aux != null && aux.getCodPacote() != x.getCodPacote()) {
			throw new ServicoException("Já existe um outro Pacote com esse nome!", 1);
		}
		validar(x);
		return repo.save(x);
	}

	public void excluir(int cod) throws ServicoException {
		Pacote pct = repo.findOne(cod);
		if (pct == null) {
			throw new NaoEncontradoException("Pacote não encontrado!", 1);
		} 
			//if (!hot.getPacotes().isEmpty()) { throw new
			  //ServicoException("Exclusão não permitida: este hotel possui pacotes!"
			// , 2); }
			 
		repo.delete(pct);
	}

	public Pacote buscar(int cod) {
		Pacote pct = repo.findOne(cod);
		if (pct == null) {
			throw new NaoEncontradoException("Pacote não encontrado!", 1);
		}
		return pct;
	}

	public List<Pacote> buscarTodosOrdenadosPorNome() {
		return repo.buscarTodosOrdenadosPorNome();
	}

	public List<Pacote> buscarPorNome(String trecho) {
		return repo.buscarPorNome(trecho);
	}
}
