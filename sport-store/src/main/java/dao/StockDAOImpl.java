package dao;

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
		stringquery.append("select st.*,pr.* FROM stock st JOIN product_info pr ON st.id_stock_pro = pr.id_pro where pr.pro_code= :code");
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
}
