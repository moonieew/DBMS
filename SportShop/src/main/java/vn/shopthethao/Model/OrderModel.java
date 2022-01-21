package vn.shopthethao.Model;

import java.sql.Date;
import java.util.List;

public class OrderModel {
	private int id;
	private Date createAt;
	private Date completedAt;
	private int status;
	private int quantity;
	private double shipping;
	private double total;
	private double grandTotal;
	private int userId;
	private List<OrderDetailModel> listorderdetail;
	
	public OrderModel(int id, Date createAt, Date completedAt, int status, int quantity, double shipping, double total,
			double grandTotal, int userId, List<OrderDetailModel> listorderdetail) {
		super();
		this.id = id;
		this.createAt = createAt;
		this.completedAt = completedAt;
		this.status = status;
		this.quantity = quantity;
		this.shipping = shipping;
		this.total = total;
		this.grandTotal = grandTotal;
		this.userId = userId;
		this.listorderdetail = listorderdetail;
	}
	public List<OrderDetailModel> getListorderdetail() {
		return listorderdetail;
	}
	public void setListorderdetail(List<OrderDetailModel> listorderdetail) {
		this.listorderdetail = listorderdetail;
	}
	public OrderModel(int id, Date createAt, Date completedAt, int status, int quantity, double shipping, double total,
			double grandTotal, int userId) {
		super();
		this.id = id;
		this.createAt = createAt;
		this.completedAt = completedAt;
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
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getCompletedAt() {
		return completedAt;
	}
	public void setCompletedAt(Date completedAt) {
		this.completedAt = completedAt;
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
