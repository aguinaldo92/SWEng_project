package it.unisalento.SWEng_project.dao;

import it.unisalento.SWEng_project.domain.User;

public interface UserDao extends BaseDao<User>{
	public int set(User user);
	public User getUserByCredentials(String email, String password);
}
