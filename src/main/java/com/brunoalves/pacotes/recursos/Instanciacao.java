package com.brunoalves.pacotes.recursos;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brunoalves.pacotes.dominio.Cliente;
import com.brunoalves.pacotes.dominio.Contrato;
import com.brunoalves.pacotes.dominio.Hotel;
import com.brunoalves.pacotes.dominio.Item;
import com.brunoalves.pacotes.dominio.Pacote;
import com.brunoalves.pacotes.dominio.Passeio;
import com.brunoalves.pacotes.repositorio.ClienteRepositorio;
import com.brunoalves.pacotes.repositorio.ContratoRepositorio;
import com.brunoalves.pacotes.repositorio.HotelRepositorio;
import com.brunoalves.pacotes.repositorio.ItemRepositorio;
import com.brunoalves.pacotes.repositorio.PacoteRepositorio;
import com.brunoalves.pacotes.repositorio.PasseioRepositorio;

@RestController
@RequestMapping("/instanciacao")
public class Instanciacao {

	@Autowired
	private ClienteRepositorio clienteRepo;

	@Autowired
	private ContratoRepositorio contratoRepo;

	@Autowired
	private HotelRepositorio hotelRepo;

	@Autowired
	private ItemRepositorio itemRepo;

	@Autowired
	private PacoteRepositorio pacoteRepo;

	@Autowired
	private PasseioRepositorio passeioRepo;

	@RequestMapping(method=RequestMethod.GET)
	public String todos() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            Cliente cl1 = new Cliente(null, "Helena", "helena@hotmail.com", "(34) 99145-7898", "111.222.333-4", sdf.parse("24/03/1986"), new BigDecimal("4400.00"));
			Cliente cl2 = new Cliente(null, "Marcos", "marcos@hotmail.com", "(34) 99288-5568", "555.444.666-00", sdf.parse("12/07/1974"), new BigDecimal("3000.00"));
			Cliente cl3 = new Cliente(null, "Rita", "rita@hotmail.com", "(34) 99685-2259", "777.888.999-11", sdf.parse("03/01/1993"), new BigDecimal("1500.00"));

			Hotel h1 = new Hotel(null, "Hotel Tulipas", "Arraial d’ Ajuda", new BigDecimal("150.00"));
			Hotel h2 = new Hotel(null, "Hotel do Porto", "Porto Seguro", new BigDecimal("140.00"));
			Hotel h3 = new Hotel(null, "Hibs Hotel", "Rio de Janeir", new BigDecimal("120.00"));
			
			Passeio ps1 = new Passeio(null, "Recife de Fora", "Rio de Janeiro", new BigDecimal("120.00"));
			Passeio ps2 = new Passeio(null, "Ilha dos Aquários", "Bahia", new BigDecimal("60.00"));
			Passeio ps3 = new Passeio(null, "Pão de Açúcar","Rio de Janeiro", new BigDecimal("45.00"));
			Passeio ps4 = new Passeio(null, "Corcovado", "Rio de Janeiro", new BigDecimal("60.00"));
			Passeio ps5 = new Passeio(null, "Cidade Histórica", "Bahia", new BigDecimal("10.00"));
			Passeio ps6 = new Passeio(null, "Eco Parque Arraial d' Ajuda", "Bahia", new BigDecimal("100.00"));
			Passeio ps7 = new Passeio(null, "Cristo Redentor", "Rio de Janeiro", new BigDecimal("60.00"));
			Passeio ps8 = new Passeio(null, "Floresta da Tijuca", "Rio de Janeiro", new BigDecimal("50.00"));
			
			Pacote p1 = new Pacote(null, "Ferias de julho Arraial d’ ajuda", 6, h1);
			Pacote p2 = new Pacote(null, "Ferias Final de ano Porto Seguro", 12, h2);
			Pacote p3 = new Pacote(null, "Ferias julho Rio de Janeiro", 5, h3);
			Pacote p4 = new Pacote(null, "Férias de Final de ano Rio de Janeiro", 14, h3);
			
			Item i1 = new Item(null, 1, p1,ps1);
			Item i2 = new Item(null, 2, p1,ps6);
			Item i3 = new Item(null, 3, p1,ps2);
			Item i4 = new Item(null, 1, p2,ps5);
			Item i5 = new Item(null, 2, p2,ps1);
			Item i6 = new Item(null, 3, p2,ps2);
			Item i7 = new Item(null, 1, p3,ps3);
			Item i8 = new Item(null, 2, p3,ps7);
			Item i9 = new Item(null, 3, p3,ps4);
			Item i10 = new Item(null, 1, p4,ps3);
			Item i11 = new Item(null, 2, p4,ps8);
			Item i12 = new Item(null, 3, p4,ps4);
			
			Contrato cr1 = new Contrato(null, sdf.parse("10/02/2016"), cl1, p2);
			Contrato cr2 = new Contrato(null, sdf.parse("25/07/2016"), cl1, p3);
			Contrato cr3 = new Contrato(null, sdf.parse("17/02/2016"), cl2, p1);
			Contrato cr4 = new Contrato(null, sdf.parse("21/07/2016"), cl2, p4);
			Contrato cr5 = new Contrato(null, sdf.parse("12/06/2016"), cl3, p1);
			
			clienteRepo.save(cl1);
			clienteRepo.save(cl2);
			clienteRepo.save(cl3);
			
			hotelRepo.save(h1);
			hotelRepo.save(h2);
			hotelRepo.save(h3);
			
			passeioRepo.save(ps1);
			passeioRepo.save(ps2);
			passeioRepo.save(ps3);
			passeioRepo.save(ps4);
			passeioRepo.save(ps5);
			passeioRepo.save(ps6);
			passeioRepo.save(ps7);
			passeioRepo.save(ps8);
			
			pacoteRepo.save(p1);
			pacoteRepo.save(p2);
			pacoteRepo.save(p3);
			pacoteRepo.save(p4);
			
			itemRepo.save(i1);
			itemRepo.save(i2);
			itemRepo.save(i3);
			itemRepo.save(i4);
			itemRepo.save(i5);
			itemRepo.save(i6);
			itemRepo.save(i7);
			itemRepo.save(i8);
			itemRepo.save(i9);
			itemRepo.save(i10);
			itemRepo.save(i11);
			itemRepo.save(i12);
			
			contratoRepo.save(cr1);
			contratoRepo.save(cr2);
			contratoRepo.save(cr3);
			contratoRepo.save(cr4);
			contratoRepo.save(cr5);
			

        }catch (ParseException e) {
            return e.getMessage();
            }
        return"Pronto!";
	}
	
}
