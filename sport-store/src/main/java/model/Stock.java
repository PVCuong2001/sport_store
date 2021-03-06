package model;
import java.util.HashSet;
import java.util.Set;

/**
 * Stock generated by hbm2java
 */
public class Stock implements java.io.Serializable {
	private Integer idStock;
	private Color color;
	private ProductInfo productInfo;
	private Size size;
	private int stockQuantity;
	private int stockActiveflag;
	private Set billdetails = new HashSet(0);

	public Stock() {
	}

	public Stock(Color color, ProductInfo productInfo, Size size, int stockQuantity) {
		this.color = color;
		this.productInfo = productInfo;
		this.size = size;
		this.stockQuantity = stockQuantity;
	}

	public Stock(Color color, ProductInfo productInfo, Size size, int stockQuantity, Set billdetails) {
		this.color = color;
		this.productInfo = productInfo;
		this.size = size;
		this.stockQuantity = stockQuantity;
		this.billdetails = billdetails;
	}
	public int getStockActiveflag() {
		return stockActiveflag;
	}

	public void setStockActiveflag(int stockActiveflag) {
		this.stockActiveflag = stockActiveflag;
	}
	public Integer getIdStock() {
		return this.idStock;
	}

	public void setIdStock(Integer idStock) {
		this.idStock = idStock;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public ProductInfo getProductInfo() {
		return this.productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public Size getSize() {
		return this.size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public int getStockQuantity() {
		return this.stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}



	public Set getBilldetails() {
		return this.billdetails;
	}

	public void setBilldetails(Set billdetails) {
		this.billdetails = billdetails;
	}

}
