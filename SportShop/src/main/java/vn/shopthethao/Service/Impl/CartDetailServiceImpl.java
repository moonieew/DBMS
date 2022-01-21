package vn.shopthethao.Service.Impl;

import java.util.List;

import vn.shopthethao.DAO.CartDetailDAO;
import vn.shopthethao.DAO.Impl.CartDetailDAOImpl;
import vn.shopthethao.Model.CartDetailModel;
import vn.shopthethao.Service.CartDetailService;

public class CartDetailServiceImpl implements CartDetailService{
	CartDetailDAO cartdetailDao = new CartDetailDAOImpl();
	
	@Override
	public List<CartDetailModel> get(int cartid) {
		return cartdetailDao.get(cartid);
	}

	@Override
	public void edit(int productid, int cartid, double price, int quantity) {
		cartdetailDao.edit(productid,cartid,price,quantity);
	}

	@Override
	public void register(int producid, int cartid, double price, int quantity) {
		cartdetailDao.register(producid,cartid,price,quantity);
		
	}

	@Override
	public void delete(int productid, int cartid) {
		cartdetailDao.delete(productid, cartid);
		
	}

	@Override
	public void deleteAll(int cartid) {
		cartdetailDao.deleteAll(cartid);
		
	}

}
