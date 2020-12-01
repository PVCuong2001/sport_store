package model;

import java.util.List;

public class UploadProductComponent {
	private List<Branch> branch;
	private List<Category> category;
	private List<Color> color;
	private List<Size> sizesnum;
	private List<Size>sizeschar;
	
	public UploadProductComponent() {};
	public UploadProductComponent(List<Branch> branch, List<Category> category, List<Color> color, List<Size> sizesnum,List<Size>sizeschar) {
		super();
		this.branch = branch;
		this.category = category;
		this.color = color;
		this.sizesnum = sizesnum;
		this.sizeschar=sizeschar;
	}
	public List<Branch> getBranch() {
		return branch;
	}
	public void setBranch(List<Branch> branch) {
		this.branch = branch;
	}
	public List<Category> getCategory() {
		return category;
	}
	public void setCategory(List<Category> category) {
		this.category = category;
	}
	public List<Color> getColor() {
		return color;
	}
	public void setColor(List<Color> color) {
		this.color = color;
	}
	
	public List<Size> getSizenum() {
		return sizesnum;
	}
	public void setSizenum(List<Size> sizesnum) {
		this.sizesnum = sizesnum;
	}
	public List<Size> getSizechar() {
		return sizeschar;
	}
	public void setSizechar(List<Size> sizeschar) {
		this.sizeschar = sizeschar;
	}
}