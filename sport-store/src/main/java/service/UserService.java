package service;

import config.Injector;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.Role;
import model.User;
import model.UserRole;

import java.util.*;

import java.util.logging.Logger;

import javax.management.InstanceNotFoundException;


public class UserService  {
	public static User storeuser=null;
	private UserDAOImpl<User> userDAOImpl;
	public UserService() {
		userDAOImpl=new UserDAOImpl<User>();
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
}
