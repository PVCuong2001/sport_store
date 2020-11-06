package dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.Bill;
import model.Stock;

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

	@Override
	public List<Object[]> findbytotal(int mintotal ,int maxtotal,String mindate,String maxdate) {
		List<Object[]>results=new ArrayList<>();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		StringBuilder stringquery=new StringBuilder();
		stringquery.append("select bi.*,sum(bipro.quantity) as sumqty,sum(bipro.quantity*bipro.price) as sumtotal, us.user_name,us.user_code from bill bi \n" + 
				"join bill_product bipro\n" + 
				"on bi.id_bill=bipro.id_bipro_bill\n" + 
				"join product_info pro\n" + 
				"on bipro.id_bipro_productinfo=pro.id_pro\n" + 
				"join user us\n" + 
				"on bi.id_bill_user=us.id_user\n" + 
				"group by bi.id_bill ")
				.append("having sumtotal between :mintotal and :maxtotal")
				.append(" and bill_createdate between cast(:mindate as datetime) and cast(:maxdate as datetime) ");	
		Query query=session.createSQLQuery(stringquery.toString())
					.setParameter("mintotal", mintotal).setParameter("maxtotal", maxtotal)
				    .setParameter("mindate", mindate).setParameter("maxdate", maxdate);
		results=query.list();
		session.flush();
		session.close();
		return results;
	}

	@Override
	public List<Object[]> findbilldetail(int billid) {
		List<Object[]>results=new ArrayList<>();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		StringBuilder stringquery=new StringBuilder();
		stringquery.append("SELECT pro.pro_code,pro.pro_name, bipro.quantity,bipro.price FROM bill_product bipro ") 
				   .append("join product_info pro ") 
				   .append("on bipro.id_bipro_productinfo=pro.id_pro ") 
				   .append("where bipro.id_bipro_bill= :billid");
		Query query=session.createSQLQuery(stringquery.toString()).setParameter("billid", billid);
		results=query.list();
		return results;
	}
}
