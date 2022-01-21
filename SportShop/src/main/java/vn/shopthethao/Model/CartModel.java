package vn.shopthethao.Model;

import java.util.List;

public class CartModel {
	private int id;
	private int status;
	private int quantity;
	private double shipping;
	private double total;
	private double grandTotal;
	private int userId;
	private List<CartDetailModel> listcartdetail;
	
	
	public List<CartDetailModel> getListcartdetail() {
		return listcartdetail;
	}
	public void setListcartdetail(List<CartDetailModel> listcartdetail) {
		this.listcartdetail = listcartdetail;
	}
	public CartModel() {
		super();
	}
	public CartModel(int id, int status, int quantity, double shipping, double total, double grandTotal, int userId) {
		super();
		this.id = id;
		this.status = status;
		this.quantity = quantity;
		this.shipping = shipping;
		this.total = total;
		this.grandTotal = grandTotal;
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getShipping() {
		return shipping;
	}
	public void setShipping(double shipping) {
		this.shipping = shipping;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
