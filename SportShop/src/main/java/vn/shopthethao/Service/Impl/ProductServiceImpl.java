package vn.shopthethao.Service.Impl;

import java.util.List;

import vn.shopthethao.DAO.ProductDAO;
import vn.shopthethao.DAO.Impl.ProductDAOImpl;
import vn.shopthethao.Model.ProductModel;
import vn.shopthethao.Service.ProductService;

public class ProductServiceImpl implements ProductService{
	ProductDAO productDAO = new ProductDAOImpl(); 
	@Override
	public void insert(ProductModel product) {
		productDAO.insert(product);
	}

	@Override
	public void edit(ProductModel product) {
		productDAO.edit(product);
	}

	@Override
	public void delete(ProductModel product) {
		productDAO.delete(product);
	}

	@Override
	public List<ProductModel> search(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductModel> getAllByPaging(int pageNumber, int rowsOfPage) {
		return productDAO.getAllByPaging(pageNumber, rowsOfPage);
	}

	@Override
	public List<ProductModel> getByCategoryAndPaging(int pageNumber, int rowsOfPage, int categoryId) {
		return productDAO.getByCategoryAndPaging(pageNumber, rowsOfPage, categoryId);
	}

	@Override
	public List<ProductModel> getByCategoryId(int id) {
		return productDAO.getByCategoryId(id);
	}

	@Override
	public ProductModel get(int id) {
		return productDAO.get(id);
	}

	@Override
	public int countAll() {
		return productDAO.countAll();
	}

	@Override
	public int countByCategory(int categoryId) {
		return productDAO.countByCategory(categoryId);
	}

	@Override
	public ProductModel getTop1() {
		return productDAO.getTop1();
	}

	@Override
	public List<ProductModel> getTop4() {
		return productDAO.getTop4();
	}

	@Override
	public int countBySearch(String search) {
		return productDAO.countBySearch(search);
	}

	@Override
	public List<ProductModel> getBySearchAndPaging(int pageNumber, int rowsOfPage, String search) {
		return productDAO.getBySearchAndPaging(pageNumber, rowsOfPage, search);
	}
	
}
