package test;
// Generated Nov 4, 2020, 9:15:15 PM by Hibernate Tools 5.4.18.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Size generated by hbm2java
 */
public class Size implements java.io.Serializable {

	private Integer idSize;
	private String sizeName;
	private Set stocks = new HashSet(0);

	public Size() {
	}

	public Size(String sizeName, Set stocks) {
		this.sizeName = sizeName;
		this.stocks = stocks;
	}

	public Integer getIdSize() {
		return this.idSize;
	}

	public void setIdSize(Integer idSize) {
		this.idSize = idSize;
	}

	public String getSizeName() {
		return this.sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	public Set getStocks() {
		return this.stocks;
	}

	public void setStocks(Set stocks) {
		this.stocks = stocks;
	}

}