package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BranchCategoryDAOImpl<E> extends BaseDAOImpl<E> implements BranchCategoryDAO<E>{
	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	@Override
	public int findbybracate(int idbra, int idcate) {
		int result=0;
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		StringBuilder query=new StringBuilder();
		query.append("select id_bracate from branch_category where id_bracate_bra= :idbra && id_bracate_cate= :idcate");
		result=(int) session.createSQLQuery(query.toString()).setParameter("idbra", idbra).setParameter("idcate", idcate).uniqueResult();
		session.flush();
		session.close();
		return result;
	}
}
