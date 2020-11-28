package controller;

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
import dao.ProductDAO;
import dao.StockDAO;
import model.Bill;
import model.Billdetail;
import model.BillProductId;
import model.ProductInfo;
import model.Stock;
import model.User;
import validate.DateValidator;

public class BillController {
	private static BillDAO<Bill>billDAO;
	private static StockDAO<Stock>stockDAO;
	private static Set<Billdetail>billProducts=new HashSet<Billdetail>();
	private static List<Object[]> showlist=new ArrayList<Object[]>();
	private static int maxbill=0;
	@SuppressWarnings("unchecked")
	public BillController() throws InstanceNotFoundException {
		billDAO=(BillDAO<Bill>) Injector.getInstance("BillImpl");
		stockDAO=(StockDAO<Stock>) Injector.getInstance("StockDAOImpl");
		maxbill=billDAO.nextid("bill");
	}
	public static void main(String[] args) throws InstanceNotFoundException {
		BillController billController=new BillController();
//		billController.addproduct();
//		billController.savebill();
		billController.showbill();
		System.out.println(maxbill);
	}
		public void savebill() {
			String code="cuongprolt";
			List<Bill>bills=billDAO.findbyproperty("code", code, "Bill");
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
				bill.setBillProducts(billProducts);
				bill.setDescription(description);
				BillController.billDAO.save(bill);
			}else {
				System.out.println("Ma bill da ton tai .Vui long nhap lai. \n");
			}		
		}
		
		
		public void addproduct() {
			String code="AoJuve" ;
			int quantity=10;
			long price=100000;
			List<Stock>stocks=BillController.stockDAO.getproductcode(code);
			if(stocks!=null && !stocks.isEmpty()) {
				if(quantity>0 && quantity<= stocks.get(0).getStockQuantity()) {
					Billdetail billProduct=new Billdetail();
					billProduct.setProductInfo(stocks.get(0).getProductInfo());
					billProduct.setQuantity(quantity);
					billProduct.setPrice(price);
	//				Bill bill=new Bill();
	//				bill.setId(maxbill);
	//				billProduct.setBill(bill);
					
					BillProductId billProductId=new BillProductId();
					billProductId.setIdBill(maxbill);
		//de do lam sau			billProductId.setIdProductInfo(stocks.get(0).getId());
					billProduct.setId(billProductId);
					billProducts.add(billProduct);
				}else {
					System.out.println("So luong mat hang khong hop le \n");
				}
			}else {
				System.out.println("MA CODE SAI HOAC SAN PHAM KHONG CON DUOC BAN . XIN MOI NHAP LAI \n");
			}
		}
		
		public void cancel() {
			//xoa toan bo product ra khoi list billproduct
			//tren view thi xoa het nx gi user da ghi
		}
		public void showbill() {
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
			
			showlist =billDAO.findbytotal(mintotal,maxtotal,mindate,maxdate);
			System.out.println(showlist.get(0)[5].toString());
		}
		
		public void showbilldetail() {
			List<Object[]>billdetails=billDAO.findbilldetail(1);
			System.out.println(billdetails.get(0)[0].toString()+" "+billdetails.get(0)[3].toString());
		}
		
		public void deletebill() {
			//tk loi dua cai id cua bill 
			Bill bill=billDAO.findbyId(Bill.class, 48);
			billDAO.delete(bill);
		}
}
