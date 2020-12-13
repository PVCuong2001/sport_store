package dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BaseDAOImpl<E> implements BaseDAO<E> {
	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	
	protected E obj;
	 
    public BaseDAOImpl(Class<E> aClazz) 
        {
        try {
			this.obj = (E) aClazz.getDeclaredConstructor().newInstance();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
	@Override
	public  List<E> findall() {
		List<E> results=new ArrayList<E>();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		StringBuilder query=new StringBuilder("");
		query.append(" from ").append(obj.getClass().getSimpleName());
		results=session.createQuery(query.toString()).list();
		session.flush();
		session.close();
		return results;
	}

	@Override
	public E findbyId(Class<E> instance, Serializable id) {
		Session session=sessionFactory.openSession();
		E result =session.get(instance ,id);
		session.close();
		return result;
	}

	@Override
	public List<E> findbyproperty(String property, Object value) {
		List<E>results=new ArrayList<E>();
		Session session =sessionFactory.openSession();
		session.beginTransaction();
		StringBuilder query=new StringBuilder();
		query.append(" from ").append(obj.getClass().getSimpleName()).append(" where ").append(property).append(" =:value");
		results=session.createQuery(query.toString()).setParameter("value", value).list();
		session.flush();
		session.close();
		return results;
	}

	@Override
	public void save(E instance) {
		Session session=sessionFactory.openSession();
		try {
			//start transaction
			session.beginTransaction();
			//save object to DB
			session.save(instance);
			//commit transaction
			session.getTransaction().commit();
		}catch(Exception e) {
			//rollback
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
//			session.flush();
			session.close();
		}	
	}

	@Override
	public void update(E instance) {
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.merge(instance);
			//commit transaction
			session.getTransaction().commit();
		}catch(Exception e) {
			//rollback
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
//			session.flush();
			session.close();
		}		
	}

	@Override
	public long total() {
		Session session =sessionFactory.openSession();
		session.beginTransaction();
		StringBuilder query=new StringBuilder();
		query.append("select count (e.id) from ").append(obj.getClass().getSimpleName()).append(" e");
		long result=(long) session.createQuery(query.toString()).uniqueResult();
		session.flush();
		session.close();
		return result;
	}

	@Override
	public void delete(E instance) {
		Session session=sessionFactory.openSession();
		try {
			//start transaction
			session.beginTransaction();
			//save object to DB
			session.delete(instance);
			//commit transaction
			session.getTransaction().commit();
		}catch(Exception e) {
			//rollback
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}	
		
	}

	@Override
	public int nextid(String tablename) {
		BigInteger result=BigInteger.valueOf(0);
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		StringBuilder stringquery=new StringBuilder();
		stringquery.append("call nextid(:tablename)");
		result=(BigInteger) session.createSQLQuery(stringquery.toString()).setParameter("tablename", tablename).uniqueResult();
		session.flush();
		session.close();
		return result.intValue();
	}
}
