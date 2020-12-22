package dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO <E> {
	 List<E>findall();
	 E findbyId(Class<E>e,Serializable id);
	 List<E>findbyproperty(String property,Object value);
	 void save(E instance);
	 void update(E instance);
	 long total();
	 void delete (E instance );
	 int nextid(String tablename);
}