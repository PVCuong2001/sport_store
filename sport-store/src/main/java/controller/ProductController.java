package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.management.InstanceNotFoundException;

import config.Injector;
import dao.BranchCategoryDAO;
import dao.BranchDAO;
import dao.CategoryDAO;
import dao.ColorDAO;
import dao.ProductDAO;
import dao.SizeDAO;
import model.Branch;
import model.BranchCategory;
import model.Category;
import model.Color;
import model.ProductInfo;
import model.Size;
import model.Stock;
import model.UploadProductComponent;
import service.UserService;

public class ProductController {
	private static ProductDAO<ProductInfo>productDAO;
	private static BranchDAO<Branch>branchDAO;
	private static CategoryDAO<Category>categoryDAO;
	private static ColorDAO<Color>colorDAO ;
	private static SizeDAO<Size>sizeDAO;
	private static BranchCategoryDAO<BranchCategory>bracateDAO;
	@SuppressWarnings("unchecked")
	public ProductController() throws InstanceNotFoundException {
		productDAO=(ProductDAO<ProductInfo>) Injector.getInstance("ProductDAOImpl");
		branchDAO=(BranchDAO<Branch>) Injector.getInstance("BranchImpl");
		categoryDAO=(CategoryDAO<Category>) Injector.getInstance("CategoryImpl");
		colorDAO=(ColorDAO<Color>) Injector.getInstance("ColorImpl");
		sizeDAO=(SizeDAO<Size>) Injector.getInstance("SizeImpl");
		bracateDAO=(BranchCategoryDAO<BranchCategory>) Injector.getInstance("BranchCategoryImpl");
	}
	public static void main(String[] args) throws InstanceNotFoundException  {
		ProductController controller=new ProductController();
		
		Object [][] data=controller.showproduct(1, 6, 2);
		for(Object[] i :data) {
			for(Object j :i) {
				System.out.print(j+"         ");
			}
			System.out.println();
		}
		
//		System.out.println(controller.totalproduct());
		
		//controller.saveproduct("Tatdabong","T001", "toẹt vời ko bk ns gi hon",420000, "none", 3, 2);
	}
	public Object[][] showproduct(int page,int rowcount,int sortoption) {
		List<Stock>list=ProductController.productDAO.findbypage((page-1)*rowcount,rowcount,sortoption);
		Object [][] result= new Object[rowcount][8];
		for(int i=0;i<rowcount;i++) {
			result[i][0]=(page-1)*rowcount+i+1;
			result[i][1]=list.get(i).getProductInfo().getName();
			result[i][2]=list.get(i).getProductInfo().getCode();
			result[i][3]=list.get(i).getProductInfo().getCurrentPrice();
			result[i][4]=list.get(i).getProductInfo().getBranchCategory().getCategory().getName();
			result[i][5]=list.get(i).getSize().getName();
			result[i][6]=list.get(i).getColor().getName();
			result[i][7]=list.get(i).getQuantity();
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
	public void saveproduct(String name ,String code ,String description,int currentprice,String  imgURl,int id_branch,int id_category) {
		List<BranchCategory>bracatelist=ProductController.bracateDAO.findall("BranchCategory");
		ProductInfo productInfo=new ProductInfo();
		BranchCategory branchCategory=new BranchCategory();
		int i=0;
		int bracatesize=bracatelist.size();
		while(i<bracatesize) {
			if(bracatelist.get(i).getBranch().getId()==id_branch && bracatelist.get(i).getCategory().getId()==id_category) {
				branchCategory.setId(bracatelist.get(i).getId());
				break;
			}
			i++;
		}
		if(i==bracatesize) {
			Branch branch= new Branch();
			branch.setId(id_branch);
			Category category=new Category();
			category.setId(id_category);
			branchCategory.setBranch(branch);
			branchCategory.setCategory(category);
			branchCategory.setId(bracatelist.get(bracatesize-1).getId());
		}
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
	public int[] listpage() {
		long result =ProductController.productDAO.total("ProductInfo");
		int totalpage=(int) (result/10+1);
		int listpage[]=new int[totalpage+1];
		for(int i=1;i<=totalpage;i++) {
			listpage[i]=i;
		}
		return listpage;
	}
//	public Stock showdetailproduct(int page,int rowcount,int checknum) {
//		int pos=
//	}
//	public Object[][] hello(int cot ,int hang,int page) throws InstanceNotFoundException{
//		productService=(ProductService) Injector.getInstance("ProductService");
//		List<Object[]>rows=new ArrayList<>();
//		rows=productService.findbypage(2, 3, "name");
//		Object [][] data=(Object[][]) new Object();
//		for(int i=0;i<cot;i++) {
//			for(int j=0;j<hang;j++) {
//				if(i==0) {
//					data[j][i]=(page-1)*cot+1+j;
//				}else {
//					Object row[]=rows.get(i-1);
//					
//					data[j][i]=(ProductInfo)row[1];
//				}
//			}
//		}
//		return data;
//	}
	
}
