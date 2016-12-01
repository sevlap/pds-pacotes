package com.brunoalves.pacotes.recurso;


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

import com.brunoalves.pacotes.dominio.Hotel;
import com.brunoalves.pacotes.servico.HotelServico;


@RestController
@RequestMapping("/hoteis")
public class HotelRecurso {


	@Autowired
	private HotelServico as;


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Hotel>> todos() {
		List<Hotel> lista = as.buscarTodosOrdenadosPorNome();
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Integer id) {
		Hotel hot = as.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(hot);
	}


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> criar(@RequestBody Hotel hotel) {
		hotel = as.inserir(hotel);
		URI uri = getUri("/{id}", hotel.getCodHotel());
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Integer id) {
		as.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Hotel hotel, @PathVariable("id") Integer id) {
		hotel.setCodHotel(id);
		hotel = as.atualizar(hotel);
		return ResponseEntity.noContent().build();
	}
	
	private URI getUri(String nome, Integer valor) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path(nome).buildAndExpand(valor).toUri();
	}
}