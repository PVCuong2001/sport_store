package dao;

import model.BranchCategory;

public interface BranchCategoryDAO extends BaseDAO<BranchCategory>{
	public int findbybracate(int idbra,int idcate);
}
