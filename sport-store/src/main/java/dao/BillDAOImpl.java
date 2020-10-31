package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public class BillDAOImpl<E> extends BaseDAOImpl<E> implements BillDAO<E>{

	@Override
	public int getmaxbill() {
		int result;
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		StringBuilder query=new StringBuilder();
		query.append("select max(b.id) from ").append("Bill").append(" b  ");
		result=(int) session.createQuery(query.toString()).uniqueResult();
		session.flush();
		session.close();
		return result;
	}
	
}
