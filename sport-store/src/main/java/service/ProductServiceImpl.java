package service;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;




import dao.BranchCategoryDAOImpl;

import dao.BranchDAOImpl;

import dao.CategoryDAOImpl;
import dao.ColorDAOImpl;
import dao.ProductDAOImpl;
import dao.SizeDAOImpl;
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

public class ProductServiceImpl implements ProductService{
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
		public ProductServiceImpl() {
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
		
		public static void main(String[] args)  {
			ProductServiceImpl productService=new ProductServiceImpl();
//			for(int i=0;i<productService.getstolist.size();i++) {
//				productService.getstolist.get(i).toString();
//			}
			
			Object [][] data=productService.showproduct(1,10, 2);
			for(Object[] i :data) {
				for(Object j :i) {
					System.out.print(j+"         ");
				}
				System.out.println();
			}
			
			
//			try {
//				productService.deleteproduct(1);
//			} catch (Myexception e) {
//				System.out.println(e);
//			}
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
//			ProductInfo productInfo=productService.productDAOImpl.findbyId(ProductInfo.class,21);
//			productInfo.setName("cuongvip");
//			List<Integer>colorlist=new ArrayList<Integer>();
//			List<Integer>sizelist=new ArrayList<Integer>();
//			List<Integer>qtylist=new ArrayList<Integer>();
//			colorlist.add(1);
//			sizelist.add(3);
//			
//			colorlist.add(4);
//			sizelist.add(1);
//			
//			colorlist.add(2);
//			sizelist.add(3);
//			
//			colorlist.add(1);
//			sizelist.add(2);
//			
//			qtylist.add(100);
//			qtylist.add(100);
//			qtylist.add(100);
//			qtylist.add(100);
//			for(int i=0;i<colorlist.size();i++) {	
//				Checkstockproperty checksto=new Checkstockproperty();
//				checksto.setIdStockColor(colorlist.get(i));
//				checksto.setIdStockSize(sizelist.get(i));
//				checksto.setStockQty(qtylist.get(i));
//				checksto.setIdStockPro(21);
//				productService.checkstoList.add(checksto);
//			}
//			productService.findstodata(21);
			
			
			
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
			
			
//			try {
//				productService.editproduct(productInfo);
//			} catch (Myexception e) {
//				System.out.println(e);
//			}
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
			String colorname,sizename;
			int id_stock,id_color,id_size,qty,activeflag,i=0;
			int id_pro=prolist.get(index).getId();
			List<Stock> prodetails=stockDAOImpl.findbyidpro(id_pro,false);
			List list=new ArrayList<>();
			
			for( Stock value :prodetails) {
				colorname=value.getColor().getName();
				sizename=value.getSize().getName();
				qty=value.getStockQuantity();
				id_stock=value.getIdStock();
				id_color=value.getColor().getId();
				id_size=value.getSize().getId();
				activeflag=value.getStockActiveflag();
				Checkstockproperty checksto=new Checkstockproperty(id_stock,id_size,id_color,qty);
				getstolist.add(checksto);
				if(activeflag==1) {
					checkstoList.add(checksto);
					list.add(colorname);
					list.add(sizename);
					list.add(qty);
				}
			}
			Object [][] result= new Object[list.size()/3][3];
			for( i=0;i<list.size()/3;i++) {
				result[i][0]=list.get(i*3);
				result[i][1]=list.get(i*3+1);
				result[i][2]=list.get(i*3+2);
			}
			return result;
		}
//		public void findstodata(int index) {
//			int id_pro=prolist.get(index).getId();
//			List<Stock> result=stockDAOImpl.findbyidpro(id_pro);
//			for(int i=0;i<result.size();i++) {
//			Checkstockproperty checksto=new Checkstockproperty((int)result.get(i)[0],index,(int)result.get(i)[2],(int) result.get(i)[1]);
//				Checkstockproperty checksto=new Checkstockproperty(result.get(i).getIdStock(),result.get(i).getProductInfo().getId(),result.get(i).getSize().getId(),result.get(i).getColor().getId());
//				getstolist.add(checksto);
//			}
//		}
		public void addstockproperty(Checkstockproperty checksto) throws Myexception {
			for(int i=0;i<checkstoList.size();i++) {
				if(checkstoList.get(i).equals(checksto)) {
					throw new Myexception("Size va Color da ton tai trong bang");
				}
			}
			checkstoList.add(checksto);
		}
		public void deletestockproperty(int  index) {
			checkstoList.remove(index);
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
			productInfo.setUpdateDate(new Date());
			productInfo.setActiveFlag(1);
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
				stockDAOImpl.deletestock(productInfo.getId());
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
		public List<Checkstockproperty>getstolist(){
			return getstolist;
		}
		public List<Checkstockproperty>getcheckstolist(){
			return checkstoList;
		}
}
