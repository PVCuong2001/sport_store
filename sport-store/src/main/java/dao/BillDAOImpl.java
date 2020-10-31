package dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public class BillDAOImpl<E> extends BaseDAOImpl<E> implements BillDAO<E>{

	@Override
	public int getmaxbill() {
		BigInteger result;
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		StringBuilder stringquery=new StringBuilder();
		stringquery.append("select auto_increment from information_schema.TABLES where TABLE_SCHEMA ='sport_store' and TABLE_NAME ='bill'");
		result=(BigInteger) session.createSQLQuery(stringquery.toString()).uniqueResult();
		session.flush();
		session.close();
		return result.intValue();
	}
	
}
