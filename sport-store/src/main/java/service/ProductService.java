package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.InstanceNotFoundException;

import config.Injector;
import dao.BranchCategoryDAO;
import dao.BranchCategoryDAOImpl;
import dao.BranchDAO;
import dao.BranchDAOImpl;
import dao.CategoryDAO;
import dao.CategoryDAOImpl;
import dao.ColorDAO;
import dao.ColorDAOImpl;
import dao.ProductDAO;
import dao.ProductDAOImpl;
import dao.SizeDAO;
import dao.SizeDAOImpl;
import dao.StockDAO;
import dao.StockDAOImpl;
import model.Branch;
import model.BranchCategory;
import model.Category;
import model.Color;
import model.ProductInfo;
import model.Size;
import model.Stock;
import model.Checkstockproperty;
import model.UploadProductComponent;

public class ProductService {
		private static List<Stock>list=new ArrayList<Stock>();
		private ProductDAOImpl<ProductInfo>productDAOImpl;
		private List<Checkstockproperty>checkstoList;
		BranchDAOImpl<Branch>branchDAOImpl;
		CategoryDAOImpl<Category>categoryDAOImpl;
		SizeDAOImpl<Size>sizeDAOImpl;
		ColorDAOImpl<Color>colorDAOImpl;
		StockDAOImpl<Stock>stockDAOImpl ;
		BranchCategoryDAOImpl<BranchCategory>branchCategoryDAOImpl;
		public ProductService() {
			productDAOImpl=new ProductDAOImpl<ProductInfo>();
			branchDAOImpl=new BranchDAOImpl<Branch>();
			categoryDAOImpl=new CategoryDAOImpl<Category>();
			sizeDAOImpl=new SizeDAOImpl<Size>();
			colorDAOImpl=new ColorDAOImpl<Color>();
			stockDAOImpl=new StockDAOImpl<Stock>();
			branchCategoryDAOImpl=new BranchCategoryDAOImpl<BranchCategory>();
			checkstoList=new ArrayList<Checkstockproperty>();
		}
		
