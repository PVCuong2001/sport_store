package dao;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.User;
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO{

	public UserDAOImpl(Class<User> aClazz) {
		super(aClazz);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkaddinfo(String code ,String password, String gmail, String phone) {
			Session session =sessionFactory.openSession();
			BigInteger check;
			StringBuilder stringquery=new StringBuilder();
			stringquery.append("select count(id_user) from user where user_code=:code or user_password=:password or user_gmail=:gmail or user_phone=:phone");
				session.beginTransaction();
				check=(BigInteger) session.createNativeQuery(stringquery.toString())
				.setParameter("code",code)
				.setParameter("password",password)
				.setParameter("gmail",gmail)
				.setParameter("phone",phone)
				.uniqueResult();
				if(check.compareTo(BigInteger.ZERO)==0) return true;
				session.flush();
				session.close();
		return false;
	}
	







}
