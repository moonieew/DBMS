package vn.shopthethao.Controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.shopthethao.Model.UserModel;
import vn.shopthethao.Service.UserService;
import vn.shopthethao.Service.Impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/admin/user/delete"})
public class UserDeleteController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("deleteId");// Lấy biến Id trên url
		UserService uService = new UserServiceImpl();

		try {
			UserModel userModel = uService.get(Integer.parseInt(id));// Lấy người dùng cần xoá
			uService.delete(userModel); // Xoá người dùng

		} catch (Exception e) {
			
		}
		resp.sendRedirect("list");
	}
}
