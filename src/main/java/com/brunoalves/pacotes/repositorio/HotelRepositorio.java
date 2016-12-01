package com.brunoalves.pacotes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brunoalves.pacotes.dominio.Hotel;

@Repository
public interface HotelRepositorio extends JpaRepository<Hotel, Integer>, HotelRepositorioCustom {

}
