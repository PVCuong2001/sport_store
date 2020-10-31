package dao;

import org.hibernate.query.Query;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.User;
import service.UserService;

public class UserDAOImpl<E> extends BaseDAOImpl<E> implements UserDAO<E>{
	static final Logger log=Logger.getLogger(UserService.class.getName());
	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	
	@Override
	public List<User> userpro(String property, Object value) {
		Session session;
		session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createSQLQuery("call usertest(:macode)").addEntity(User.class).setParameter("macode",value);
		log.info("heloooooooo "+value);
		session.flush();
		session.close();
		return  query.list();
	}
}
