package vn.shopthethao.Model;

public class ProductModel {
	private int id;
	private String name;
	private double price;
	private double salePrice;
	private int quantity;
	private String description;
	private String image;
	private int brandId;
	private int categoryId;
	
	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", name=" + name + ", price=" + price + ", salePrice=" + salePrice
				+ ", quantity=" + quantity + ", description=" + description + ", image=" + image + ", brandId="
				+ brandId + ", categoryId=" + categoryId + "]";
	}
	public ProductModel(String name, double price, double salePrice, int quantity, String description, String image,
			int brandId, int categoryId) {
		super();
		this.name = name;
		this.price = price;
		this.salePrice = salePrice;
		this.quantity = quantity;
		this.description = description;
		this.image = image;
		this.brandId = brandId;
		this.categoryId = categoryId;
	}
	public ProductModel(int id, String name, double price, double salePrice, int quantity, String description,
			String image, int brandId, int categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.salePrice = salePrice;
		this.quantity = quantity;
		this.description = description;
		this.image = image;
		this.brandId = brandId;
		this.categoryId = categoryId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public ProductModel() {
		super();
	}
	
}
