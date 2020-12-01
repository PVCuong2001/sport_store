package dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.Stock;

public class StockDAOImpl<E> extends BaseDAOImpl<E> implements StockDAO<E> {

	@Override
	public List<Stock> getproductcode(String code) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Object[]>results=new ArrayList<>();
		StringBuilder stringquery=new StringBuilder();
		stringquery.append("select st.*,pro.* FROM stock st JOIN product_info pro ON st.id_stock_pro = pro.id_pro where pro.pro_code= :code && pro.id_pro=1");
		Query query=session.createSQLQuery(stringquery.toString()).addEntity("st",Stock.class).addJoin("pr","st.productInfo")
							.setParameter("code", code);
		results=query.list();
		List<Stock> list=new ArrayList<>();
		for(Object[] row :results) {
			Stock stock=(Stock) row[0];
			list.add(stock);
		}
		session.flush();
		session.close();
		return list;
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
		session.beginTransaction();
		StringBuilder stringquery=new StringBuilder();
		stringquery.append("insert into stock(stock_quantity,id_stock_size,id_stock_color,id_stock_pro) value(:quantity ,:id_size,:id_color,:id_pro)");
		session.createSQLQuery(stringquery.toString())
								.setParameter("quantity",quantity)
								.setParameter("id_color", id_color)
								.setParameter("id_size",id_size)
								.setParameter("id_pro",id_pro)
								.executeUpdate();
		session.flush();
		session.close();
	}

	@Override
	public void deletestock(int id_pro) {
		Session session =sessionFactory.openSession();
		session.beginTransaction();
		StringBuilder stringquery=new StringBuilder();
		stringquery.append("delete from stock where id_stock_pro =:id_pro");
		session.createNativeQuery(stringquery.toString())
									.setParameter("id_pro",id_pro)
									.executeUpdate();
		session.flush();
		session.close();
	}
}
