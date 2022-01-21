package vn.shopthethao.DAO.Impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.shopthethao.Connection.MYDB;
import vn.shopthethao.DAO.OrderDAO;
import vn.shopthethao.Model.CartModel;
import vn.shopthethao.Model.OrderModel;

public class OrderDAOImpl implements OrderDAO{
	public Connection conn = null;
	public PreparedStatement ps = null;
	public CallableStatement CSS = null;
	ResultSet rs = null;
	
	@Override
	public void insert(CartModel cartModel) {
		String query = "{call dbo.SP_RegisterOrders (?,?,?,?,?)}";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, cartModel.getQuantity());
			ps.setDouble(2, cartModel.getShipping());
			ps.setDouble(3,cartModel.getTotal());
			ps.setDouble(4, cartModel.getGrandTotal());
			ps.setDouble(5, cartModel.getUserId());
			rs = ps.executeQuery();
			
					
			
		} catch (Exception e) {

		}
	}

	@Override
	public int getNewID(int userId) {
		String query = "SELECT * FROM dbo.Func_GetNewId(?)";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (Exception e) {

		}
		return -1;
	}

	@Override
	public List<OrderModel> getAll(int id) {
		List<OrderModel> listorderModel = new ArrayList<OrderModel>();
		String query = "SELECT * FROM dbo.Func_GetOrder(?)";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				listorderModel.add(new OrderModel(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getInt(4), 
						rs.getInt(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8), rs.getInt(9)));
			}
		} catch (Exception e) {

		}
		return listorderModel;
	}

}
