package com.brunoalves.pacotes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brunoalves.pacotes.dominio.Item;

@Repository
public interface ItemRepositorio extends JpaRepository<Item, Integer>, ItemRepositorioCustom{

}
