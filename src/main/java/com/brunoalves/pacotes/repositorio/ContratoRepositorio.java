package com.brunoalves.pacotes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brunoalves.pacotes.dominio.Contrato;

@Repository
public interface ContratoRepositorio extends JpaRepository<Contrato, Integer>, ContratoRepositorioCustom {

}
