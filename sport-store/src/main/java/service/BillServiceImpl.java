package service;


import java.util.ArrayList;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;




import dao.BillDAOImpl;
import dao.ProductDAOImpl;
import dao.StockDAOImpl;
import mix.Algorithm;
import mix.Myexception;
import model.Bill;
import model.Billdetail;
import model.BilldetailId;
import model.ProductInfo;
import model.Stock;
import model.User;

public class BillServiceImpl implements BillService{
	private  BillDAOImpl billDAOImpl;
	private  StockDAOImpl stockDAOImpl;
	private  ProductDAOImpl productDAOImpl;
	private  List<Object[]> showlist;
	private List<Stock>stocks;
	private List<Integer>listcal;
	private List<Billdetail> billdetails;
	private List<Object[]> printedlist;
	public BillServiceImpl() {
		billDAOImpl=new BillDAOImpl(Bill.class);
		stockDAOImpl=new StockDAOImpl(Stock.class);
		productDAOImpl=new ProductDAOImpl(ProductInfo.class);
		billdetails=new ArrayList<Billdetail>();
		stocks=new ArrayList<Stock>();
	}
		public void savebill(String code,String description,boolean status ) throws Myexception {
			List<Bill>bills=billDAOImpl.findbyproperty("code", code);
			if(bills.isEmpty()) {
				Bill bill=new Bill();
				User user=UserServiceImpl.storeuser;
				Set<Billdetail>result=new HashSet<Billdetail>(billdetails);
				bill.setCode(code);
				if(status) bill.setBillStatus(0);
				else bill.setBillStatus(1);
				bill.setCreateDate(new Date());
				bill.setUser(user);
				bill.setDescription(description);
				bill.setBilldetails(result);
				billDAOImpl.save(bill);
				billdetails.clear();
			}else {
				throw new Myexception("Bill code has already existed! \n");
			}		
		}
		
		public List<Stock> checkprocode(String code,boolean check) throws Myexception {
			stocks.clear();
			Object[] result=productDAOImpl.findproclothes(code,check);
			if(result!=null) {
				int id_pro=(int) result[0];
				ProductInfo product=new ProductInfo();
				product.setId(id_pro);
				product.setCurrentPrice(Long.parseLong(result[1].toString()));
				stocks=stockDAOImpl.findbyidpro(id_pro, true);
				for(Stock value :stocks) {
					value.setProductInfo(product);
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
				}else {
					throw new Myexception("Product is not avalable in stock or your request quantity is too much \n");
				}
		}
		public void removeproduct(int index) {
			billdetails.remove(index);
		}

		public Object[][] showbill(int mintotal,int maxtotal,String mindate,String maxdate) {
			showlist =billDAOImpl.findbytotal(mintotal,maxtotal,mindate,maxdate);
			Object [][] result= new Object[showlist.size()][7];
			for(int i=0;i<showlist.size();i++) {
				result[i][0]=i+1;
				result[i][1]=showlist.get(i)[1].toString();
				result[i][2]=showlist.get(i)[9].toString();
				result[i][3]=showlist.get(i)[6].toString();
				result[i][4]=showlist.get(i)[7].toString();
				result[i][5]=showlist.get(i)[2].toString();
				if(showlist.get(i)[5].toString().equals("0")) 	result[i][6]="Incomplete";
				else result[i][6]="Complete";
				}
			return result;
		}
		public Object[][] showbilldetail(int index) {
			int id_bill=(int) showlist.get(index)[0];
			List<Object[]>details=billDAOImpl.findbilldetail(id_bill);
			Object [][] result= new Object[details.size()][8];
			for(int i=0;i<details.size();i++) {
				result[i][0]=i+1;
				result[i][1]=details.get(i)[0].toString();
				result[i][2]=details.get(i)[1].toString();
				result[i][3]=details.get(i)[2].toString();
				result[i][4]=details.get(i)[3].toString();
				result[i][5]=details.get(i)[4].toString();
				result[i][6]=details.get(i)[5].toString();
				result[i][7]=Integer.parseInt(details.get(i)[4].toString())*Integer.parseInt(details.get(i)[5].toString());
			}
			return result;
		}
		
		public Object[][] findprintedbill() {
			printedlist=billDAOImpl.findprintedbill();
			String billcode[]=new String[printedlist.size()+1];
			int qty[]=new int[printedlist.size()+1];
			int value[]=new int[printedlist.size()+1];
			for(int i=1;i<=printedlist.size();i++) {
				billcode[i]=(String) printedlist.get(i-1)[0];
				qty[i]=Integer.parseInt(printedlist.get(i-1)[1].toString());
				value[i]=Integer.parseInt(printedlist.get(i-1)[2].toString());
			}
			Algorithm algorithm=new Algorithm(qty,value);
			listcal=algorithm.cal();
			Object [][]data=new Object[listcal.size()][3];
			for(int i=0;i<listcal.size();i++) {
				data[i][0]=billcode[listcal.get(i)];
				data[i][1]=qty[listcal.get(i)];
				data[i][2]=value[listcal.get(i)];
			}
			return data;
		}
		public void completeprintedbill() {
			List<String>listbillcode=new ArrayList<String>();
			for(Integer index :listcal) {
				listbillcode.add((String) printedlist.get(index-1)[0]);
			}
			billDAOImpl.updateprinted(listbillcode);
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
		
		public Object[][] getprintedlist(){
			Object[][]data =new Object[printedlist.size()][3];
			for(int i=0;i<printedlist.size();i++) {
				data[i][0]=printedlist.get(i)[0];
				data[i][1]=printedlist.get(i)[1];
				data[i][2]=printedlist.get(i)[2];
			}
			return data;
		}
		public List<Billdetail>getbilldetails(){
			return billdetails;
		}
		public List<Stock>getstocks(){
			return stocks;
		}
		public  List<Object[]> getshowbill(){
			return showlist;
		}
}