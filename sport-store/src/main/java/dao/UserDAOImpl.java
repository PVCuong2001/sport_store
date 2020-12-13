package dao;
import model.User;
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO{

	public UserDAOImpl(Class<User> aClazz) {
		super(aClazz);
	}

}
