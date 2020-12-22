package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.management.InstanceNotFoundException;

import dao.BillDAO;
import dao.BillDAOImpl;
import dao.ProductDAO;
import dao.ProductDAOImpl;
import dao.StockDAO;
import dao.StockDAOImpl;
import model.Bill;
import model.Billdetail;
import model.BilldetailId;
import model.Checkstockproperty;
import model.Color;
import model.BillProductId;
import model.ProductInfo;
import model.Size;
import model.Stock;
import model.UploadProductComponent;
import model.User;
import validate.Algorithm;
import validate.DateValidator;
import validate.Myexception;

public class BillServiceImpl implements BillService{
	private static BillDAOImpl billDAOImpl;
	private static StockDAOImpl stockDAOImpl;
	private static ProductDAOImpl productDAOImpl;
	private static List<Object[]> showlist=new ArrayList<Object[]>();
	private List<Stock>stocks;
	private Set<Billdetail> billdetails;
	@SuppressWarnings("unchecked")
	public BillServiceImpl() {
		billDAOImpl=new BillDAOImpl(Bill.class);
		stockDAOImpl=new StockDAOImpl(Stock.class);
		productDAOImpl=new ProductDAOImpl(ProductInfo.class);
		billdetails=new HashSet<Billdetail>();
		stocks=new ArrayList<Stock>();
	}
	public static void main(String[] args) {
		BillServiceImpl BillService=new BillServiceImpl();
		
		
//		Object [][] data=BillService.showbill(0, 9999999, "2019/01/01", "2021/01/01");
//		for(Object[] i :data) {
//			for(Object j :i) {
//				System.out.print(j+"         ");
//			}
//			System.out.println();
//		}
		
		
//		Object [][] datas=BillService.showbilldetail(1);
//		for(Object[] i :datas) {
//			for(Object j :i) {
//				System.out.print(j+"         ");
//			}
//			System.out.println();
//		}
		
		//add bill detail and save bill

//		Checkstockproperty checkstockproperty=new Checkstockproperty(1,3,1);
//		Checkstockproperty checkstockproperty2=new Checkstockproperty(3,2,1);
//		try {
//			BillService.addproduct("AoJuve", checkstockproperty2);
//			BillService.addproduct("AoJuve", checkstockproperty);
//			BillService.addproduct("AoBayer", checkstockproperty);
//			System.out.println(BillService.billdetails.size());
//		}catch(Myexception e) {
//			System.out.println(e);
//		}
		
//		try {
//			BillService.savebill("cuongprolt", "hello man ");
//		} catch (Myexception e) {
//			System.out.println(e);
//		
//		}
	//	BillService.deletebill();
		
		//thuat toan 
		Object [][] data=BillService.findprintedbill();
		for(Object[] i :data) {
			for(Object j :i) {
				System.out.print(j+"         ");
			}
			System.out.println();
		}
		
		
		
//		try {
//			List<Stock> stocks=BillService.checkprocode("AoJuve");
//			for(Stock value :stocks) {
//				System.out.println(value.getColor().getName()+" "+value.getSize().getName()+" "+value.getIdStock());
//			}
//			BillService.addproduct(2, 3);
//			BillService.addproduct(1, 2);
//			BillService.savebill("qwert","none",1);
//		} catch (Myexception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		
	}
		public void savebill(String code,String description,int status ) throws Myexception {
			List<Bill>bills=billDAOImpl.findbyproperty("code", code);
			if(bills.isEmpty()) {
				int nextidbill=billDAOImpl.nextid("bill");
				Bill bill=new Bill();
				User user=UserServiceImpl.storeuser;
			//	user.setId(UserService.storeuser.getId());
				// code vs des lay tu view.gettext
				bill.setCode(code);
				bill.setBillStatus(status);
				bill.setId(nextidbill);
				bill.setCreateDate(new Date());
				bill.setUser(user);
				bill.setDescription(description);
				bill.setBilldetails(billdetails);
				BillServiceImpl.billDAOImpl.save(bill);
			}else {
				throw new Myexception("Bill code has already existed! \n");
			}		
		}
		public List<Stock>getstocks(){
			return stocks;
		}
		public List<Stock> checkprocode(String code) throws Myexception {
			List<ProductInfo>products=productDAOImpl.findbyproperty("code", code);
			if(products.size()!=0 && !products.isEmpty() &&products.get(0).getActiveFlag()==1) {
				int id_pro=products.get(0).getId();
				List<Object[]>result=stockDAOImpl.findstoinfo(id_pro);
				for(int i=0;i<result.size();i++) {
					Color color=new Color();
					Size size=new Size();
					Stock stock=new Stock();
					color.setName(result.get(i)[1].toString());
					size.setName(result.get(i)[2].toString());
					stock.setProductInfo(products.get(0));
					stock.setIdStock(Integer.parseInt(result.get(i)[0].toString()));
					stock.setStockQuantity(Integer.parseInt(result.get(i)[3].toString()));
					stock.setColor(color);
					stock.setSize(size);
					stocks.add(stock);
				}
				for(Stock value :stocks) {
					System.out.println(value.getColor().getName()+" "+value.getSize().getName()+" "+value.getIdStock());
				}
				return stocks;
			}else {
				throw new Myexception("Your product code is wrong");
			}
		}
		
