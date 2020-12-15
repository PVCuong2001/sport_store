package dao;

import java.util.List;

import model.Bill;
import model.Staff;

public interface StaffDAO extends BaseDAO<Staff> {
	 Staff findstaff(String code);
}
