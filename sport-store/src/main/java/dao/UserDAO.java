package dao;

import java.util.List;

import model.User;

public interface UserDAO<E> extends BaseDAO<E> {
//	public void createtempuser(String property,Object value);
//	public void deletetempuser();
	public List<User> userpro(String property ,Object value) ;
}
