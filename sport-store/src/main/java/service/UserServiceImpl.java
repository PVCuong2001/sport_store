package service;


import dao.BaseDAOImpl;
import dao.UserDAOImpl;
import mix.Myexception;
import model.Bill;
import model.Checkstockproperty;
import model.User;

import java.util.*;

public class UserServiceImpl implements UserService {
	public static User storeuser=null;
	private UserDAOImpl userDAOImpl;
	private List<User>userlist;
	public UserServiceImpl() {
		userDAOImpl=new UserDAOImpl(User.class);
	}
	public Object[][] searchuser(String name) throws Myexception{
		try {
			userlist = userDAOImpl.findbyname(name);
			Object[][] result= new Object[userlist.size()][8];
			for(int i=0;i<userlist.size();i++) {
				result[i][0]=i+1;
				result[i][1]=userlist.get(i).getCode().toString();
				result[i][2]=userlist.get(i).getName().toString();
				result[i][3]=userlist.get(i).getPhone().toString();
				result[i][4]=userlist.get(i).getGmail().toString();
				result[i][5]=userlist.get(i).getGender().toString();
				if(userlist.get(i).getActiveFlag()==1) result[i][6]="valid";
				else result[i][6]="invalid";
				if(userlist.get(i).getIsAdmin()==1) result[i][7]="Admin";
				else  result[i][7]="Staff";
			}
			return result;
		} catch (Myexception e) {
			throw e;
		}
		
	}
	public void checkuser(String code ,String password) throws Myexception {
		if(!code.isEmpty()&&!password.isEmpty()) {
			List<User>result=userDAOImpl.findbyproperty("code",code);
			if(result.size()!=0&&result.get(0).getPassword().equals(password)&&result.get(0).getActiveFlag()==1) {
			storeuser=result.get(0);
			}else {
				throw new Myexception("		Code or Password is wrong\n Please check your Code and Password");
			}
		}else {
			throw new Myexception("Please enter required information!");
		}
	}
	public Object[][] showuser() {
		userlist=userDAOImpl.findall();
		Object[][] result= new Object[userlist.size()][8];
		for(int i=0;i<userlist.size();i++) {
			result[i][0]=i+1;
			result[i][1]=userlist.get(i).getCode().toString();
			result[i][2]=userlist.get(i).getName().toString();
			result[i][3]=userlist.get(i).getPhone().toString();
			result[i][4]=userlist.get(i).getGmail().toString();
			result[i][5]=userlist.get(i).getGender().toString();
			if(userlist.get(i).getActiveFlag()==1) result[i][6]="valid";
			else result[i][6]="invalid";
			if(userlist.get(i).getIsAdmin()==1) result[i][7]="Admin";
			else  result[i][7]="Staff";
		}
		return result;
	} 

	public void adduser(User user) throws Myexception {
		if(user.getPhone().length()!=10) throw new Myexception("Phone number must be 10 digits");
		if(user.getName().isBlank() || user.getPassword().isBlank() || user.getGmail().isBlank() ||user.getGender().isBlank() || (user.getIsAdmin()!=0&&user.getIsAdmin()!=1))
			throw new Myexception("Please enter full information!");
		if(userDAOImpl.checkaddinfo(user.getCode(), user.getPassword(), user.getGmail(), user.getPhone())) {
			user.setActiveFlag(1);
			user.setCreateDate(new Date());
			user.setUpdateDate(new Date());
			try {
				userDAOImpl.save(user);
			}catch(Exception e) {
				System.out.println("Error while saving user....");
			}
		}else {
			throw new Myexception("Existed Code,Password,Gmail,Phone ");
		}	
	}
	public void edituser(User user,int index) throws Myexception {
		User test= userlist.get(index);
		List<User>list;
		if(!user.getPassword().equals(test.getPassword())) {
			list=userDAOImpl.findbyproperty("password", user.getPassword());
			if(list.size()!=0) throw new Myexception("Existed Password!");
		}
		if(!user.getPhone().equals(test.getPhone())) {
			list=userDAOImpl.findbyproperty("phone", user.getPhone());
			if(list.size()!=0) throw new Myexception("Existed Phone!");
		}
		if(!user.getGmail().equals(test.getGmail())) {
			list=userDAOImpl.findbyproperty("gmail", user.getGmail());
			if(list.size()!=0) throw new Myexception("Existed Gmail!");
		}
		user.setActiveFlag(1);
		user.setUpdateDate(new Date());
		try {
			userDAOImpl.update(user);
		}catch(Exception e){
			throw new Myexception("Error while updating ...\n");
		}
	}
	public void deleteuser(int index) {
		User user=userlist.get(index);
		user.setActiveFlag(0);
		user.setUpdateDate(new Date());
		try {
			userDAOImpl.update(user);
		}catch (Exception e) {
			System.out.println("Error while deleting user ....");
		}
	}
	public List<User>getuserlist(){
		return userlist;
	}
}
