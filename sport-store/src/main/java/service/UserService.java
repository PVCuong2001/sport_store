package service;

import config.Injector;
import dao.UserDAO;
import model.User;
import java.util.*;

import java.util.logging.Logger;

import javax.management.InstanceNotFoundException;


public class UserService  {
	static final Logger log=Logger.getLogger(UserService.class.getName());
	private UserDAO<User>userDAO;
	public List<User>findbyproperty(String property,Object value){
		log.info("find by property from user start .....");
		try{
			userDAO=(UserDAO) Injector.getInstance("UserDAOImpl");
		}catch(InstanceNotFoundException e) {
			e.printStackTrace();
		}
		return userDAO.findbyproperty(property, value,"User");
	}
//	public void createtempuser(String property,Object value) {
//		userDAO.createtempuser(property, value);
//	}
//	public void deletetempuser() {
//		userDAO.deletetempuser();
//	}
	public List<User>userpro(String property,Object value){
		try {
			userDAO=(UserDAO) Injector.getInstance("UserDAOImpl");
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDAO.userpro(property, value);
	}
}
