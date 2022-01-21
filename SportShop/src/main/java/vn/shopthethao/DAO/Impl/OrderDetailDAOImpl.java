package vn.shopthethao.DAO.Impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.shopthethao.Connection.MYDB;
import vn.shopthethao.DAO.OrderDetailDAO;
import vn.shopthethao.Model.CartDetailModel;
import vn.shopthethao.Model.OrderDetailModel;
import vn.shopthethao.Model.OrderModel;

public class OrderDetailDAOImpl implements OrderDetailDAO{
	public Connection conn = null;
	public PreparedStatement ps = null;
	public CallableStatement CSS = null;
	ResultSet rs = null;
	

	@Override
	public void insert(int orderid, CartDetailModel cartDetailModel) {
		String query = "{call dbo.SP_RegisterOrderDetail (?,?,?,?)}";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, cartDetailModel.getProductid());
			ps.setInt(2, orderid);
			ps.setDouble(3,cartDetailModel.getPrice());
			ps.setDouble(4, cartDetailModel.getQuantity());
			rs = ps.executeQuery();
			
					
		} catch (Exception e) {

		}
		
	}


	@Override
	public List<OrderDetailModel> getAll(int id) {
		List<OrderDetailModel> listorderdetail = new ArrayList<OrderDetailModel>();
		String query = "SELECT * FROM [OrderDetail] WHERE orderid =  ?";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				listorderdetail.add(new OrderDetailModel(rs.getInt(1), rs.getInt(2), 
						rs.getDouble(3), rs.getInt(4)));
			}
		} catch (Exception e) {

		}
		return listorderdetail;
	}
	
}
