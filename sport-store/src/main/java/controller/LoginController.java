package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.management.InstanceNotFoundException;

import config.Injector;
import config.Serializable_user;
import model.User;
import service.UserService;

public class LoginController {
	 public static User storeuser=null;
//	private static final long serialVersionUID = 1L;
//	public static void main(String[] args) {
//		try {
//			UserService userService=(UserService) Injector.getInstance("UserService");
//			List<User> users=new ArrayList<User>();
//			users=userService.findbyproperty("code", "NV0001");
//			if(users!=null && !users.isEmpty()) {
//				userService.createtempuser("code", "NV0001");
//			}
//		} catch (InstanceNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	
//	public static void main(String[] args) {
//		Serializable_user serializable_user=new Serializable_user();
//		try {
//			List<User> users =serializable_user.deserialuser();
//			for(User value :users) {
//				System.out.println(value.toString());
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	public List<User> finduser(String property,Object value) {
		List<User> users=new ArrayList<User>();
		try {
			UserService userService=(UserService) Injector.getInstance("UserService");
			users=userService.findbyproperty(property,value);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
}
