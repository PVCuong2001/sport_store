package test;
// Generated Nov 26, 2020, 5:02:29 PM by Hibernate Tools 5.4.18.Final

import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {

	private int idUser;
	private String userCode;
	private String userName;
	private String userPhone;
	private String userGmail;
	private String userAddress;
	private String userPassword;
	private int userActiveFlag;
	private String userGender;
	private Set bills = new HashSet(0);
	private Set userRoles = new HashSet(0);

	public User() {
	}

	public User(int idUser, String userCode, String userName, String userPhone, String userGmail, String userAddress,
			String userPassword, int userActiveFlag, String userGender) {
		this.idUser = idUser;
		this.userCode = userCode;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userGmail = userGmail;
		this.userAddress = userAddress;
		this.userPassword = userPassword;
		this.userActiveFlag = userActiveFlag;
		this.userGender = userGender;
	}

	public User(int idUser, String userCode, String userName, String userPhone, String userGmail, String userAddress,
			String userPassword, int userActiveFlag, String userGender, Set bills, Set userRoles) {
		this.idUser = idUser;
		this.userCode = userCode;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userGmail = userGmail;
		this.userAddress = userAddress;
		this.userPassword = userPassword;
		this.userActiveFlag = userActiveFlag;
		this.userGender = userGender;
		this.bills = bills;
		this.userRoles = userRoles;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserGmail() {
		return this.userGmail;
	}

	public void setUserGmail(String userGmail) {
		this.userGmail = userGmail;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getUserActiveFlag() {
		return this.userActiveFlag;
	}

	public void setUserActiveFlag(int userActiveFlag) {
		this.userActiveFlag = userActiveFlag;
	}

	public String getUserGender() {
		return this.userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public Set getBills() {
		return this.bills;
	}

	public void setBills(Set bills) {
		this.bills = bills;
	}

	public Set getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set userRoles) {
		this.userRoles = userRoles;
	}

}
