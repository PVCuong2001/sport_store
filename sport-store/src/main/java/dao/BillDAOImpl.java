package dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.Bill;
import model.Stock;

public class BillDAOImpl extends BaseDAOImpl<Bill> implements BillDAO{
	public BillDAOImpl(Class<Bill> aClazz) {
		super(aClazz);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Object[]> findbytotal(int mintotal ,int maxtotal,String mindate,String maxdate) {
		List<Object[]>results=new ArrayList<>();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		StringBuilder stringquery=new StringBuilder();
		stringquery.append("select bi.*,sum(bide.billdetail_quantity) as sumqty,sum(bide.billdetail_quantity*bide.billdetail_price) as sumtotal, us.user_name,us.user_code from bill bi \n" + 
				"join billdetail bide\n" + 
				"on bi.id_bill=bide.id_billdetail_bill\n" + 
				"join stock sto\n" + 
				"on bide.id_billdetail_stock=sto.id_stock\n" + 
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
	
	
	public List<Object[]>findprintedbill(){
		List<Object[]>result=new ArrayList<Object[]>();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		StringBuilder stringquery=new StringBuilder();
		stringquery.append("SELECT bill_code,sum(billdetail_quantity)as totalqty,sum(billdetail_quantity*billdetail_price) as totalvalue,bill_status  from bill")
					.append(" join billdetail on id_bill=id_billdetail_bill")
					.append(" group by bill_code")
					.append(" having bill_status=0")
					.append(" order by totalqty asc");
		result=session.createSQLQuery(stringquery.toString()).list();
		session.flush();
		session.close();
		return result;
	}
	@Override
	public List<Object[]> findbilldetail(int billid) {
		List<Object[]>results=new ArrayList<>();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		StringBuilder stringquery=new StringBuilder();
		stringquery.append("SELECT pro.pro_code,pro.pro_name,color.color_name,size.size_name, bide.billdetail_quantity,bide.billdetail_price FROM billdetail bide ") 
				   .append("join stock sto ") 
				   .append("on bide.id_billdetail_stock=sto.id_stock ") 
				   .append("join product_info pro ")
				   .append("on sto.id_stock_pro=pro.id_pro ")
				   .append("join color ")
				   .append("on sto.id_stock_color=color.id_color ")
				   .append("join size ")
				   .append("on sto.id_stock_size=size.id_size ")
				   .append("where bide.id_billdetail_bill= :billid");
		Query query=session.createSQLQuery(stringquery.toString()).setParameter("billid", billid);
		results=query.list();
		session.flush();
		session.close();
		return results;
	}
}
