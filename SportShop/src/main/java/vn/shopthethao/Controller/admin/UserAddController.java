package vn.shopthethao.Controller.admin;

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

@WebServlet(urlPatterns = { "/admin/user/add" })
public class UserAddController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4332736011939664798L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		if (session.getAttribute("user") != null) {
			UserModel userModel = (UserModel) session.getAttribute("user");
			System.out.println(userModel.toString());
			if (userModel != null && userModel.getRoleId() == 1) {
				req.getRequestDispatcher("/views/admin/add-user.jsp").forward(req, resp);
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

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String gender = req.getParameter("gender");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		UserService uService = new UserServiceImpl();
		if (!uService.checkExistUsername(username)) {
			UserModel uuUserModel = new UserModel(username, password, fname, lname, gender, phone, email, address);
			System.out.print(uuUserModel.toString());
			uService.insertAdmin(uuUserModel);
			resp.sendRedirect(req.getContextPath() + "/admin/user/list");
		} else {

		}
	}

}
