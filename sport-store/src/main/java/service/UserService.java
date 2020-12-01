package service;

import config.Injector;
import dao.RoleDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.Checkstockproperty;
import model.Role;
import model.User;
import model.UserRole;
import model.UserRoleId;

import java.util.*;

import java.util.logging.Logger;

import javax.management.InstanceNotFoundException;


public class UserService  {
	public static User storeuser=null;
	private UserDAOImpl<User> userDAOImpl;
	private RoleDAOImpl<Role>roleDAOImpl;
	private int nextid;
	public UserService() {
		userDAOImpl=new UserDAOImpl<User>();
		roleDAOImpl=new RoleDAOImpl<Role>();
		nextid=userDAOImpl.nextid("user");
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
			role1.setIdrole(2);
			role2.setIdrole(1);
			roles.add(role2);
			roles.add(role1);
			System.out.println(userService.addrole(roles, role2));
			userService.removerole(roles, role2);
			System.out.println(roles.size());
			userService.deleteuser(user);
	}
	public int checkuser(String code ,String password) {
		if(!code.isEmpty()&&!password.isEmpty()) {
			List<User>result=userDAOImpl.findbyproperty("code",code,"User");
			if(result.size()!=0&&result.get(0).getPassword().equals(password)) {
			storeuser=result.get(0);
			return 1000;
			}else {
				return 1002;
			}
		}else {
			return 1001;
		}
	}
	public Object[][] showuser() {
		List<User>list=userDAOImpl.findall("User");
		Object[][] result= new Object[list.size()][7];
		UserRole userRole;
		Role role;
		for(int i=0;i<list.size();i++) {
			result[i][0]=i+1;
			result[i][1]=list.get(i).getName().toString();
			result[i][2]=list.get(i).getPhone().toString();
			result[i][3]=list.get(i).getGmail().toString();
			result[i][4]=list.get(i).getGender().toString();
			String rolename="";
			if(list.get(i).getActiveFlag()==1) {
				result[i][5]="valid";
				Iterator<UserRole>ite= list.get(i).getUserRoles().iterator();
				while(ite.hasNext()) {
					userRole=ite.next();
					if(userRole.getActiveflag()==1) {
						role=userRole.getRole();
						rolename+=role.getRolename()+",";
					}else {
						rolename+=",";
					}
				}
				rolename=rolename.substring(0,rolename.length()-1);
			}else {
				result[i][5]="invalid";
				result[i][6]="none";
			}
			if(rolename.equals("")) {
				result[i][6]="none";
			}else {
				result[i][6]=rolename;
			}
		}
		return result;
	} 
	public int addrole(List<Role>rolelist,Role role) {
		if(rolelist.contains(role)) return 1008;
		rolelist.add(role);
		return 1000;
	}
	public int removerole(List<Role>rolelist,Role role) {
		rolelist.remove(role);
		return 1000;
	}
	
	public List<Role>getrole(){
		List<Role>result=roleDAOImpl.findall("Role");
		return result;
	}
	public int adduser(User user,List<Role>rolelist) {
		user.setActiveFlag(1);
		user.setCreateDate(new Date());
		user.setUpdateDate(new Date());
		
		Set<UserRole> userroleset=new HashSet<UserRole>();
		for(int i=0;i<rolelist.size();i++) {
			UserRole userRole=new UserRole();
			userRole.setId(new UserRoleId(nextid,rolelist.get(i).getIdrole()));
			userRole.setActiveflag(1);
			userRole.setCreatedate(new Date());
			userRole.setUpdatedate(new Date());
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
