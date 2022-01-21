package vn.shopthethao.Service.Impl;

import java.util.List;

import vn.shopthethao.DAO.OrderDetailDAO;
import vn.shopthethao.DAO.Impl.OrderDetailDAOImpl;
import vn.shopthethao.Model.CartDetailModel;
import vn.shopthethao.Model.OrderDetailModel;
import vn.shopthethao.Service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService{
	OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
	
	@Override
	public void insert(int orderid, CartDetailModel cartDetailModel) {
		orderDetailDAO.insert(orderid,cartDetailModel);
		
	}

	@Override
	public List<OrderDetailModel> getAll(int id) {
		return orderDetailDAO.getAll(id);
	}
	
}
