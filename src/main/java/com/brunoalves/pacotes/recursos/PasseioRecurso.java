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

import com.brunoalves.pacotes.dominio.Passeio;
import com.brunoalves.pacotes.servico.PasseioServico;


@RestController
@RequestMapping("/passeios")
public class PasseioRecurso {


	@Autowired
	private PasseioServico as;


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Passeio>> todos() {
		List<Passeio> lista = as.buscarTodosOrdenadosPorNome();
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Integer id) {
		Passeio pss = as.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(pss);
	}


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> criar(@RequestBody Passeio passeio) {
		passeio = as.inserir(passeio);
		URI uri = getUri("/{id}", passeio.getCodPasseio());
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Integer id) {
		as.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Passeio passeio, @PathVariable("id") Integer id) {
		passeio.setCodPasseio(id);
		passeio = as.atualizar(passeio);
		return ResponseEntity.noContent().build();
	}
	
	private URI getUri(String nome, Integer valor) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path(nome).buildAndExpand(valor).toUri();
	}
}