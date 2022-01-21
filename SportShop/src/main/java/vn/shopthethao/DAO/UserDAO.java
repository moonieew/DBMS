package vn.shopthethao.DAO;

import java.util.List;

import vn.shopthethao.Model.UserModel;

public interface UserDAO {
	void insert(UserModel user); // Thêm người dùng
	void insertAdmin(UserModel user);// Thêm admin
	void edit(UserModel user); // Chỉnh sửa thông tin người dùng
	void changePassword(UserModel user, String newPassword, String reNewPassword); // Đổi mật khẩu
	void delete(UserModel user); // Xoá người dùng
	UserModel get(int id); // Lấy người dùng theo ID
	UserModel get(String username); // Lấy người dùng theo tên đăng nhập
	List<UserModel> search(String keyword); // Tìm kiếm người dùng
	List<UserModel> getByPaging(int pageNumber, int rowsOfPage); // Lấy toàn bộ người dùng theo trang
	boolean checkExistUsername(String username);
	boolean checkLogin(String username,String password);
	int countAll();
	
	
}
