package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domaine.User;

/**
 * Session Bean implementation class UserServices
 */
@Stateless
@LocalBean
public class UserServices implements UserServicesRemote, UserServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	// TODO Auto-generated method stub

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		entityManager.persist(user);
	}

	@Override
	public User findUserById(int idUser) {
		// TODO Auto-generated method stub

		return entityManager.find(User.class, idUser);
	}

	@Override
	public void deleteUser(int idUser) {
		// TODO Auto-generated method stub
		entityManager.remove(findUserById(idUser));

	}

	@Override
	public void updateUser(User user) {

		entityManager.merge(user);
		// TODO Auto-generated method stub

	}

}
