package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.Bill;
import model.Staff;
import model.User;

public class StaffDAOImpl extends BaseDAOImpl<Staff> implements StaffDAO {

	public StaffDAOImpl(Class<Staff> aClazz) {
		super(aClazz);
	}

	@Override
	public Staff findstaff(String code) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		StringBuilder stringquery=new StringBuilder();
		Set<Bill>result=new HashSet<Bill>();
		stringquery.append("select user.*,user_role.*,role.*,id_bill,bill_code from user ")
					.append(" join user_role on id_user=id_usro_user")
					.append(" join role on id_role=id_usro_user")
					.append(" join bill on id_user=id_bill_user")
					.append(" where user_code=:code");
		Query query=session.createSQLQuery(stringquery.toString()).setParameter("code", code)
							.addEntity("staff",Staff.class).addJoin("usro","staff.userRoles").addJoin("ro","usro.role");
		List<Object[]> rows = query.list();
		for(Object[] row : rows){
			Bill bill = new Bill();
			bill.setId(Integer.parseInt(row[3].toString()));
			bill.setCode(row[4].toString());
			result.add(bill);
		}
		Staff staff=(Staff) rows.get(0)[0];
		staff.setBills(result);
		session.flush();
		session.close();
		return staff;
	}


}
