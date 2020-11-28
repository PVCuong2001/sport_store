package dao;

public interface BranchCategoryDAO<E> extends BaseDAO<E>{
	public int findbybracate(int idbra,int idcate);
}
