package vn.shopthethao.Service;

import vn.shopthethao.Model.CartModel;

public interface CartService {
	CartModel get(int userId);
	void edit(int cartid,int quantity,double shipping, double total, double grandtotal);
}
