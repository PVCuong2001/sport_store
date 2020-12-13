package dao;

import java.util.List;

import model.ProductInfo;

public interface ProductDAO extends BaseDAO<ProductInfo>{
	public List<ProductInfo> findbypage(int offsett,int rowcount,int sortoption);
}
