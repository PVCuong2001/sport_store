package model;
// Generated Oct 6, 2020, 4:08:13 PM by Hibernate Tools 5.4.18.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Color generated by hbm2java
 */
public class Color implements java.io.Serializable {

	private int id;
	private String name;
	private Set stocks = new HashSet(0);

	public Color() {
	}

	public Color(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Color(int id, String name, Set stocks) {
		this.id = id;
		this.name = name;
		this.stocks = stocks;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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
