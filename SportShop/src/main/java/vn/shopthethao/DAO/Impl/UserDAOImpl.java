package vn.shopthethao.DAO.Impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.shopthethao.Connection.MYDB;
import vn.shopthethao.DAO.ProductDAO;
import vn.shopthethao.DAO.UserDAO;
import vn.shopthethao.Model.UserModel;

public class UserDAOImpl implements UserDAO {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public CallableStatement CSS = null;
	ResultSet rs = null;

	@Override
	public void insert(UserModel user) {
		String query = "{call dbo.SP_RegisterUser(?,?,?,?,?,?,?,?)}";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFname());
			ps.setString(4, user.getLname());
			ps.setString(5, user.getGender());
			ps.setString(6, user.getPhone());
			ps.setString(7, user.getEmail());
			ps.setString(8, user.getPassword());
			ps.executeUpdate();
		} catch (Exception e) {

		}

	}

	@Override
	public void edit(UserModel user) {
		String query = "{call dbo.SP_ChangeInfo(?,?,?,?,?,?)}";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getFname());
			ps.setString(3, user.getLname());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getAddress());

			ps.executeUpdate();
		} catch (Exception e) {

		}

	}

	@Override
	public void delete(UserModel user) {
		String query = "{call dbo.SP_DeleteUser(?)}";

		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, user.getId());
			ps.executeUpdate();
			System.out.println("Xoá người dùng thành công");
			System.out.println(user.toString());
			if (rs.next()) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<UserModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> getByPaging(int pageNumber, int rowsOfPage) {
		List<UserModel> list = new ArrayList<UserModel>();
		String query = "SELECT * FROM Func_pagingUser(? , ?)";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, pageNumber);
			ps.setInt(2, rowsOfPage);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new UserModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public boolean checkExistUsername(String username) {
		String query = "select * from [Users] where username = ?";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {

		}
		return false;
	}

	

	@Override
	public int countAll() {
		String query = "select * from Func_count(0,'%q%')";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public UserModel get(int id) {
		String query = "select * from [User] where id = ?";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				return new UserModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10));
			}
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public void insertAdmin(UserModel user) {
		String query = "{call dbo.SP_RegisterAdmin(?,?,?,?,?,?,?,?)}";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFname());
			ps.setString(4, user.getLname());
			ps.setString(5, user.getGender());
			ps.setString(6, user.getPhone());
			ps.setString(7, user.getEmail());
			ps.setString(8, user.getPassword());
			ps.executeUpdate();
		} catch (Exception e) {

		}

	}

	@Override
	public boolean checkLogin(String username, String password) {
		String query = "SELECT dbo.Func_CheckLogin(?, ?)";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				int flag = rs.getInt(1);
				if (flag == 1) {
					System.out.println(flag);
					return true;
				}
			}
		} catch (Exception e) {

		}
		return false;
	}

	@Override
	public UserModel get(String username) {
		String query = "select * from [User] where username = ?";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				return new UserModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10));
			}
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public void changePassword(UserModel user, String newPassword, String reNewPassword) {
		String query = "{call dbo.SP_ChangePassword(?,?,?,?)}";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, newPassword);
			ps.setString(4, reNewPassword);
			ps.executeUpdate();
			System.out.println("Change password success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		UserDAO uDao = new UserDAOImpl();
		UserModel user = uDao.get(20);
		uDao.delete(user);
		
	}
	
	

}