		public void addproduct(int index,int qty) throws Myexception {
				Stock stock=stocks.get(index);
				for(Billdetail value :billdetails) {
					if(value.getId().getIdBilldetailStock()==stock.getIdStock()) throw new Myexception("Information of product is duplicate!");
				}
				if(stock.getStockQuantity()>=qty && qty>0) {
					int nextidbill=billDAOImpl.nextid("bill");
					Billdetail billdetail=new Billdetail();
					BilldetailId billdetailId=new BilldetailId();
					billdetailId.setBilldetailPrice(stocks.get(0).getProductInfo().getCurrentPrice());
					billdetailId.setBilldetailQuantity(qty);
					billdetailId.setIdBilldetailBill(nextidbill);
					billdetailId.setIdBilldetailStock(stocks.get(index).getIdStock());
					billdetail.setId(billdetailId);
					billdetails.add(billdetail);
					stocks.clear();
				}else {
					throw new Myexception("Product is not avalable in stock or your request quantity is too much \n");
				}
			
		}
		
		
		public Object[][] showbill(int mintotal,int maxtotal,String mindate,String maxdate) {
			showlist =billDAOImpl.findbytotal(mintotal,maxtotal,mindate,maxdate);
			Object [][] result= new Object[showlist.size()][6];
			for(int i=0;i<showlist.size();i++) {
				result[i][0]=i+1;
				result[i][1]=showlist.get(i)[1].toString();
				result[i][2]=showlist.get(i)[9].toString();
				result[i][3]=showlist.get(i)[6].toString();
				result[i][4]=showlist.get(i)[7].toString();
				result[i][5]=showlist.get(i)[2].toString();
				}
			return result;
		}
		public Object[][] showbilldetail(int index) {
			int id_bill=(int) showlist.get(index)[0];
			List<Object[]>billdetails=billDAOImpl.findbilldetail(id_bill);
			Object [][] result= new Object[billdetails.size()][8];
			for(int i=0;i<billdetails.size();i++) {
				result[i][0]=i+1;
				result[i][1]=billdetails.get(i)[0].toString();
				result[i][2]=billdetails.get(i)[1].toString();
				result[i][3]=billdetails.get(i)[2].toString();
				result[i][4]=billdetails.get(i)[3].toString();
				result[i][5]=billdetails.get(i)[4].toString();
				result[i][6]=billdetails.get(i)[5].toString();
				result[i][7]=Integer.parseInt(billdetails.get(i)[4].toString())*Integer.parseInt(billdetails.get(i)[5].toString());
			}
			return result;
		}
		
		public Object[][] findprintedbill() {
			List<Object[]>result=billDAOImpl.findprintedbill();
			String billcode[]=new String[result.size()+1];
			int qty[]=new int[result.size()+1],value[]=new int[result.size()+1];
			for(int i=1;i<=result.size();i++) {
				billcode[i]=(String) result.get(i-1)[0];
				qty[i]=Integer.parseInt(result.get(i-1)[1].toString());
				value[i]=Integer.parseInt(result.get(i-1)[2].toString());
			}
			Algorithm algorithm=new Algorithm(qty,value);
			List<Integer>resultlist=algorithm.cal();
			Object [][]data=new Object[resultlist.size()][3];
			for(int i=0;i<resultlist.size();i++) {
				data[i][0]=billcode[resultlist.get(i)];
				data[i][1]=qty[resultlist.get(i)];
				data[i][2]=value[resultlist.get(i)];
			}
			return data;
		}
		
		public void deletebill(int index) throws Myexception {
			int id_bill=(int)showlist.get(index)[0];
			Bill bill=billDAOImpl.findbyId(Bill.class,id_bill);
			try {
				billDAOImpl.delete(bill);
			}catch(Exception e) {
				throw new Myexception("Error while deleting Bill!");
			}
			
		}
		public  List<Object[]> getshowbill(){
			return showlist;
		}
}