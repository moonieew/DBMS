package vn.shopthethao.DAO;

import java.util.List;

import vn.shopthethao.Model.CartModel;
import vn.shopthethao.Model.OrderModel;

public interface OrderDAO {
	void insert(CartModel cartModel);

	int getNewID(int userId);

	List<OrderModel> getAll(int id);
}
