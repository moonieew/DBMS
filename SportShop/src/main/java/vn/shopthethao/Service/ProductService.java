package vn.shopthethao.Service;

import java.util.List;

import vn.shopthethao.DAO.ProductDAO;
import vn.shopthethao.Model.ProductModel;

public interface ProductService {
	void insert(ProductModel product); 

	void edit(ProductModel product);

	void delete(ProductModel product); 
	
	List<ProductModel> search(String productName); 

	List<ProductModel> getAllByPaging(int pageNumber, int rowsOfPage);

	List<ProductModel> getByCategoryAndPaging(int pageNumber, int rowsOfPage, int categoryId);
																							
	List<ProductModel> getBySearchAndPaging(int pageNumber, int rowsOfPage, String search);
	
	List<ProductModel> getByCategoryId(int id); 

	ProductModel get(int id);
	
	ProductModel getTop1();
	
	List<ProductModel> getTop4();
	
	int countAll(); 
	
	int countByCategory(int categoryId);
	
	int countBySearch(String search);
}
