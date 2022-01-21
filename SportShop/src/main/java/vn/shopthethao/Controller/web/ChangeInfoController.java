package vn.shopthethao.Controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.shopthethao.Model.UserModel;
import vn.shopthethao.Service.UserService;
import vn.shopthethao.Service.Impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/account/changeinfor"})
public class ChangeInfoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2049114081478124778L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		if (session.getAttribute("user") != null) {
			UserModel userModel = (UserModel) session.getAttribute("user");
			System.out.println(userModel.toString());
			if (userModel != null && userModel.getRoleId() == 2) {
				req.getRequestDispatcher("/views/account/changeinfor.jsp").forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + "/account/login");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/account/login");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		UserService uService = new UserServiceImpl();
		UserModel userModel = (UserModel) session.getAttribute("user");
		int id = userModel.getId();
		String username = userModel.getUsername();
		String password = userModel.getPassword();
		String gender = userModel.getGender();
		int roleId = userModel.getRoleId();
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		UserModel newUser = new UserModel(id, username, password, fname, lname, gender, phone, email, address, roleId);
		try {
			uService.edit(newUser);
			System.out.println(newUser.toString());
			String mess = "Đổi thông tin thành công";
			req.setAttribute("mess", mess);
			session.setAttribute("user", newUser);//Sau khi đổi thông tin, đẩy session user mới lên
			req.getRequestDispatcher("/views/account/changeinfor.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
