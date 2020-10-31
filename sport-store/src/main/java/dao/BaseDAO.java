package dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO <E> {
	public List<E>findall(String clazz);
	public E findbyId(Class<E>e,Serializable id,String clazz);
	public List<E>findbyproperty(String property,Object value,String clazz);
	public void save(E instance);
	public void update(E instance);
	public long total(String clazz);
}