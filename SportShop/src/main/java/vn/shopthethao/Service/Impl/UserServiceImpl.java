package vn.shopthethao.Service.Impl;

import java.util.List;

import vn.shopthethao.DAO.UserDAO;
import vn.shopthethao.DAO.Impl.UserDAOImpl;
import vn.shopthethao.Model.UserModel;
import vn.shopthethao.Service.UserService;

public class UserServiceImpl implements UserService {
	UserDAO userdao = new UserDAOImpl();
	@Override
	public void insert(UserModel user) {
		userdao.insert(user);
	}

	@Override
	public void edit(UserModel user) {
		userdao.edit(user);
		
	}

	@Override
	public void delete(UserModel user) {
		userdao.delete(user);
		
	}

	@Override
	public List<UserModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> getByPaging(int pageNumber, int rowsOfPage) {
		return userdao.getByPaging(pageNumber, rowsOfPage);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userdao.checkExistUsername(username);
	}

	@Override
	public int countAll() {
		return userdao.countAll();
	}

	@Override
	public UserModel get(int id) {
		return userdao.get(id);
	}

	@Override
	public void insertAdmin(UserModel user) {
		userdao.insertAdmin(user);
	}

	@Override
	public boolean checkLogin(String username, String password) {
		return userdao.checkLogin(username, password);
	}

	@Override
	public UserModel get(String username) {
		return userdao.get(username);
	}

	@Override
	public void changePassword(UserModel user, String newPassword, String reNewPassword) {
		userdao.changePassword(user, newPassword, reNewPassword);
		
	}


}
