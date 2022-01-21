package vn.shopthethao.Service;

import java.util.List;

import vn.shopthethao.Model.CategoryModel;

public interface CategoryService {
	void insert(CategoryModel category);
	void edit(CategoryModel category); 
	void delete(CategoryModel category); 
	List<CategoryModel> getAllCategory(); 
	CategoryModel get(int id);
}
