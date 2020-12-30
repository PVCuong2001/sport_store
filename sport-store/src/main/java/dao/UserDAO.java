package dao;


import java.util.List;

import mix.Myexception;
import model.User;

public interface UserDAO extends BaseDAO<User>{
	boolean checkaddinfo(String code ,String password,String gmail,String phone);
	List<User>findbyname(String name)throws Myexception ;
}
