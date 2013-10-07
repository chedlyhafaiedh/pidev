package services;

import javax.ejb.Remote;

import domaine.User;

@Remote
public interface UserServicesRemote {
	public void addUser(User user);

	public User findUserById(int idUser);

	public void deleteUser(int idUser);

	public void updateUser(User user);
}
