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
import model.BillProductId;
import model.ProductInfo;
import model.Stock;
import model.User;
import validate.DateValidator;
import validate.Myexception;

public class BillService {
	private static BillDAOImpl billDAOImpl;
	private static StockDAOImpl stockDAOImpl;
	private static ProductDAOImpl productDAOImpl;
	private static List<Object[]> showlist=new ArrayList<Object[]>();
	private static int nextidbill=0;
	private Set<Billdetail> billdetails;
	@SuppressWarnings("unchecked")
	public BillService() throws InstanceNotFoundException {
		billDAOImpl=new BillDAOImpl(Bill.class);
		stockDAOImpl=new StockDAOImpl(Stock.class);
		productDAOImpl=new ProductDAOImpl(ProductInfo.class);
		nextidbill=billDAOImpl.nextid("bill");
		billdetails=new HashSet<Billdetail>();
	}
	public static void main(String[] args) throws InstanceNotFoundException {
		BillService BillService=new BillService();
//		BillService.addproduct();
//		BillService.savebill();
	//	BillService.showbill();
	//	BillService.showbilldetail();
		
		
		Object [][] data=BillService.showbill(0, 9999999, "2019/01/01", "2021/01/01");
		for(Object[] i :data) {
			for(Object j :i) {
				System.out.print(j+"         ");
			}
			System.out.println();
		}
		Object [][] datas=BillService.showbilldetail(1);
		for(Object[] i :datas) {
			for(Object j :i) {
				System.out.print(j+"         ");
			}
			System.out.println();
		}
		//add bill detail and save bill
		Set<Billdetail>billdetails=new HashSet<Billdetail>();
		Checkstockproperty checkstockproperty=new Checkstockproperty(1,3,1);
		Checkstockproperty checkstockproperty2=new Checkstockproperty(1,3,2);
		try {
			BillService.addproduct("AoJuve", checkstockproperty);
			BillService.addproduct("AoBayer", checkstockproperty2);
			System.out.println(billdetails.size());
		}catch(Myexception e) {
			System.out.println(e);
		}
//		
//		try {
//			BillService.savebill("cuongprolt", billdetails);
//		} catch (Myexception e) {
//			System.out.println(e);
//		
//		}
	//	BillService.deletebill();
	}
		public void savebill(String code ) throws Myexception {
			List<Bill>bills=billDAOImpl.findbyproperty("code", code);
			if(bills.isEmpty()) {
				Bill bill=new Bill();
				User user=new User();
				user.setId(2);
			//	user.setId(UserService.storeuser.getId());
				// code vs des lay tu view.gettext
				
				String description ="Ghi dai cai chi cx dctrt";
				bill.setCode(code);
				bill.setId(nextidbill);
				bill.setCreateDate(new Date());
				bill.setUser(user);
//loi				bill.setBillProducts(billProducts);
				bill.setDescription(description);
				bill.setBilldetails(billdetails);
			//	System.out.println(bill.getBilldetails().size());
				BillService.billDAOImpl.save(bill);
			}else {
				throw new Myexception("Ma bill da ton tai .Vui long nhap lai. \n");
			}		
		}
		
		
		public void addproduct(String code,Checkstockproperty checksto) throws Myexception {
			List<ProductInfo>products=productDAOImpl.findbyproperty("code", code);
			if(products.size()!=0 && !products.isEmpty() &&products.get(0).getActiveFlag()==1) {
				int id_pro=products.get(0).getId();
				checksto.setIdStockPro(id_pro);
				int id_stock=stockDAOImpl.checkexiststockcompokey(id_pro,checksto.getIdStockColor(), checksto.getIdStockSize(),checksto.getStockQty());
				if(id_stock!=0) {
					Billdetail billdetail=new Billdetail();
					BilldetailId billdetailId=new BilldetailId();
					billdetailId.setBilldetailPrice(products.get(0).getCurrentPrice());
					billdetailId.setBilldetailQuantity(checksto.getStockQty());
					billdetailId.setIdBilldetailBill(nextidbill);
					billdetailId.setIdBilldetailStock(id_stock);
					billdetail.setId(billdetailId);
					billdetails.add(billdetail);
				}else {
					throw new Myexception("Product is not avalable in stock or your request quantity is too much \n");
				}
			}else {
					throw new Myexception("Your product code is wrong");
			}
		}
		
		public void cancel() {
			//xoa toan bo product ra khoi list billproduct
			//tren view thi xoa het nx gi user da ghi
		}
		
		public Object[][] showbill(int mintotal,int maxtotal,String mindate,String maxdate) {
//			Date date=new Date();
//			SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			DateValidator dateValidator=new DateValidator();
			//Gan gia tri mac dinh 
			// doan nay la de lay du lieu tren view
			
//			do {
//				//cho nhap ngay thang vo
//				dateValidator.isValid(maxdate);
//			}while(!check);
			
			showlist =billDAOImpl.findbytotal(mintotal,maxtotal,mindate,maxdate);
//			System.out.println(showlist.get(1)[5].toString());
//			System.out.println(showlist.get(1)[6].toString());
			
			Object [][] result= new Object[showlist.size()][6];
			for(int i=0;i<showlist.size();i++) {
				result[i][0]=i+1;
				result[i][1]=showlist.get(i)[1].toString();
				result[i][2]=showlist.get(i)[8].toString();
				result[i][3]=showlist.get(i)[5].toString();
				result[i][4]=showlist.get(i)[6].toString();
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
//			System.out.println(billdetails.get(0)[2].toString()+" "+billdetails.get(0)[3].toString());
			return result;
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