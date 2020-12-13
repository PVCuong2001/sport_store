package dao;
import java.util.List;

import model.Bill;
public interface BillDAO extends BaseDAO<Bill> {
	public List<Object[]> findbytotal(int mintotal,int maxtotal,String mindate,String maxdate);
	public List<Object[]> findbilldetail(int billid);
}
