package com.example.bancortl1.springboot.app.models.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.exception.DataException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.bancortl1.springboot.app.errors.DataBaseBancoException;
import com.example.bancortl1.springboot.app.models.entity.Tarjeta;

@Repository
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
	@Transactional
	public void save(Tarjeta tarjeta) throws DataBaseBancoException{
		if (tarjeta.getId() != null && tarjeta.getId() > 0) {
			try {
				em.merge(tarjeta);
			} catch (DataException e) {
				throw new DataBaseBancoException();
			}
		} else
		try {
			em.persist(tarjeta);
		} catch (DataBaseBancoException e) {
			throw new DataBaseBancoException();
		}
		
	}
	@Override
	@Transactional
	public Tarjeta findOne(Long id) {		
		return em.find(Tarjeta.class, id);
		
		}
	@Override
	@Transactional(readOnly = true)
	public Tarjeta findOne( String numerotarjeta) {		
		return em.find(Tarjeta.class, numerotarjeta);
		
		}
		
	@Override
	@Transactional
	public void delete(Long id) {
		em.remove(findOne(id));		
	}
}