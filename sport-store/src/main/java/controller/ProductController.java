package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.management.InstanceNotFoundException;
import javax.persistence.criteria.CriteriaBuilder.In;

import config.Injector;
import dao.BranchCategoryDAO;
import dao.BranchDAO;
import dao.CategoryDAO;
import dao.ColorDAO;
import dao.ProductDAO;
import dao.SizeDAO;
import dao.StockDAO;
import model.Branch;
import model.BranchCategory;
import model.Category;
import model.Color;
import model.ProductInfo;
import model.Size;
import model.Stock;
import model.Checkstockproperty;
import model.UploadProductComponent;
import service.UserService;

public class ProductController {
	private static ProductDAO<ProductInfo>productDAO;
	private static BranchDAO<Branch>branchDAO;
	private static CategoryDAO<Category>categoryDAO;
	private static ColorDAO<Color>colorDAO ;
	private static SizeDAO<Size>sizeDAO;
	private static BranchCategoryDAO<BranchCategory>bracateDAO;
	private static StockDAO<Stock>stockDAO;
	private static List<Stock>list=new ArrayList<Stock>();
	
	@SuppressWarnings("unchecked")
	public ProductController() throws InstanceNotFoundException {
		productDAO=(ProductDAO<ProductInfo>) Injector.getInstance("ProductDAOImpl");
		branchDAO=(BranchDAO<Branch>) Injector.getInstance("BranchImpl");
		categoryDAO=(CategoryDAO<Category>) Injector.getInstance("CategoryImpl");
		colorDAO=(ColorDAO<Color>) Injector.getInstance("ColorImpl");
		sizeDAO=(SizeDAO<Size>) Injector.getInstance("SizeImpl");
		bracateDAO=(BranchCategoryDAO<BranchCategory>) Injector.getInstance("BranchCategoryImpl");
		stockDAO=(StockDAO<Stock>) Injector.getInstance("StockDAOImpl");
	}
//	public static void main(String[] args) throws InstanceNotFoundException  {
//		ProductController controller=new ProductController();
//		Object [][] data=controller.showproduct(1,10, 2);
//		for(Object[] i :data) {
//			for(Object j :i) {
//				System.out.print(j+"         ");
//			}
//			System.out.println();
//		}
//		UploadProductComponent result=controller.uploadproduct();
//		System.out.println(result.getBranch().get(0).getName());
//		int id=ProductController.bracateDAO.findbybracate( 2, 3);
//		System.out.println(id);
////		System.out.println(controller.totalproduct());
//		
//		//controller.saveproduct("Tatdabong","T001", "toẹt vời ko bk ns gi hon",420000, "none", 3, 2);
//	}
	public Object[][] showproduct(int page,int rowcount,int sortoption) {
		list=ProductController.productDAO.findbypage((page-1)*rowcount,rowcount,sortoption);
		Object [][] result= new Object[list.size()][8];
		for(int i=0;i<list.size();i++) {
			result[i][0]=(page-1)*rowcount+i+1;
			result[i][1]=list.get(i).getProductInfo().getName();
			result[i][2]=list.get(i).getProductInfo().getCode();
			result[i][3]=list.get(i).getProductInfo().getCurrentPrice();
			result[i][4]=list.get(i).getProductInfo().getBranchCategory().getCategory().getName();
			result[i][5]=list.get(i).getSize().getName();
			result[i][6]=list.get(i).getColor().getName();
			result[i][7]=list.get(i).getStockQuantity();
		}
		return result;
	}
	public UploadProductComponent uploadproduct() {
		List<Branch>branches=ProductController.branchDAO.findall("Branch");
		List<Category>categories=ProductController.categoryDAO.findall("Category");
		List<Color>colors=ProductController.colorDAO.findall("Color");
		List<Size>sizes=ProductController.sizeDAO.findall("Size");
		UploadProductComponent results =new UploadProductComponent(branches, categories, colors, sizes);
		return results;
	}
	//neu tk nay tra ra khac 0 thi chon san Branch va Category
	public int checkexistproduct(String code) {
		List<ProductInfo>list=productDAO.findbyproperty("code",code,"ProductInfo");
		if(list.size()!=0 && !list.isEmpty()) {
			return list.get(0).getId();
		}
		return 0;
	}
	public void saveproduct(String name ,String code ,String description,int currentprice,String  imgURl,int id_branch,int id_category,int id_color,int id_size,int id_pro) {
		ProductInfo productInfo=new ProductInfo();
		Checkstockproperty stockId=new Checkstockproperty();
		if(id_pro!=0) {
			stockId.setIdStockColor(id_color);
			stockId.setIdStockPro(id_pro);
			stockId.setIdStockSize(id_size);
			boolean check=stockDAO.checkexiststockcompokey(id_pro, id_color, id_size);
			if(check) {
				
			}
		}
		
		BranchCategory branchCategory=new BranchCategory();
		
		int id_bracate=ProductController.bracateDAO.findbybracate(id_branch, id_category);
		branchCategory.setId(id_bracate);
		
		productInfo.setBranchCategory(branchCategory);
		productInfo.setName(name);
		productInfo.setCode(code);
		productInfo.setDescription(description);
		productInfo.setCurrentPrice(currentprice);
		productInfo.setImgUrl(imgURl);
		productInfo.setActiveFlag(1);
		productInfo.setCreateDate(new Date());
		productInfo.setUpdateDate(new Date());
		ProductController.productDAO.save(productInfo);
	}
	public void deleteproduct() {
		//click vo mot hang thi lay index hang do --->vo liststock kiem--->
		ProductInfo productInfo=productDAO.findbyId(ProductInfo.class,3);
		productInfo.setActiveFlag(0);
		productDAO.update(productInfo);
	}
	public Integer[] listpage() {
		long result =ProductController.productDAO.total("ProductInfo");
		int totalpage;
		if(result%10==0) {
			totalpage=(int)result/10;
		}else {
			totalpage=(int)result/10+1;
		}
		Integer listpage[]=new Integer[totalpage];
		for(int i=0;i<totalpage;i++) {
			listpage[i]=i+1;
		}
		return listpage;
	}
	public long totaldata() {
		long result =ProductController.productDAO.total("ProductInfo");
		return result;
	}
}
