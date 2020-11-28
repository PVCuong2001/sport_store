package dao;

import java.util.List;

import model.Stock;

public interface StockDAO<E> extends BaseDAO<E> {
	public List<Stock> getproductcode(String code);
	public  boolean checkexiststockcompokey(int id_pro,int id_color,int id_size);
	public void savestock(int id_pro,int id_color,int id_size,int quantity );
	public void deletestock(int id_pro);
}
