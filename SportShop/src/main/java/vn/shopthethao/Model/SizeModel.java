package vn.shopthethao.Model;

public class SizeModel {
	private int productId;
	private int size;
	public SizeModel(int productId, int size) {
		super();
		this.productId = productId;
		this.size = size;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
