package dao;

import java.util.List;

import mix.Myexception;
import model.Checkstockproperty;
import model.Stock;

public interface StockDAO extends BaseDAO<Stock> {
	 List<Stock> findbyidpro(int id_pro,boolean check);
	 void savestock(int id_pro,int id_color,int id_size,int quantity );
	 void deletestock(int id_pro);
	 void updatestock(int qty,int id_stock,int activeflag);
}
