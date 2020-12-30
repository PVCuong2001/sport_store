package service;

import mix.Myexception;
import model.User;

public interface UserService {
	 Object[][] searchuser(String name) throws Myexception;
	 void checkuser(String code ,String password) throws Myexception;
	 Object[][] showuser();
	 void adduser(User user) throws Myexception;
	 void edituser(User user,int index) throws Myexception;
	 void deleteuser(int index);
}
