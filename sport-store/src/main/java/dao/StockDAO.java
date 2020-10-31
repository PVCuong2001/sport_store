package dao;

import java.util.List;

import model.Stock;

public interface StockDAO<E> extends BaseDAO<E> {
	public List<Stock> getproductcode(String code);
}
