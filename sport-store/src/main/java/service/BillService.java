package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.management.InstanceNotFoundException;

import config.Injector;
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
	private static BillDAOImpl<Bill>billDAOImpl;
	private static StockDAOImpl<Stock>stockDAOImpl;
	private static ProductDAOImpl<ProductInfo>productDAOImpl;
	private static Set<Billdetail>billdetails=new HashSet<Billdetail>();
	private static List<Object[]> showlist=new ArrayList<Object[]>();
	private static int maxbill=0;
	@SuppressWarnings("unchecked")
	public BillService() throws InstanceNotFoundException {
		billDAOImpl=new BillDAOImpl<Bill>();
		stockDAOImpl=new StockDAOImpl<Stock>();
		productDAOImpl=new ProductDAOImpl<ProductInfo>();
		maxbill=billDAOImpl.nextid("bill");
	}
	public static void main(String[] args) throws InstanceNotFoundException {
		BillService BillService=new BillService();
//		BillService.addproduct();
//		BillService.savebill();
	//	BillService.showbill();
	//	BillService.showbilldetail();
		Object [][] data=BillService.showbilldetail();
		for(Object[] i :data) {
			for(Object j :i) {
				System.out.print(j+"         ");
			}
			System.out.println();
		}
//		if(BillService.stockDAOImpl.checkexiststockcompokey(1,3,1,1)!=0) {
//			System.out.println("Oke");
//		}else {
//			System.out.println("error");
//		}
		Checkstockproperty checkstockproperty=new Checkstockproperty(1,3,1,10);
		try {
			BillService.addproduct("AoJuve", checkstockproperty);
			System.out.println(billdetails.size());
		}catch(Myexception e) {
			System.out.println(e);
		}
	
		
	}
		public void savebill() {
			String code="cuongprolt";
			List<Bill>bills=billDAOImpl.findbyproperty("code", code, "Bill");
			if(bills.isEmpty()) {
				Bill bill=new Bill();
				Date date=new Date();
				//User user=LoginController.storeuser;
				User user=new User();
				user.setId(2);
				// code vs des lay tu view.gettext
				
				String description ="Ghi dai cai chi cx dctrt";
				bill.setCode(code);
				bill.setId(6);
				bill.setCreateDate(date);
				bill.setUser(user);
//loi				bill.setBillProducts(billProducts);
				bill.setDescription(description);
				BillService.billDAOImpl.save(bill);
			}else {
				System.out.println("Ma bill da ton tai .Vui long nhap lai. \n");
			}		
		}
		
		
		public void addproduct(String code,Checkstockproperty checksto) throws Myexception {
			List<ProductInfo>products=productDAOImpl.findbyproperty("code", code, "ProductInfo");
			if(products.size()!=0 && !products.isEmpty() ) {
				int id_pro=products.get(0).getId();
				checksto.setIdStockPro(id_pro);
				int id_stock=stockDAOImpl.checkexiststockcompokey(id_pro,checksto.getIdStockColor(), checksto.getIdStockSize(),checksto.getStockQty());
				if(id_stock!=0) {
					Billdetail billdetail=new Billdetail();
					BilldetailId billdetailId=new BilldetailId();
					billdetailId.setBilldetailPrice(products.get(0).getCurrentPrice());
					billdetailId.setBilldetailQuantity(checksto.getStockQty());
					billdetailId.setIdBilldetailBill(maxbill);
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
		
		public Object[][] showbill(int page,int rowcount) {
			Date date=new Date();
			SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateValidator dateValidator=new DateValidator();
			boolean check=false;
			//Gan gia tri mac dinh 
			String mindate="2020-01-01 00:00:00";
			String maxdate=formater.format(date);
			int mintotal=0;
			int maxtotal=999999999;
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
				result[i][0]=(page-1)*rowcount+i+1;
				result[i][1]=showlist.get(i)[1].toString();
				result[i][2]=showlist.get(i)[7].toString();
				result[i][3]=showlist.get(i)[5].toString();
				result[i][4]=showlist.get(i)[6].toString();
				result[i][5]=showlist.get(i)[2].toString();
				}
			return result;
		}
		
		public Object[][] showbilldetail() {
			List<Object[]>billdetails=billDAOImpl.findbilldetail(2);
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
		
		public void deletebill() {
			//tk loi dua cai id cua bill 
			Bill bill=billDAOImpl.findbyId(Bill.class, 49);
			billDAOImpl.delete(bill);
		}
}