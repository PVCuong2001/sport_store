package test;
// Generated Nov 26, 2020, 5:02:29 PM by Hibernate Tools 5.4.18.Final

/**
 * BilldetailId generated by hbm2java
 */
public class BilldetailId implements java.io.Serializable {

	private int idBilldetailBill;
	private int billdetailQuantity;
	private int billdetailPrice;
	private int idBilldetailStock;

	public BilldetailId() {
	}

	public BilldetailId(int idBilldetailBill, int billdetailQuantity, int billdetailPrice, int idBilldetailStock) {
		this.idBilldetailBill = idBilldetailBill;
		this.billdetailQuantity = billdetailQuantity;
		this.billdetailPrice = billdetailPrice;
		this.idBilldetailStock = idBilldetailStock;
	}

	public int getIdBilldetailBill() {
		return this.idBilldetailBill;
	}

	public void setIdBilldetailBill(int idBilldetailBill) {
		this.idBilldetailBill = idBilldetailBill;
	}

	public int getBilldetailQuantity() {
		return this.billdetailQuantity;
	}

	public void setBilldetailQuantity(int billdetailQuantity) {
		this.billdetailQuantity = billdetailQuantity;
	}

	public int getBilldetailPrice() {
		return this.billdetailPrice;
	}

	public void setBilldetailPrice(int billdetailPrice) {
		this.billdetailPrice = billdetailPrice;
	}

	public int getIdBilldetailStock() {
		return this.idBilldetailStock;
	}

	public void setIdBilldetailStock(int idBilldetailStock) {
		this.idBilldetailStock = idBilldetailStock;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BilldetailId))
			return false;
		BilldetailId castOther = (BilldetailId) other;

		return (this.getIdBilldetailBill() == castOther.getIdBilldetailBill())
				&& (this.getBilldetailQuantity() == castOther.getBilldetailQuantity())
				&& (this.getBilldetailPrice() == castOther.getBilldetailPrice())
				&& (this.getIdBilldetailStock() == castOther.getIdBilldetailStock());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdBilldetailBill();
		result = 37 * result + this.getBilldetailQuantity();
		result = 37 * result + this.getBilldetailPrice();
		result = 37 * result + this.getIdBilldetailStock();
		return result;
	}

}
