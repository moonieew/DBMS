package vn.shopthethao.Service.Impl;

import java.util.List;

import vn.shopthethao.DAO.CategoryDAO;
import vn.shopthethao.DAO.Impl.CategoryDAOImpl;
import vn.shopthethao.Model.CategoryModel;
import vn.shopthethao.Service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	CategoryDAO categoryDAO = new CategoryDAOImpl();
	@Override
	public void insert(CategoryModel category) {
		categoryDAO.insert(category);
		
	}

	@Override
	public void edit(CategoryModel category) {
		categoryDAO.edit(category);
		
	}

	@Override
	public void delete(CategoryModel category) {
		categoryDAO.delete(category);
		
	}

	@Override
	public List<CategoryModel> getAllCategory() {
		return categoryDAO.getAllCategory();
	}

	@Override
	public CategoryModel get(int id) {
		return categoryDAO.get(id);
	}

}
