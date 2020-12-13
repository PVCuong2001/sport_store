package service;


import dao.BaseDAOImpl;
import dao.RoleDAOImpl;
import dao.UserDAOImpl;
import dao.UserRoleDAO;
import dao.UserRoleDAOImpl;
import model.Checkstockproperty;
import model.Role;
import model.User;
import model.UserRole;
import model.UserRoleId;
import validate.Myexception;

import java.util.*;

public class UserService  {
	public static User storeuser=null;
	private UserDAOImpl userDAOImpl;
	private RoleDAOImpl roleDAOImpl;
	private UserRoleDAOImpl userRoleDAOImpl;
	private int nextid;
	private List<Role>rolelist;
	public UserService() {
		userDAOImpl=new UserDAOImpl(User.class);
		roleDAOImpl=new RoleDAOImpl(Role.class);
		userRoleDAOImpl=new UserRoleDAOImpl(UserRole.class);
		nextid=userDAOImpl.nextid("user");
		rolelist=new ArrayList<Role>();
	}
	public static void main(String[] args) {
			UserService userService=new UserService();
			Object [][] data=userService.showuser();
			for(Object[] i :data) {
				for(Object j :i) {
					System.out.print(j+"         ");
				}
				System.out.println();
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
		List<User>list=userDAOImpl.findall();
		Object[][] result= new Object[list.size()][8];
		UserRole userRole;
		Role role;
		for(int i=0;i<list.size();i++) {
			result[i][0]=i+1;
			result[i][1]=list.get(i).getCode().toString();
			result[i][2]=list.get(i).getName().toString();
			result[i][3]=list.get(i).getPhone().toString();
			result[i][4]=list.get(i).getGmail().toString();
			result[i][5]=list.get(i).getGender().toString();
			String rolename="";
			if(list.get(i).getActiveFlag()==1) {
				result[i][6]="valid";
				Iterator<UserRole>ite= list.get(i).getUserRoles().iterator();
				while(ite.hasNext()) {
					userRole=ite.next();
					role=userRole.getRole();
					rolename+=role.getRolename()+",";
				}
				rolename=rolename.substring(0,rolename.length()-1);
				result[i][7]=rolename;
			}else {
				result[i][6]="invalid";
				result[i][7]="none";
			}
		}
		return result;
	} 

	public int addrole(Role role) {
		if(rolelist.contains(role)) return 1008;
		rolelist.add(role);
		return 1000;
	}
	public int removerole(Role role) {
		rolelist.remove(role);
		return 1000;
	}
	
	public List<Role>getrole(){
		List<Role>result=roleDAOImpl.findall();
		return result;
	}
	// moi lan save hay lam chi do xong phai clear rolelist di
	public int adduser(User user,List<Role>rolelist) {
		user.setActiveFlag(1);
		user.setCreateDate(new Date());
		user.setUpdateDate(new Date());
		
		Set<UserRole> userroleset=new HashSet<UserRole>();
		for(int i=0;i<rolelist.size();i++) {
			UserRole userRole=new UserRole();
			userRole.setId(new UserRoleId(nextid,rolelist.get(i).getIdrole()));
			userroleset.add(userRole);
		}
		user.setUserRoles(userroleset);
		try {
			userDAOImpl.save(user);
			return 1000;
		}catch(Exception e) {
			System.out.println("Error while saving user....");
			return 1007;
		}
	}
	public void edituser(User user) throws Myexception {
		user.setActiveFlag(1);
		user.setUpdateDate(new Date());
		List<User>userlist=userDAOImpl.findbyproperty("code", user.getCode());
		if(userlist.size()!=0 && !userlist.isEmpty() ) throw new Myexception("Ma code da ton tai\n");
		try {
			userDAOImpl.update(user);
			Iterator<UserRole>ite= user.getUserRoles().iterator();
			while(ite.hasNext()) {
				userRoleDAOImpl.delete(ite.next());
			}
			for(int i=0;i<rolelist.size();i++) {
				UserRole userRole=new UserRole();
				userRole.setId(new UserRoleId(user.getId(),rolelist.get(i).getIdrole()));
				userRoleDAOImpl.save(userRole);
			}
		}catch(Exception e){
			throw new Myexception("Error while updating ...\n");
		}
		finally {
			rolelist.clear();
		}
	}
	public int deleteuser(User user) {
		user.setActiveFlag(0);
		user.setUpdateDate(new Date());
		try {
			userDAOImpl.update(user);
			return 1000;
		}catch (Exception e) {
			System.out.println("Error while deleting user ....");
			return 1009;
		}
	}
}
