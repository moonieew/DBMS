package vn.shopthethao.DAO;

import java.util.List;

import vn.shopthethao.Model.CartDetailModel;

public interface CartDetailDAO {

	List<CartDetailModel> get(int cartid);

	void edit(int productid, int cartid, double price, int quantity);

	void register(int producid, int cartid, double price, int quantity);

	void delete(int productid, int cartid);
	
	void deleteAll(int cartid);

}
