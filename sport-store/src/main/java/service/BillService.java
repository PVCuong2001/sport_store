package service;

import java.util.List;

import model.Checkstockproperty;
import model.ProductInfo;
import model.Stock;
import model.UploadProductComponent;
import validate.Myexception;

public interface BillService {
	void savebill(String code,String description,int status ) throws Myexception;
	List<Stock> checkprocode(String code) throws Myexception;
	void addproduct(int index,int qty) throws Myexception;
	Object[][] showbill(int mintotal,int maxtotal,String mindate,String maxdate);
	Object[][] showbilldetail(int index);
	Object[][] findprintedbill();
	void deletebill(int index) throws Myexception ;
	void removeproduct(int index);
}
