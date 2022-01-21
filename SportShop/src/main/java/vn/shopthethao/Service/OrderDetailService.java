package vn.shopthethao.Service;

import java.util.List;

import vn.shopthethao.Model.CartDetailModel;
import vn.shopthethao.Model.OrderDetailModel;

public interface OrderDetailService {

	void insert(int orderid, CartDetailModel cartDetailModel);

	List<OrderDetailModel> getAll(int id);

}
