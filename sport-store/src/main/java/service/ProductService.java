package service;

import model.Checkstockproperty;
import model.ProductInfo;
import model.UploadProductComponent;
import validate.Myexception;

public interface ProductService {
	Object[][] showproduct(int page,int rowcount,int sortoption);
	Object[][] showdetail(int index);
	void addstockproperty(Checkstockproperty checksto) throws Myexception;
	void deletestockproperty(int  index);
	UploadProductComponent uploadproduct() ;
	void saveproduct(ProductInfo productInfo) throws Myexception;
	void editproduct(ProductInfo productInfo) throws Myexception ;
	void deleteproduct(int index) throws Myexception ;
	Integer[] listpage() ;
	long totaldata();
}
