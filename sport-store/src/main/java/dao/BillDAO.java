package dao;
import java.util.List;

import model.Bill;
public interface BillDAO<E> extends BaseDAO<E> {
	public List<Object[]> findbytotal(int mintotal,int maxtotal,String mindate,String maxdate);
	public List<Object[]> findbilldetail(int billid);
}
