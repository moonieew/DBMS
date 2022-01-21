package vn.shopthethao.DAO.Impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.shopthethao.Connection.MYDB;
import vn.shopthethao.DAO.CategoryDAO;
import vn.shopthethao.Model.CategoryModel;

public class CategoryDAOImpl implements CategoryDAO {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public CallableStatement CSS = null;
	ResultSet rs = null;
	@Override
	public void insert(CategoryModel category) {
		String query = "{call dbo.SP_RegisterCategory(?)}";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, category.getName());
			ps.executeUpdate();
		} catch (Exception e) {
			
		}
		
	}

	@Override
	public void edit(CategoryModel category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CategoryModel category) {
		String query = "{call dbo.SP_DeleteCategory(?)}";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, category.getId());
			rs = ps.executeQuery();
			if(rs.next()) {

			}
		}catch(Exception e){
			
		}
		
	}

	@Override
	public List<CategoryModel> getAllCategory() {
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		String query = "SELECT * FROM view_Categories";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new CategoryModel(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public CategoryModel get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
