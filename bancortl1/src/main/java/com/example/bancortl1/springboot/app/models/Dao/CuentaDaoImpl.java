package com.example.bancortl1.springboot.app.models.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.bancortl1.springboot.app.models.entity.Cuenta;

@Repository
public class CuentaDaoImpl implements ICuentaDao {
    
	@PersistenceContext
	private EntityManager em;
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Cuenta> findAll() {
		
		return em.createQuery("from Cuenta").getResultList();
	}
	@Override
	@Transactional
	public void save(Cuenta cuenta) {
		if (cuenta.getId() != null && cuenta.getId() > 0) {
			em.merge(cuenta);
		} else {
			em.persist(cuenta);
		}
		
	}
	@Override
	@Transactional(readOnly = true)
	public Cuenta findOne(Long id) {		
		 return em.find(Cuenta.class, id);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		em.remove(findOne(id));
		
	}

}
