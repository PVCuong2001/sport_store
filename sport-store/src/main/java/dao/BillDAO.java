package dao;
import java.util.List;

import model.Bill;
public interface BillDAO extends BaseDAO<Bill> {
	 List<Object[]> findbytotal(int mintotal,int maxtotal,String mindate,String maxdate);
	 List<Object[]> findbilldetail(int billid);
	 List<Object[]>findprintedbill();
}
