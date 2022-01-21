package vn.shopthethao.Model;

public class CategoryModel {
	private int id;
	private String name;
	
	public CategoryModel(int id) {
		super();
		this.id = id;
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

	public CategoryModel(String name) {
		super();
		this.name = name;
	}

	public CategoryModel(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
