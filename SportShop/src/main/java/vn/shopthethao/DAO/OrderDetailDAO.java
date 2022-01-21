package vn.shopthethao.DAO;

import java.util.List;

import vn.shopthethao.Model.CartDetailModel;
import vn.shopthethao.Model.OrderDetailModel;

public interface OrderDetailDAO {

	void insert(int orderid, CartDetailModel cartDetailModel);

	List<OrderDetailModel> getAll(int id);

}