		public static void main(String[] args) throws InstanceNotFoundException  {
			ProductService productService=new ProductService();
			Object [][] data=productService.showproduct(1,10, 2);
			for(Object[] i :data) {
				for(Object j :i) {
					System.out.print(j+"         ");
				}
				System.out.println();
			}
			
			// cai ni la tren view 
			List<Integer>colorlist=new ArrayList<Integer>();
			List<Integer>sizelist=new ArrayList<Integer>();
			List<Integer>qtylist=new ArrayList<Integer>();
			colorlist.add(1);
			sizelist.add(3);
			
			colorlist.add(4);
			sizelist.add(1);
			
			colorlist.add(2);
			sizelist.add(3);
			
			qtylist.add(20);
			qtylist.add(10);
			qtylist.add(40);
			for(int i=0;i<colorlist.size();i++) {
				Checkstockproperty checksto=new Checkstockproperty();
				checksto.setIdStockColor(colorlist.get(i));
				checksto.setIdStockSize(sizelist.get(i));
				checksto.setStockQty(qtylist.get(i));
				productService.checkstoList.add(checksto);
			}
			
			//   tren view thi lam theo cai nay 
			ProductInfo productInfo=new ProductInfo();
			productInfo.setName("Loibo");
			productInfo.setCode("hello");
			productInfo.setDescription("none");
			productInfo.setCurrentPrice(200000);
			productInfo.setImgUrl("Ko bk");
			Branch branch=new Branch();
			Category category=new Category();
			branch.setId(2);
			category.setId(3);
			BranchCategory branchCategory=new BranchCategory();
			branchCategory.setBranch(branch);
			branchCategory.setCategory(category);
			productInfo.setBranchCategory(branchCategory);
			
			
			
			productInfo.setCreateDate(new Date());
			productInfo.setId(20);
			productService.deleteproduct(0);
//			productService.editproduct(productInfo);
			
//			UploadProductComponent result=controller.uploadproduct();
//			System.out.println(result.getBranch().get(0).getName());
//			int id=ProductController.bracateDAO.findbybracate( 2, 3);
//			System.out.println(id);
//			System.out.println(controller.totalproduct());
			
			//controller.saveproduct("Tatdabong","T001", "toẹt vời ko bk ns gi hon",420000, "none", 3, 2);
		
		}
		public Object[][] showproduct(int page,int rowcount,int sortoption) {
			list=productDAOImpl.findbypage((page-1)*rowcount,rowcount,sortoption);
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
		// tra 1001 tuc la co du lieu bi trung vs nho check stockIdlist.size !=0 thi ms cho luu
		public int addstockproperty(Checkstockproperty checksto) {
			for(int i=0;i<checkstoList.size();i++) {
				if(checkstoList.get(i).equals(checksto)) {
					return 1001;
				}
			}
			checkstoList.add(checksto);
			return 1000;
		}
		//xoa mot hang color va size
		public int deletestockproperty(Checkstockproperty checksto) {
			checkstoList.remove(checksto);
			return 1000;
		}
		
		public UploadProductComponent uploadproduct() {
			List<Branch>branches=branchDAOImpl.findall("Branch");
			List<Category>categories=categoryDAOImpl.findall("Category");
			List<Color>colors=colorDAOImpl.findall("Color");
			List<Size>sizes=sizeDAOImpl.findall("Size");
			UploadProductComponent results =new UploadProductComponent(branches, categories, colors, sizes);
			return results;
		}
		//neu tk nay tra ra khac 0 thi chon san Branch va Category
//		public int checkexistproduct(String code) {
//			List<ProductInfo>list=productDAO.findbyproperty("code",code,"ProductInfo");
//			if(list.size()!=0 && !list.isEmpty()) {
//				return list.get(0).getId();
//			}
//			return 0;
//		}
		public int saveproduct(ProductInfo productInfo) {
			List<ProductInfo>result=productDAOImpl.findbyproperty("code", productInfo.getCode(), "ProductInfo");
			if(result.size()!=0 && !result.isEmpty()) {
				return 1001;
			}
			Stock stock=new Stock();
			int id_pro=productDAOImpl.nextid("product_info");
			int id_branch=productInfo.getBranchCategory().getBranch().getId();
			int id_category=productInfo.getBranchCategory().getCategory().getId();
			int id_bracate=branchCategoryDAOImpl.findbybracate(id_branch,id_category);
			productInfo.getBranchCategory().setId(id_bracate);
//			productInfo.setName(name);
//			productInfo.setCode(code);
//			productInfo.setDescription(description);
//			productInfo.setCurrentPrice(currentprice);
//			productInfo.setImgUrl(imgURl);
			productInfo.setActiveFlag(1);
			productInfo.setCreateDate(new Date());
			productInfo.setUpdateDate(new Date());
			// nhớ check 3 compokey trùng nhau mà check trên java thôi đc rồi
			int id_color,id_size,quantity;
			try {
				productDAOImpl.save(productInfo);
				for(int i=0;i<checkstoList.size();i++) {
					id_color=checkstoList.get(i).getIdStockColor();
					id_size=checkstoList.get(i).getIdStockSize();
					quantity=checkstoList.get(i).getStockQty();
					stockDAOImpl.savestock(id_pro, id_color, id_size, quantity);
				}
				checkstoList.clear();
				return 1000;
			}catch(Exception e) {
				System.out.println("Exception caught : Error while saving product");
				return 1002;
			}		
		}
		
		public int editproduct(ProductInfo productInfo) {
			//code ko thay doi dc vi la edit ma 
			int id_branch=productInfo.getBranchCategory().getBranch().getId();
			int id_category=productInfo.getBranchCategory().getCategory().getId();
			int id_bracate=branchCategoryDAOImpl.findbybracate(id_branch,id_category);
			productInfo.getBranchCategory().setId(id_bracate);
			productInfo.setUpdateDate(new Date());
			Stock stock=new Stock();
			//xoa trong stock roi moi them vo lai 
			try {
				productDAOImpl.update(productInfo);
				Color color=new Color();
				Size size=new Size();
				ProductInfo pro=new ProductInfo();
//				for(int i=0;i<checkstoList.size();i++) {
//					color.setId(checkstoList.get(i).getIdStockColor());
//					size.setId(checkstoList.get(i).getIdStockSize());
//					stock.setColor(color);
//					stock.setSize(size);
//					stock.setProductInfo(pro);
//					stock.setStockQuantity(checkstoList.get(i).getStockQty());
//					stock.setProductInfo(productInfo);
//					stockDAOImpl.save(stock);
//				}
				return 1000;
			}catch(Exception e) {
				System.out.println("Exception caught : Error while saving product");
				return 1002;
			}
		}
		public int deleteproduct(int index) {
			try {
				Stock stock =list.get(index);
				stock.setStockActiveflag(0);
				stockDAOImpl.update(stock);
				return 1000;
			}catch(Exception e) {
				System.out.println("Exception caught : Error while delecting product");
				return 1002;
			}
		}
		
	
		public Integer[] listpage() {
			long result =stockDAOImpl.total("Stock");
			int totalpage;
			if(result%2==0) {
				totalpage=(int)result/4;
			}else {
				totalpage=(int)result/4+1;
			}
			Integer listpage[]=new Integer[totalpage];
			for(int i=0;i<totalpage;i++) {
				listpage[i]=i+1;
			}
			return listpage;
		}
		public long totaldata() {
			long result =stockDAOImpl.total("Stock");
			return result;
		}
}
