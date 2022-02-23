package com.example.bancortl1.springboot.app.models.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.example.bancortl1.springboot.app.models.entity.Banco;

public class BancoDaoImpl implements IBancoDao {
	@PersistenceContext
	private EntityManager em;
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Banco> findAll() {
		
		return em.createQuery("from Banco").getResultList();
	}

	@Override
	public void save(Banco banco) {
		if (banco.getId() != null && banco.getId() > 0) {
			em.merge(banco);
		} else {
			em.persist(banco);
		}
		
		
	}

	@Override
	public Banco findOne(Long id) {
		
		return em.find(Banco.class, id);
	}

	@Override
	public void delete(Long id) {
		

	}

}
