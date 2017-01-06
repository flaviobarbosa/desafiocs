package br.com.cs.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cs.model.User;

@Repository
@Transactional
public class UserDao {

	@PersistenceContext
	private EntityManager manager;
	
	public void save(User user) {
		manager.persist(user);
	}
}
