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

@WebServlet(urlPatterns = { "/account/changepassword" })
public class ChangePasswordController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6406768111735681040L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		if (session.getAttribute("user") != null) {
			UserModel userModel = (UserModel) session.getAttribute("user");
			System.out.println(userModel.toString());
			if (userModel != null && userModel.getRoleId() == 2) {
				req.getRequestDispatcher("/views/account/changepassword.jsp").forward(req, resp);
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
		String oldPassword = req.getParameter("oldpassword");
		String newPassword = req.getParameter("newpassword");
		String confirmNewPassword = req.getParameter("confirmnewpassword");
		String mess = "";
		UserModel userModel = (UserModel) session.getAttribute("user");
		// Xử lí mật khẩu cũ đúng không
		if (oldPassword.equals(userModel.getPassword())) {
			//Xử lí mật khẩu mới có bằng nhau không
			if (newPassword.equals(confirmNewPassword)) {
				
				if(oldPassword.equals(newPassword)) {
					mess = "Mật khẩu mới phải khác mật khẩu cũ";
					req.setAttribute("mess", mess);
					req.getRequestDispatcher("/views/account/changepassword.jsp").forward(req, resp);
				}else {
					UserService uService = new UserServiceImpl();
					uService.changePassword(userModel, newPassword, confirmNewPassword);
					mess = "Thay đổi mật khẩu thành công";
					req.setAttribute("mess", mess);
					req.getRequestDispatcher("/views/account/changepassword.jsp").forward(req, resp);
				}

			} else {
				mess = "Mật khẩu mới phải giống nhau";
				req.setAttribute("mess", mess);
				req.getRequestDispatcher("/views/account/changepassword.jsp").forward(req, resp);
			}

		} else {
			mess = "Mật khẩu cũ không đúng";
			req.setAttribute("mess", mess);
			req.getRequestDispatcher("/views/account/changepassword.jsp").forward(req, resp);
		}
	}
}
