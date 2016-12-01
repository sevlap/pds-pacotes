package com.brunoalves.pacotes.recursos;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brunoalves.pacotes.dominio.Pacote;
import com.brunoalves.pacotes.servico.PacoteServico;


@RestController
@RequestMapping("/pacotes")
public class PacoteRecurso {


	@Autowired
	private PacoteServico as;


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Pacote>> todos() {
		List<Pacote> lista = as.buscarTodosOrdenadosPorNome();
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Integer id) {
		Pacote pct = as.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(pct);
	}


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> criar(@RequestBody Pacote pacote) {
		pacote = as.inserir(pacote);
		URI uri = getUri("/{id}", pacote.getCodPacote());
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Integer id) {
		as.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Pacote pacote, @PathVariable("id") Integer id) {
		pacote.setCodPacote(id);
		pacote = as.atualizar(pacote);
		return ResponseEntity.noContent().build();
	}
	
	private URI getUri(String nome, Integer valor) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path(nome).buildAndExpand(valor).toUri();
	}
}