package dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO <E> {
	public List<E>findall();
	public E findbyId(Class<E>e,Serializable id);
	public List<E>findbyproperty(String property,Object value);
	public void save(E instance);
	public void update(E instance);
	public long total();
	public void delete (E instance );
	public int nextid(String tablename);
}