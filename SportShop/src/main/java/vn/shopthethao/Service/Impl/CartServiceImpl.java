package vn.shopthethao.Service.Impl;

import vn.shopthethao.DAO.CartDAO;
import vn.shopthethao.DAO.Impl.CartDAOImpl;
import vn.shopthethao.Model.CartModel;
import vn.shopthethao.Service.CartService;

public class CartServiceImpl implements CartService{
	CartDAO cartDAO = new CartDAOImpl();

	@Override
	public CartModel get(int userId) {
		return cartDAO.get(userId);
	}

	@Override
	public void edit(int cartid, int quantity, double shipping, double total, double grandtotal) {
		cartDAO.edit(cartid, quantity,shipping, total, grandtotal);
	}
	

}
