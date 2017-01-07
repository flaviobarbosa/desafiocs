package br.com.cs.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cs.model.User;

@Repository
@Transactional
public class UserDao {

	@PersistenceContext
	private EntityManager manager;
	
	public void save(User user) throws Exception {
		manager.persist(user);
	}
	
	public User findByEmail(String email) {
		try { 
			User user = (User) manager.createNamedQuery(User.FIND_BY_EMAIL)
					.setParameter("email", email)
							.getSingleResult();
			
			return user;
		} catch (NoResultException e) {
			return null;
		}
	}
}
