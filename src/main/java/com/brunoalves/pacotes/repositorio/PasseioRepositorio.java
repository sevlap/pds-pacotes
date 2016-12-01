package com.brunoalves.pacotes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brunoalves.pacotes.dominio.Passeio;

@Repository
public interface PasseioRepositorio extends JpaRepository<Passeio, Integer>, PasseioRepositorioCustom{

}
