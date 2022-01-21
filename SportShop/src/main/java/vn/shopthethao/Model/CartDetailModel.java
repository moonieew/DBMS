package vn.shopthethao.Model;

public class CartDetailModel {
	private int productid;
	private int cartid;
	private double price;
	private int quantity;
	private ProductModel productmodel;
	
	public CartDetailModel() {
		super();
	}


	


	public CartDetailModel(int productid, int cartid, double price, int quantity) {
		super();
		this.productid = productid;
		this.cartid = cartid;
		this.price = price;
		this.quantity = quantity;
	}
	
	public CartDetailModel(int productid, int cartid, double price, int quantity,ProductModel productmodel ) {
		super();
		this.productid = productid;
		this.cartid = cartid;
		this.price = price;
		this.quantity = quantity;
		this.productmodel = productmodel;
	}




	public int getProductid() {
		return productid;
	}


	public void setProductid(int productid) {
		this.productid = productid;
	}


	public int getCartid() {
		return cartid;
	}


	public void setCartid(int cartid) {
		this.cartid = cartid;
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


	@Override
	public String toString() {
		return "CartDetailModel [productid=" + productid + ", cartid=" + cartid + ", price=" + price + ", quantity="
				+ quantity + ", cartmodel=" +  "]";
	}





	public ProductModel getProductmodel() {
		return productmodel;
	}





	public void setProductmodel(ProductModel productmodel) {
		this.productmodel = productmodel;
	}






	
	
	
}
