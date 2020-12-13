package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.InstanceNotFoundException;

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
import validate.Myexception;

public class ProductService {
		private List<Stock>list=new ArrayList<Stock>();
		private List<ProductInfo>prolist;
		private ProductDAOImpl productDAOImpl;
		private List<Checkstockproperty>checkstoList;
		private List<Checkstockproperty>getstolist;
		BranchDAOImpl branchDAOImpl;
		CategoryDAOImpl categoryDAOImpl;
		SizeDAOImpl sizeDAOImpl;
		ColorDAOImpl colorDAOImpl;
		StockDAOImpl stockDAOImpl ;
		BranchCategoryDAOImpl branchCategoryDAOImpl;
		public ProductService() {
			productDAOImpl=new ProductDAOImpl(ProductInfo.class);
			branchDAOImpl=new BranchDAOImpl(Branch.class);
			categoryDAOImpl=new CategoryDAOImpl(Category.class);
			sizeDAOImpl=new SizeDAOImpl(Size.class);
			colorDAOImpl=new ColorDAOImpl(Color.class);
			stockDAOImpl=new StockDAOImpl(Stock.class);
			branchCategoryDAOImpl=new BranchCategoryDAOImpl(BranchCategory.class);
			checkstoList=new ArrayList<Checkstockproperty>();
			prolist=new ArrayList<ProductInfo>();
			getstolist=new ArrayList<Checkstockproperty>();
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
			try {
				productService.deleteproduct(1);
			} catch (Myexception e) {
				System.out.println(e);
			}
		/*	
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
			
	//		productService.deleteproduct(0);
//			productService.editproduct(productInfo);
			
			UploadProductComponent result=productService.uploadproduct();
			System.out.println(result.getSizenum().size()+" "+result.getSizechar().size());
			System.out.println(result.getSizechar().get(3).getName());
//			int id=ProductController.bracateDAO.findbybracate( 2, 3);
//			System.out.println(id);
//			System.out.println(controller.totalproduct());
			
			//controller.saveproduct("Tatdabong","T001", "toẹt vời ko bk ns gi hon",420000, "none", 3, 2);
		*/
			
			
			// edit product
			ProductInfo productInfo=productService.productDAOImpl.findbyId(ProductInfo.class,21);
			productInfo.setName("cuongvip");
			List<Integer>colorlist=new ArrayList<Integer>();
			List<Integer>sizelist=new ArrayList<Integer>();
			List<Integer>qtylist=new ArrayList<Integer>();
			colorlist.add(1);
			sizelist.add(3);
			
			colorlist.add(4);
			sizelist.add(1);
			
			colorlist.add(2);
			sizelist.add(3);
			
			colorlist.add(1);
			sizelist.add(2);
			
			qtylist.add(100);
			qtylist.add(100);
			qtylist.add(100);
			qtylist.add(100);
			for(int i=0;i<colorlist.size();i++) {	
				Checkstockproperty checksto=new Checkstockproperty();
				checksto.setIdStockColor(colorlist.get(i));
				checksto.setIdStockSize(sizelist.get(i));
				checksto.setStockQty(qtylist.get(i));
				checksto.setIdStockPro(21);
				productService.checkstoList.add(checksto);
			}
			productService.findstodata(21);
//			int count=0;
//			for( int i=0;i<productService.checkstoList.size();i++) {
//				for( int j=count;j<productService.getstolist.size();j++) {
//					if(productService.checkstoList.get(i).equals(productService.getstolist.get(j))) {
//						System.out.println(productService.checkstoList.get(i).getStockQty());
//						count++;
//					}
//				}
//				}
//			System.out.println(count);
//			for(int j=count;j<=productService.getstolist.size();j++) {
//				System.out.println(j);
//			}
			
			
			try {
				productService.editproduct(productInfo);
			} catch (Myexception e) {
				System.out.println(e);
			}
		}
		public Object[][] showproduct(int page,int rowcount,int sortoption) {
			prolist=productDAOImpl.findbypage((page-1)*rowcount,rowcount,sortoption);
			Object [][] result= new Object[prolist.size()][9];
			for(int i=0;i<prolist.size();i++) {
				result[i][0]=(page-1)*rowcount+i+1;
				result[i][1]=prolist.get(i).getName();
				result[i][2]=prolist.get(i).getCode();
				result[i][3]=prolist.get(i).getCurrentPrice();
				result[i][4]=prolist.get(i).getBranchCategory().getCategory().getName();
				result[i][5]=prolist.get(i).getCreateDate();
				result[i][6]=prolist.get(i).getUpdateDate();
				result[i][7]=prolist.get(i).getDescription();
				if(prolist.get(i).getActiveFlag()==1) result[i][8]="Valid";
				else result[i][8]="Invalid";
			}
			return result;
		}
		public Object[][] showdetail(int index) {
			int id_pro=prolist.get(index).getId();
			List<Object[]> prodetails=stockDAOImpl.findbyidpro(id_pro);
			Object [][] result= new Object[prodetails.size()][3];
			for(int i=0;i<prodetails.size();i++) {
				result[i][0]=prodetails.get(i)[3].toString();
				result[i][1]=prodetails.get(i)[4].toString();
				result[i][2]=prodetails.get(i)[5].toString();
			}
			return result;
		}
		public void findstodata(int index) {
		//	int id_pro=prolist.get(index).getId();
			List<Object[]> result=stockDAOImpl.findbyidpro(index);
			for(int i=0;i<result.size();i++) {
				Checkstockproperty checksto=new Checkstockproperty((int)result.get(i)[0],index,(int)result.get(i)[2],(int) result.get(i)[1]);
				getstolist.add(checksto);
			}
		}
		// tra 1001 tuc la co du lieu bi trung vs nho check stockIdlist.size !=0 thi ms cho luu
		public void addstockproperty(Checkstockproperty checksto) throws Myexception {
			for(int i=0;i<checkstoList.size();i++) {
				if(checkstoList.get(i).equals(checksto)) {
					throw new Myexception("Size va Color da ton tai trong bang");
				}
			}
			checkstoList.add(checksto);
		}
		//xoa mot hang color va size
		public int deletestockproperty(int  index) {
			checkstoList.remove(index);
			return 1000;
		}
		
