package vn.shopthethao.Service;

import java.util.List;

import vn.shopthethao.Model.CartModel;
import vn.shopthethao.Model.OrderModel;

public interface OrderService {
	void insert(CartModel cartModel);

	int getNewID(int userId);

	List<OrderModel> getAll(int id);
}
