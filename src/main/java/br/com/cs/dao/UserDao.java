package br.com.cs.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceProperty;

import org.springframework.stereotype.Repository;

import br.com.cs.model.User;

@Repository
public class UserDao {

	@PersistenceContext(type = PersistenceContextType.TRANSACTION, properties = @PersistenceProperty(name="org.hibernate.flushMode", value="COMMIT"))
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
