package dao;

import java.util.List;

import model.Stock;

public interface ProductDAO<E> extends BaseDAO<E>{
	public List<Stock> findbypage(int offsett,int rowcount,int sortoption);
}
