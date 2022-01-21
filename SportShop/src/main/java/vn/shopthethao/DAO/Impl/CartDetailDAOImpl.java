package vn.shopthethao.DAO.Impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.shopthethao.Connection.MYDB;
import vn.shopthethao.DAO.CartDetailDAO;
import vn.shopthethao.DAO.ProductDAO;
import vn.shopthethao.Model.CartDetailModel;
import vn.shopthethao.Model.ProductModel;

public class CartDetailDAOImpl implements CartDetailDAO{
	public Connection conn = null;
	public PreparedStatement ps = null;
	ResultSet rs = null;	
	
	
	@Override
	public List<CartDetailModel> get(int cartid) {
		List<CartDetailModel> cartdetailModel = new ArrayList<CartDetailModel>();
		ProductModel productModel = new ProductModel();
		ProductDAO productDao = new ProductDAOImpl();
		String query = "SELECT * FROM Func_GetCartDetail (?)";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, cartid);
			rs = ps.executeQuery();
			while(rs.next()) {
				cartdetailModel.add(new CartDetailModel(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getInt(4)));
				productModel = productDao.get(rs.getInt(1));
				cartdetailModel.get(cartdetailModel.size()-1).setProductmodel(productModel);
			}
		} catch (Exception e) {
			
		}
		
		return cartdetailModel;
	}
	
	public static void main(String[] args) {
		List<CartDetailModel> cdm = new ArrayList<CartDetailModel>();
		CartDetailDAO cdd = new CartDetailDAOImpl();
		cdd.edit(7, 11, 2100000, 3);
	}

	@Override
	public void edit(int productid, int cartid, double price, int quantity) {
		String query = "{call dbo.SP_EditCartDetail (?,?,?,?)}";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, productid);
			ps.setInt(2, cartid);
			ps.setDouble(3, price);
			ps.setInt(4, quantity);
			rs = ps.executeQuery();
			
			
		} catch (Exception e) {

		}
	}

	@Override
	public void register(int producid, int cartid, double price, int quantity) {
		String query = "{call dbo.SP_RegisterCartDetail (?,?,?,?)}";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, producid);
			ps.setInt(2, cartid);
			ps.setDouble(3, price);
			ps.setInt(4, quantity);
			rs = ps.executeQuery();
			
			
		} catch (Exception e) {

		}
		
	}

	@Override
	public void delete(int productid, int cartid) {
		String query = "DELETE  FROM [CartDetail] WHERE productid = @productid AND cartid = @cartid";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, productid);
			ps.setInt(2, cartid);
			rs = ps.executeQuery();
			
			
		} catch (Exception e) {

		}
		
	}

	@Override
	public void deleteAll(int cartid) {
		String query = "{call dbo.SP_DeleteAllCartDetail (?)}";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, cartid);
			rs = ps.executeQuery();
			
			
		} catch (Exception e) {

		}
		
	}

}
