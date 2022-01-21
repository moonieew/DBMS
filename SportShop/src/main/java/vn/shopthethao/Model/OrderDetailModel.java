package vn.shopthethao.Model;

public class OrderDetailModel {
	private int productid;
	private int orderid;
	private double price;
	private int quantity;
	private ProductModel productmodel;
	
	
	
	
	
	
	@Override
	public String toString() {
		return "OrderDetailModel [productid=" + productid + ", orderid=" + orderid + ", price=" + price + ", quantity="
				+ quantity + ", productmodel=" + productmodel + "]";
	}
	public OrderDetailModel(int productid, int orderid, double price, int quantity, ProductModel productmodel) {
		super();
		this.productid = productid;
		this.orderid = orderid;
		this.price = price;
		this.quantity = quantity;
		this.productmodel = productmodel;
	}
	public OrderDetailModel(int productid, int orderid, double price, int quantity) {
		super();
		this.productid = productid;
		this.orderid = orderid;
		this.price = price;
		this.quantity = quantity;
	}
	public OrderDetailModel() {
		super();
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ProductModel getProductmodel() {
		return productmodel;
	}
	public void setProductmodel(ProductModel productmodel) {
		this.productmodel = productmodel;
	}
	
}
