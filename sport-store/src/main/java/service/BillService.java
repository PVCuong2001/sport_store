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
import dao.ProductDAO;
import dao.StockDAO;
import model.Bill;
import model.Billdetail;
import model.BillProductId;
import model.ProductInfo;
import model.Stock;
import model.User;
import validate.DateValidator;

public class BillService {
	private static BillDAO<Bill>billDAO;
	private static StockDAO<Stock>stockDAO;
	private static Set<Billdetail>billProducts=new HashSet<Billdetail>();
	private static List<Object[]> showlist=new ArrayList<Object[]>();
	private static int maxbill=0;
	@SuppressWarnings("unchecked")
	public BillService() throws InstanceNotFoundException {
		billDAO=(BillDAO<Bill>) Injector.getInstance("BillImpl");
		stockDAO=(StockDAO<Stock>) Injector.getInstance("StockDAOImpl");
		maxbill=billDAO.nextid("bill");
	}
	public static void main(String[] args) throws InstanceNotFoundException {
		BillService BillService=new BillService();
//		BillService.addproduct();
//		BillService.savebill();
	//	BillService.showbill();
	//	BillService.showbilldetail();
//		Object [][] data=BillService.showbilldetail();
//		for(Object[] i :data) {
//			for(Object j :i) {
//				System.out.print(j+"         ");
//			}
//			System.out.println();
//		}
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
//loi				bill.setBillProducts(billProducts);
				bill.setDescription(description);
				BillService.billDAO.save(bill);
			}else {
				System.out.println("Ma bill da ton tai .Vui long nhap lai. \n");
			}		
		}
		
		
		public void addproduct() {
			String code="AoJuve" ;
			int quantity=10;
			long price=100000;
			List<Stock>stocks=BillService.stockDAO.getproductcode(code);
			if(stocks!=null && !stocks.isEmpty()) {
				if(quantity>0 && quantity<= stocks.get(0).getStockQuantity()) {
					Billdetail billProduct=new Billdetail();
//loi					billProduct.setProductInfo(stocks.get(0).getProductInfo());
//	loi				billProduct.setQuantity(quantity);
//loi					billProduct.setPrice(price);
	//				Bill bill=new Bill();
	//				bill.setId(maxbill);
	//				billProduct.setBill(bill);
					
					BillProductId billProductId=new BillProductId();
					billProductId.setIdBill(maxbill);
		//de do lam sau			billProductId.setIdProductInfo(stocks.get(0).getId());					
//loi					billProduct.setId(billProductId);
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
			
			showlist =billDAO.findbytotal(mintotal,maxtotal,mindate,maxdate);
			System.out.println(showlist.get(1)[5].toString());
			System.out.println(showlist.get(1)[6].toString());
			
			Object [][] result= new Object[showlist.size()][7];
			for(int i=0;i<showlist.size();i++) {
				result[i][0]=(page-1)*rowcount+i+1;
				result[i][1]=showlist.get(i)[1].toString();
				result[i][2]=showlist.get(i)[7].toString();
				result[i][3]=showlist.get(i)[8].toString();
				result[i][4]=showlist.get(i)[5].toString();
				result[i][5]=showlist.get(i)[6].toString();
				result[i][6]=showlist.get(i)[2].toString();
				}
			return result;
		}
		
		public Object[][] showbilldetail() {
			List<Object[]>billdetails=billDAO.findbilldetail(2);
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
			Bill bill=billDAO.findbyId(Bill.class, 49);
			billDAO.delete(bill);
		}
}