package vn.shopthethao.DAO.Impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.shopthethao.Connection.MYDB;
import vn.shopthethao.DAO.ProductDAO;
import vn.shopthethao.Model.ProductModel;
import vn.shopthethao.Model.UserModel;

public class ProductDAOImpl implements ProductDAO {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public CallableStatement CSS = null;
	ResultSet rs = null;

	@Override
	public void insert(ProductModel product) {
		String query = "{call dbo.SP_RegisterProduct(?,?,?,?,?,?,?,?)}";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, product.getName());
			ps.setDouble(2, product.getPrice());
			ps.setDouble(3, product.getSalePrice());
			ps.setInt(4, product.getQuantity());
			ps.setString(5, product.getDescription());
			ps.setString(6, product.getImage());
			ps.setInt(7, product.getBrandId());
			ps.setInt(8, product.getCategoryId());
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

	@Override
	public void edit(ProductModel product) {
		String query = "{call dbo.SP_EditProduct(?,?,?,?,?,?,?,?,?)}";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, product.getId());
			ps.setString(2, product.getName());
			ps.setDouble(3, product.getPrice());
			ps.setDouble(4, product.getSalePrice());
			ps.setInt(5, product.getQuantity());
			ps.setString(6, product.getDescription());
			ps.setString(7, product.getImage());
			ps.setInt(8, product.getBrandId());
			ps.setInt(9, product.getCategoryId());
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

	@Override
	public void delete(ProductModel product) {
		String query = "{call dbo.SP_DeleteProduct(?)}";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, product.getId());
			ps.executeUpdate();

		} catch (Exception e) {

		}
	}

	@Override
	public List<ProductModel> search(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductModel> getAllByPaging(int pageNumber, int rowsOfPage) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String query = "SELECT * FROM Func_pagingAllProduct(?,?)";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, pageNumber);
			ps.setInt(2, rowsOfPage);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<ProductModel> getByCategoryId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductModel get(int id) {
		String query = "select * from Product where id = ?";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				return new ProductModel(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
			}
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public List<ProductModel> getByCategoryAndPaging(int pageNumber, int rowsOfPage, int categoryId) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String query = "SELECT * FROM Func_pagingProductByCategoryId(?,?,?)";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, pageNumber);
			ps.setInt(2, rowsOfPage);
			ps.setInt(3, categoryId);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public int countAll() {
		String query = "select * from Func_count(0,'%q%')";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(2);
			}
		} catch (Exception e) {

		}
		return 0;
	}

	public static void main(String[] args) {
		ProductDAOImpl iDaoImpl = new ProductDAOImpl();
		System.out.println(iDaoImpl.getBySearchAndPaging(2, 6, "Áo"));
		System.out.println(iDaoImpl.countBySearch("Giày"));
	}

	@Override
	public int countByCategory(int categoryId) {
		String query = "select * from Func_count(?,'%q%')";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, categoryId);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(3);
			}
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public ProductModel getTop1() {
		ProductModel Top1product = new ProductModel();
		String sql = "Select TOP 1* from Product order by Quantity DESC";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			Top1product = new ProductModel(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4),
					rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
		} catch (Exception e) {

		}
		return Top1product;

	}

	@Override
	public List<ProductModel> getTop4() {
		List<ProductModel> Top4product = new ArrayList<ProductModel>();
		String sql = "Select TOP 4* from Product order by Quantity DESC";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Top4product.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4),
						rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9)));
			}

		} catch (Exception e) {

		}
		return Top4product;

	}

	@Override
	public int countBySearch(String search) {
		String query = "select * from Func_count(0,?)";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%"+search+"%");
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(4);
			}
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public List<ProductModel> getBySearchAndPaging(int pageNumber, int rowsOfPage, String search) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String query = "SELECT * FROM Func_pagingProductBySearch(?,?,?)";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, pageNumber);
			ps.setInt(2, rowsOfPage);
			ps.setString(3, "%" + search + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
