package vn.shopthethao.DAO;

import java.util.List;

import vn.shopthethao.Model.ProductModel;

public interface ProductDAO {
	void insert(ProductModel product); 

	void edit(ProductModel product); 

	void delete(ProductModel product); 

	List<ProductModel> search(String productName);

	List<ProductModel> getAllByPaging(int pageNumber, int rowsOfPage); 

	List<ProductModel> getByCategoryAndPaging(int pageNumber, int rowsOfPage, int categoryId); 
																								

	List<ProductModel> getBySearchAndPaging(int pageNumber, int rowsOfPage, String search); // Phân trang theo tìm kiếm
	
	List<ProductModel> getByCategoryId(int id); 

	ProductModel get(int id); 
	
	int countAll();
	
	int countByCategory(int categoryId); 
	
	int countBySearch(String search);
	
	ProductModel getTop1();

	List<ProductModel> getTop4();
	
	
	

}
