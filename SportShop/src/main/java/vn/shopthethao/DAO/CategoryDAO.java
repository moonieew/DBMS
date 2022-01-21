package vn.shopthethao.DAO;


import java.io.ObjectInputStream.GetField;
import java.util.List;

import vn.shopthethao.Model.CategoryModel;

public interface CategoryDAO {
	void insert(CategoryModel category); 
	void edit(CategoryModel category); 
	void delete(CategoryModel category);
	List<CategoryModel> getAllCategory(); 
	CategoryModel get(int id); 
}