		public UploadProductComponent uploadproduct() {
			List<Branch>branches=branchDAOImpl.findall();
			List<Category>categories=categoryDAOImpl.findall();
			List<Color>colors=colorDAOImpl.findall();
			List<Size>sizes=sizeDAOImpl.findall();
			List<Size>sizesnum=new ArrayList<Size>();
			List<Size>sizeschar=new ArrayList<Size>();
			for(int i=0;i<sizes.size();i++) {
				try {
					Integer.parseInt(sizes.get(i).getName());
					sizesnum.add(sizes.get(i));
				}catch(NumberFormatException nfe) {
					sizeschar.add(sizes.get(i));
				}
			}
			UploadProductComponent results =new UploadProductComponent(branches, categories, colors, sizesnum,sizeschar);
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
		public void saveproduct(ProductInfo productInfo) throws Myexception {
			List<ProductInfo>result=productDAOImpl.findbyproperty("code", productInfo.getCode());
			if(result.size()!=0 && !result.isEmpty()) {
				throw new Myexception("Ma code da ton tai");
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
			}catch(Exception e) {
				throw new Myexception("Error while saving product");
			}
		}
		
		
		/// chi edit dc name ,des,price,
		public void editproduct(ProductInfo productInfo) throws Myexception {
			int id_branch=productInfo.getBranchCategory().getBranch().getId();
			int id_category=productInfo.getBranchCategory().getCategory().getId();
			int id_bracate=branchCategoryDAOImpl.findbybracate(id_branch,id_category);
			productInfo.getBranchCategory().setId(id_bracate);
			productInfo.setUpdateDate(new Date());
			int id_color,id_size,quantity,id_stock, id_pro,i,j;
			boolean check;
			try {
				productDAOImpl.update(productInfo);
				for( i=0;i<checkstoList.size();i++) {
					check=false;
					for( j=0;j<getstolist.size();j++) {
						if(checkstoList.get(i).equals(getstolist.get(j))) {
							quantity=checkstoList.get(i).getStockQty();
							id_stock=getstolist.get(j).getIdStock();
							stockDAOImpl.updatestock(quantity,id_stock,1);
							getstolist.remove(j);
							check=true;
							break;
						}
					}
					if(check==false) {
						id_pro=productInfo.getId();
						id_color=checkstoList.get(i).getIdStockColor();
						id_size=checkstoList.get(i).getIdStockSize();
						quantity=checkstoList.get(i).getStockQty();
						stockDAOImpl.savestock(id_pro, id_color, id_size, quantity);
					}
				}
				for(j=0;j<getstolist.size();j++) {
					id_stock=getstolist.get(j).getIdStock();
					stockDAOImpl.updatestock(0, id_stock, 0);
				}
			}catch(Exception e) {
				throw new Myexception("Error while saving product");
			}
		}
		
		
		public void deleteproduct(int index) throws Myexception {
			ProductInfo productInfo=prolist.get(index);
			productInfo.setActiveFlag(0);
			try {
				productDAOImpl.update(productInfo);
			}catch(Exception e) {
				throw new Myexception("Error while delecting product...");
			}
		}
		
	
		public Integer[] listpage() {
			long result =productDAOImpl.total();
			int totalpage;
			if(result%4==0) {
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
			long result =productDAOImpl.total();
			return result;
		}
		public List<ProductInfo>getprolist(){
			return prolist;
		}
		public List<Checkstockproperty>getcheckstolist(){
			return checkstoList;
		}
}
