package model;
// Generated Oct 6, 2020, 4:08:13 PM by Hibernate Tools 5.4.18.Final

/**
 * UserWorkingshift generated by hbm2java
 */
public class UserWorkingshift implements java.io.Serializable {

	private UserWorkingshiftId id;
	private User user;
	private WorkingShift workingShift;
	private int weekth;

	public UserWorkingshift() {
	}

	public UserWorkingshift(UserWorkingshiftId id, User user, WorkingShift workingShift, int weekth) {
		this.id = id;
		this.user = user;
		this.workingShift = workingShift;
		this.weekth = weekth;
	}

	public UserWorkingshiftId getId() {
		return this.id;
	}

	public void setId(UserWorkingshiftId id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public WorkingShift getWorkingShift() {
		return this.workingShift;
	}

	public void setWorkingShift(WorkingShift workingShift) {
		this.workingShift = workingShift;
	}

	public int getWeekth() {
		return this.weekth;
	}

	public void setWeekth(int weekth) {
		this.weekth = weekth;
	}

}
