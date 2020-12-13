package dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.Checkstockproperty;
import model.Stock;

public class StockDAOImpl extends BaseDAOImpl<Stock> implements StockDAO {

	public StockDAOImpl(Class<Stock> aClazz) {
		super(aClazz);
		// TODO Auto-generated constructor stub
	}
	@Override
	public List<Object[]>findbyidpro(int id_pro) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Object[]>results=new ArrayList<>();
		StringBuilder stringquery=new StringBuilder();
		stringquery.append("select id_stock,id_stock_color,id_stock_size,color.color_name,size.size_name,st.stock_quantity FROM stock st JOIN product_info pro ON st.id_stock_pro = pro.id_pro ")
					.append("JOIN color ON st.id_stock_color=color.id_color ")
					.append("JOIN size ON st.id_stock_size=size.id_size ")						
					.append("where st.id_stock_pro= :id_pro ");
		Query query=session.createSQLQuery(stringquery.toString()).setParameter("id_pro", id_pro);
		results=query.list();
		session.flush();
		session.close();
		return results;
	}
	@Override
	public int checkexiststockcompokey(int id_pro, int id_color, int id_size,int qty) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		int result;
		StringBuilder stringquery=new StringBuilder();
		stringquery.append("select id_stock from stock where id_stock_pro = :id_pro && id_stock_color = :id_color && id_stock_size = :id_size && stock_quantity >= :qty && stock_activeflag=1");
		try {
			result= (int) session.createSQLQuery(stringquery.toString())
					.setParameter("id_pro",id_pro)
					.setParameter("id_color",id_color)
					.setParameter("id_size",id_size)
					.setParameter("qty", qty)
					.uniqueResult();
		}catch(Exception e) {
			result=0;
		}finally {
			session.flush();
			session.close();
		}
		return result;
//		if(result.compareTo(BigInteger.ZERO)>0) return true;
//		return false;
	}

	@Override
	public void savestock(int id_pro, int id_color, int id_size, int quantity) {
		Session session =sessionFactory.openSession();
		StringBuilder stringquery=new StringBuilder();
		stringquery.append("insert into stock(stock_quantity,id_stock_size,id_stock_color,id_stock_pro,stock_activeflag) value(:quantity ,:id_size,:id_color,:id_pro,1)");
		try {
			session.beginTransaction();
			session.createSQLQuery(stringquery.toString())
			.setParameter("quantity",quantity)
			.setParameter("id_color", id_color)
			.setParameter("id_size",id_size)
			.setParameter("id_pro",id_pro)
			.executeUpdate();
		}catch(Exception e) {
			session.getTransaction().rollback();
		}finally {
			session.flush();
			session.close();
		}
	}
	

	@Override
	public void deletestock(int id_pro) {
		Session session =sessionFactory.openSession();
		StringBuilder stringquery=new StringBuilder();
		stringquery.append("delete from stock where id_stock_pro =:id_pro");
		try {
			session.beginTransaction();
			session.createNativeQuery(stringquery.toString())
			.setParameter("id_pro",id_pro)
			.executeUpdate();
		}catch(Exception e) {
			session.getTransaction().rollback();
		}finally {
			session.flush();
			session.close();
		}

	}
	@Override
	public void updatestock(int qty,int id_stock,int activeflag) {
		Session session =sessionFactory.openSession();
		StringBuilder stringquery=new StringBuilder();
		stringquery.append("Update stock set stock_activeflag=:activeflag , stock_quantity=:qty where id_stock=:idstock");
		try {
			session.beginTransaction();
			session.createNativeQuery(stringquery.toString())
			.setParameter("qty",qty)
			.setParameter("idstock",id_stock)
			.setParameter("activeflag",activeflag)
			.executeUpdate();
		}catch(Exception e) {
			session.getTransaction().rollback();
		}finally {
			session.flush();
			session.close();
		}
	}
}
