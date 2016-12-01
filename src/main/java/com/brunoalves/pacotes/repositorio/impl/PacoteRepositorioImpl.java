package com.brunoalves.pacotes.repositorio.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brunoalves.pacotes.dominio.Pacote;
import com.brunoalves.pacotes.repositorio.PacoteRepositorioCustom;

@Repository
@Transactional(readOnly=true)
public class PacoteRepositorioImpl implements PacoteRepositorioCustom {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@SuppressWarnings("unchecked")
	public Pacote buscarNomeExato(String nome) {
		String jpql = "SELECT x FROM Pacote x WHERE x.nome = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", nome);
		List<Pacote> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pacote> buscarTodosOrdenadosPorNome() {
		String jpql = "SELECT x FROM Pacote x ORDER BY x.nome";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pacote> buscarPorNome(String trecho) {
		String jpql = "SELECT x FROM Pacote x WHERE x.nome LIKE :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", "%"+trecho+"%");
		return query.getResultList();
	}

}
