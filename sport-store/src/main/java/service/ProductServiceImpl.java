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
import mix.Myexception;
import model.Branch;
import model.BranchCategory;
import model.Category;
import model.Color;
import model.ProductInfo;
import model.Size;
import model.Stock;
import model.Checkstockproperty;
import model.UploadProductComponent;

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

		public void addstockproperty(Checkstockproperty checksto) throws Myexception {
			for(int i=0;i<checkstoList.size();i++) {
				if(checkstoList.get(i).equals(checksto)) {
					throw new Myexception("Existed Size and Color in table");
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
		public void saveproduct(ProductInfo productInfo) throws Myexception {
			List<ProductInfo>result=productDAOImpl.findbyproperty("code", productInfo.getCode());
			if(result.size()!=0 && !result.isEmpty()) {
				throw new Myexception("Ma code da ton tai");
			}
			int id_pro=productDAOImpl.nextid("product_info");
			int id_branch=productInfo.getBranchCategory().getBranch().getId();
			int id_category=productInfo.getBranchCategory().getCategory().getId();
			int id_bracate=branchCategoryDAOImpl.findbybracate(id_branch,id_category);
			productInfo.getBranchCategory().setId(id_bracate);
			productInfo.setActiveFlag(1);
			productInfo.setCreateDate(new Date());
			productInfo.setUpdateDate(new Date());
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
