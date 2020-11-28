package test;
// Generated Nov 26, 2020, 5:02:29 PM by Hibernate Tools 5.4.18.Final

/**
 * UserRoleId generated by hbm2java
 */
public class UserRoleId implements java.io.Serializable {

	private int idUsroUser;
	private int idUsroRole;

	public UserRoleId() {
	}

	public UserRoleId(int idUsroUser, int idUsroRole) {
		this.idUsroUser = idUsroUser;
		this.idUsroRole = idUsroRole;
	}

	public int getIdUsroUser() {
		return this.idUsroUser;
	}

	public void setIdUsroUser(int idUsroUser) {
		this.idUsroUser = idUsroUser;
	}

	public int getIdUsroRole() {
		return this.idUsroRole;
	}

	public void setIdUsroRole(int idUsroRole) {
		this.idUsroRole = idUsroRole;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserRoleId))
			return false;
		UserRoleId castOther = (UserRoleId) other;

		return (this.getIdUsroUser() == castOther.getIdUsroUser())
				&& (this.getIdUsroRole() == castOther.getIdUsroRole());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdUsroUser();
		result = 37 * result + this.getIdUsroRole();
		return result;
	}

}
