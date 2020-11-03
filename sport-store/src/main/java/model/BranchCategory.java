package model;
// Generated Oct 6, 2020, 4:08:13 PM by Hibernate Tools 5.4.18.Final

import java.util.HashSet;
import java.util.Set;

/**
 * BranchCategory generated by hbm2java
 */
public class BranchCategory implements java.io.Serializable {

	private int id;
	private Branch branch;
	private Category category;
	private Set productInfos = new HashSet(0);

	public BranchCategory() {
	}

	public BranchCategory(int id, Branch branch, Category category) {
		this.id = id;
		this.branch = branch;
		this.category = category;
	}

	public BranchCategory(int id, Branch branch, Category category, Set productInfos) {
		this.id = id;
		this.branch = branch;
		this.category = category;
		this.productInfos = productInfos;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Branch getBranch() {
		return this.branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set getProductInfos() {
		return this.productInfos;
	}

	public void setProductInfos(Set productInfos) {
		this.productInfos = productInfos;
	}

}