package vn.shopthethao.DAO.Impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.shopthethao.Connection.MYDB;
import vn.shopthethao.DAO.BrandDAO;
import vn.shopthethao.Model.BrandModel;
import vn.shopthethao.Model.CategoryModel;

public class BrandDAOImpl implements BrandDAO {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public CallableStatement CSS = null;
	ResultSet rs = null;
	@Override
	public void insert(BrandModel brand) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(BrandModel brand) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(BrandModel brand) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BrandModel> getAllBrand() {
		List<BrandModel> list = new ArrayList<BrandModel>();
		String query = "SELECT * FROM view_Brands";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new BrandModel(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

}
