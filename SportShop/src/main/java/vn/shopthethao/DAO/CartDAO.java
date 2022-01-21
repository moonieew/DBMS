package vn.shopthethao.DAO;

import vn.shopthethao.Model.CartModel;

public interface CartDAO {

	CartModel get(int userId);

	void edit(int cartid, int quantity,double shipping, double total, double grandtotal);
		
}
