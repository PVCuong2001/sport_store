package model;
// Generated Oct 6, 2020, 4:08:13 PM by Hibernate Tools 5.4.18.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Size generated by hbm2java
 */
public class Size implements java.io.Serializable {

	private Integer id;
	private String name;
	private Set stocks = new HashSet(0);

	public Size() {
	}

	public Size(String name, Set stocks) {
		this.name = name;
		this.stocks = stocks;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getStocks() {
		return this.stocks;
	}

	public void setStocks(Set stocks) {
		this.stocks = stocks;
	}

}
