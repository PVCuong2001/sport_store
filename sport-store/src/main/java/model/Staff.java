package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Staff extends User implements java.io.Serializable{
	private Set bills = new HashSet(0);

	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Staff(int id, String code, String name, String phone, String gmail, String password, int activeFlag,
			String gender, Set userRoles,Set bills) {
		super(id, code, name, phone, gmail, password, activeFlag, gender, userRoles);
		this.bills=bills;
	}

	public Set getBills() {
		return bills;
	}

	public void setBills(Set bills) {
		this.bills = bills;
	}
	
	
}
