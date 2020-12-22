package service;


import dao.BaseDAOImpl;
import dao.UserDAOImpl;
import model.Bill;
import model.Checkstockproperty;
import model.User;
import validate.Myexception;

import java.util.*;

public class UserServiceImpl implements UserService {
	public static User storeuser=null;
	private UserDAOImpl userDAOImpl;
	private int nextid;
	private List<User>userlist;
	public UserServiceImpl() {
		userDAOImpl=new UserDAOImpl(User.class);
		nextid=userDAOImpl.nextid("user");
	}
	public static void main(String[] args) throws CloneNotSupportedException {
			UserServiceImpl userService=new UserServiceImpl();
			
				
			
			
			Object [][] data=userService.showuser();
			for(Object[] i :data) {
				for(Object j :i) {
					System.out.print(j+"         ");
				}
				System.out.println();
			}
			User test=new User();
			User user=userService.userlist.get(0);
			test=(User) userService.userlist.get(0).clone();
			System.out.println(userService.userlist.get(0).getName());
			test.setPassword("leminhloi");
			List<User>list;
			if(!user.getPassword().equals(test.getPassword())) {
				list=userService.userDAOImpl.findbyproperty("password", user.getPassword());
				if(list.size()!=0) System.out.println("di me may");
			}
		
		/*
			User user=new User();
			user.setName("cuongpro");
			user.setCode("pro001");
			user.setGender("Nam");
			user.setGmail("procuong");
			user.setPassword("procuong001");
			user.setPhone("09320302302");
			user.setCreateDate(new Date());
			user.setId(12);
			List<Role> roles=new ArrayList<Role>();
			Role role1=new Role();
			Role role2=new Role();
			Role role1=new Role();
			role2.setIdrole(1);
			roles.add(role2);
			roles.add(role1);
			System.out.println(userService.addrole(roles, role2));
			userService.removerole(roles, role2);
			System.out.println(roles.size());
			userService.deleteuser(user);*/
			
//			User user =userService.userDAOImpl.findbyId(User.class,12);
//			user.setCode("alko");
//			Role role1=new Role();
//			Role role2=new Role();
//			role1.setIdrole(2);
//			role2.setIdrole(1);
//			userService.addrole(role1);
//			userService.addrole(role2);
			
			
//			try {
//				userService.edituser(user);
//			} catch (Myexception e) {
//				System.out.println(e);
//			}
//			UserRole userRole=(UserRole) user.getUserRoles().iterator().next();
//			userService.userRoleDAOImpl.delete(userRole);
	}
	public void checkuser(String code ,String password) throws Myexception {
		if(!code.isEmpty()&&!password.isEmpty()) {
			List<User>result=userDAOImpl.findbyproperty("code",code);
			if(result.size()!=0&&result.get(0).getPassword().equals(password)) {
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

	// moi lan save hay lam chi do xong phai clear rolelist di
	public void adduser(User user) throws Myexception {
		if(user.getPhone().length()!=10) throw new Myexception("Phone number must be 10 digits");
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
