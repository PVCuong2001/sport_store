package dao;


import model.User;

public interface UserDAO extends BaseDAO<User>{
	boolean checkaddinfo(String code ,String password,String gmail,String phone);
}
