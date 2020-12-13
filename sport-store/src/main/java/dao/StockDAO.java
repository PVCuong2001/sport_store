package dao;

import java.util.List;

import model.Checkstockproperty;
import model.Stock;

public interface StockDAO extends BaseDAO<Stock> {
	public List<Object[]> findbyidpro(int id_pro);
	public  int checkexiststockcompokey(int id_pro,int id_color,int id_size,int qty);
	public void savestock(int id_pro,int id_color,int id_size,int quantity );
	public void deletestock(int id_pro);
	public void updatestock(int qty,int id_stock,int activeflag);
}
