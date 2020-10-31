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
		List<Stock>list=new ArrayList<Stock>();
		StringBuilder stringquery=new StringBuilder();
		stringquery.append("select {st.*} from stock st join product_info p on st.id_stock_pro = p.id_pro where p.pro_code= :code");
		Query query=session.createSQLQuery(stringquery.toString()).addEntity("st",Stock.class).addJoin("p","st.productInfo")
							.setParameter("code", code);
		list=query.list();
		session.flush();
		session.close();
		return null;
	}

}
