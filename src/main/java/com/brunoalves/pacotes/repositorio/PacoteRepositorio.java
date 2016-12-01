package com.brunoalves.pacotes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brunoalves.pacotes.dominio.Pacote;

@Repository
public interface PacoteRepositorio extends JpaRepository<Pacote, Integer>, PacoteRepositorioCustom{

}
