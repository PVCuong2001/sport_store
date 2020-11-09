package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import  java.util.logging.Logger ;
public class BaseDAOImpl<E> implements BaseDAO<E> {
	static final Logger log=Logger.getLogger(BaseDAOImpl.class.getName());
	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	@Override
	public List<E> findall(String clazz) {
		log.info("find all start : ....");
		List<E> results=new ArrayList<E>();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		StringBuilder query=new StringBuilder();
		query.append(" from ").append(clazz);
		results=session.createQuery(query.toString()).list();
		session.flush();
		session.close();
		return results;
	}

	@Override
	public E findbyId(Class<E> instance, Serializable id,String clazz) {
		Session session=sessionFactory.openSession();
		E result =session.get(instance ,id);
		session.close();
		return result;
	}

	@Override
	public List<E> findbyproperty(String property, Object value, String clazz) {
		log.info("find by property from DAO : .......");
		List<E>results=new ArrayList<E>();
		Session session =sessionFactory.openSession();
		session.beginTransaction();
		StringBuilder query=new StringBuilder();
		query.append(" from ").append(clazz).append(" where ").append(property).append(" = '").append(value).append("'");
		results=session.createQuery(query.toString()).list();
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
			session.flush();
			session.close();
		}		
	}

	@Override
	public long total(String clazz) {
		Session session =sessionFactory.openSession();
		session.beginTransaction();
		StringBuilder query=new StringBuilder();
		query.append("select count (e.id) from ").append(clazz).append(" e");
		long result=(long) session.createQuery(query.toString()).uniqueResult();
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
}
