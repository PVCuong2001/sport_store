package dao;

import java.util.List;

import model.Checkstockproperty;
import model.Stock;
import validate.Myexception;

public interface StockDAO extends BaseDAO<Stock> {
	 List<Stock> findbyidpro(int id_pro);
	 List<Object[]> findstoinfo(int id_pro) throws Myexception;
	 void savestock(int id_pro,int id_color,int id_size,int quantity );
	 void deletestock(int id_pro);
	 void updatestock(int qty,int id_stock,int activeflag);
}
