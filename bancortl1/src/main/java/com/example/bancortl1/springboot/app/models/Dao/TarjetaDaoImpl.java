package com.example.bancortl1.springboot.app.models.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;
import com.example.bancortl1.springboot.app.models.entity.Tarjeta;

public class TarjetaDaoImpl implements ITarjetaDao {
	@PersistenceContext
	private EntityManager em;
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Tarjeta> findAll() {
		
		return em.createQuery("from Tarjeta").getResultList();
	}


	@Override
	public void save(Tarjeta tarjeta) {
		if (tarjeta.getId() != null && tarjeta.getId() > 0) {
			em.merge(tarjeta);
		} else {
			em.persist(tarjeta);
		}
		
		
	}
	@Override
	public Tarjeta findOne(Long id) {		
		return em.find(Tarjeta.class, id);
		
		}
	@Override
	public Tarjeta findOne( String numerotarjeta) {		
		return em.find(Tarjeta.class, numerotarjeta);
		
		}
		
	@Override
	public void delete(Long id) {
		em.remove(findOne(id));		
	}
}