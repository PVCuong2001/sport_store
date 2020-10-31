package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import model.Branch;
import model.BranchCategory;
import model.ProductInfo;
import model.Stock;
import model.User;

public class ProductDAOImpl<E> extends BaseDAOImpl<E> implements ProductDAO<E> {
	SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
	@Override
	public List<Stock> findbypage(int offsett, int rowcount, int sortoption) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Object[]>results=new ArrayList<>();
		Query query=session.createSQLQuery("call productpro(:offsett,:rowcount,:sortoption)").addEntity("st",Stock.class).addJoin("pr","st.productInfo")
				.addJoin("brca","pr.branchCategory").addJoin("br","brca.branch").addJoin("ca","brca.category").addJoin("si","st.size").addJoin("co","st.color" )
				.setParameter("offsett", offsett).setParameter("rowcount", rowcount).setParameter("sortoption", sortoption);
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
