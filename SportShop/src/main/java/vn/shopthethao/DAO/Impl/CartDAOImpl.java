package vn.shopthethao.DAO.Impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.shopthethao.Connection.MYDB;
import vn.shopthethao.DAO.CartDAO;
import vn.shopthethao.Model.CartModel;

public class CartDAOImpl implements CartDAO{
	public Connection conn = null;
	public PreparedStatement ps = null;
	public CallableStatement CSS = null;
	ResultSet rs = null;
	
	@Override
	public CartModel get(int userid) {
		CartModel cartmodel = new CartModel();
		String query = "SELECT * FROM dbo.Func_GetCart(?)";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, userid);
			rs = ps.executeQuery();
			if (rs.next()) {
				cartmodel = new CartModel(rs.getInt(1), rs.getInt(2), rs.getInt(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getInt(7));
			}
		} catch (Exception e) {

		}
		return cartmodel;
	}
	
	public static void main(String[] args) {
		CartDAO cd=new CartDAOImpl();
		CartModel cm = new CartModel();
	}

	@Override
	public void edit(int cartid, int quantity, double shipping, double total, double grandtotal) {
		String query = "{call dbo.SP_EditCart (?,?,?,?,?)}";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, cartid);
			ps.setInt(2, quantity);
			ps.setDouble(3,shipping);
			ps.setDouble(4, total);
			ps.setDouble(5, grandtotal);
			rs = ps.executeQuery();
			
			
		} catch (Exception e) {

		}
		
	}

}
