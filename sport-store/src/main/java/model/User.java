package model;
// Generated Oct 6, 2020, 4:08:13 PM by Hibernate Tools 5.4.18.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable,Cloneable  {
	private int id;


	private String code;
	private String name;
	private String phone;
	private String gmail;
	private String password;
	private int activeFlag;
	private String gender;
	private Date createDate;
	private Date updateDate;
	private int isAdmin;
	private Set bills = new HashSet(0);

	public User() {
	}

	public User(int id, String code, String name, String phone, String gmail, String password,
			int activeFlag, String gender,int isAdmin,Set bills ) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.phone = phone;
		this.gmail = gmail;
		this.password = password;
		this.activeFlag = activeFlag;
		this.gender = gender;
		this.isAdmin=isAdmin;
		this.bills=bills;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGmail() {
		return this.gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Set getBills() {
		return bills;
	}

	public void setBills(Set bills) {
		this.bills = bills;
	}
	public int getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
