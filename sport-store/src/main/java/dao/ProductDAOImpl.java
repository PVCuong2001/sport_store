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

public class ProductDAOImpl extends BaseDAOImpl<ProductInfo> implements ProductDAO {
	public ProductDAOImpl(Class<ProductInfo> aClazz) {
		super(aClazz);
		// TODO Auto-generated constructor stub
	}
	SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
	@Override
	public List<ProductInfo> findbypage(int offsett, int rowcount, int sortoption) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Object[]>results=new ArrayList<>();
		Query query=session.createSQLQuery("call productpro(:offsett,:rowcount,:sortoption)").addEntity("pr",ProductInfo.class)
				.addJoin("brca","pr.branchCategory").addJoin("br","brca.branch").addJoin("ca","brca.category")
				.setParameter("offsett", offsett).setParameter("rowcount", rowcount).setParameter("sortoption", sortoption);
		results=query.list();
		List<ProductInfo> list=new ArrayList<>();
		for(Object[] row :results) {
			ProductInfo pro=(ProductInfo) row[0];
			list.add(pro);
		}
		session.flush();
		session.close();
		return list;
	}
}
