package vn.shopthethao.Service.Impl;

import java.util.List;

import vn.shopthethao.DAO.OrderDAO;
import vn.shopthethao.DAO.Impl.OrderDAOImpl;
import vn.shopthethao.Model.CartModel;
import vn.shopthethao.Model.OrderModel;
import vn.shopthethao.Service.OrderService;

public class OrderServiceImpl implements OrderService{
	OrderDAO orderDAO = new OrderDAOImpl();
	@Override
	public void insert(CartModel cartModel) {
		orderDAO.insert(cartModel);
	}
	@Override
	public int getNewID(int userId) {
		// TODO Auto-generated method stub
		return orderDAO.getNewID(userId);
	}
	@Override
	public List<OrderModel> getAll(int id) {
		return orderDAO.getAll(id);
	}

}
