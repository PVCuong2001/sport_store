package controller;

import java.util.ArrayList;
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
import model.BillProduct;
import model.ProductInfo;
import model.Stock;
import model.User;

public class BillController {
	private static BillDAO<Bill>billDAO;
	private static StockDAO<Stock>stockDAO;
	private static Set<BillProduct>billProducts=new HashSet<BillProduct>();
	private static int maxbill;
	@SuppressWarnings("unchecked")
	public BillController() throws InstanceNotFoundException {
		billDAO=(BillDAO<Bill>) Injector.getInstance("BillImpl");
		stockDAO=(StockDAO<Stock>) Injector.getInstance("StockDAOImpl");
		maxbill=billDAO.getmaxbill();
	}
	public static void main(String[] args) throws InstanceNotFoundException {
		BillController billController=new BillController();
//		billController.addproduct();
//		billController.savebill();
		List<Stock>stocks=BillController.stockDAO.getproductcode("AoBayer");
		System.out.println(stocks.get(0).getQuantity());
	}
		public void savebill() {
			Bill bill=new Bill();
			Date date=new Date();
			//User user=LoginController.storeuser;
			User user=new User();
			user.setId(1);
			// code vs des lay tu view.gettext
			String code="DFE12";
			String description ="Ghi dai cai chi cx dc";
			bill.setCode(code);
			bill.setCreateDate(date);
			bill.setUser(user);
			bill.setBillProducts(billProducts);
			bill.setDescription(description);
			BillController.billDAO.save(bill);
		}
		
		
		public void addproduct() {
			String code="AoBayer" ;
			int quantity=12;
			long price=100000;
			//List<ProductInfo>proList=BillController.pr
			List<Stock>stocks=BillController.stockDAO.getproductcode(code);
			if(stocks!=null && !stocks.isEmpty()) {
				if(quantity>0 && quantity<= stocks.get(0).getQuantity()) {
					BillProduct billProduct=new BillProduct();
					billProduct.setProductInfo(stocks.get(0).getProductInfo());
					billProduct.setQuantity(quantity);
					billProduct.setPrice(price);
					Bill bill=new Bill();
					bill.setId(maxbill);
					billProduct.setBill(bill);
					billProducts.add(billProduct);
				}else {
					System.out.println("So luong mat hang khong hop le \n");
				}
			}else {
				System.out.println("MA CODE SAI . XIN MOI NHAP LAI \n");
			}
		}
		
		public void cancel() {
		
		}
}
