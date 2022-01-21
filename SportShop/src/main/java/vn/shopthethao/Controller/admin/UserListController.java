package vn.shopthethao.Controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import vn.shopthethao.Model.UserModel;

import vn.shopthethao.Service.UserService;

import vn.shopthethao.Service.Impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/admin/user/list" })
public class UserListController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8546439576683731462L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		if (session.getAttribute("user") != null) {
			UserModel userModel = (UserModel) session.getAttribute("user");
			if (userModel != null && userModel.getRoleId() == 1) {
				String indexPage = req.getParameter("index");// String indexPage trên url
				UserService uService = new UserServiceImpl();

				// Xử lí lấy Parameter từ url xuống
				if (indexPage == null) {
					indexPage = "1";
				}
				int index = Integer.parseInt(indexPage);

				// Xử lí phân trang
				int countAllUser = uService.countAll();
				int endP = countAllUser / 5;
				if (countAllUser % 5 != 0) {
					endP++;
				}
				// Xử lí các service
				List<UserModel> userModels = uService.getByPaging(index, 5);// Mỗi lần lấy 5 User

				// Xử lí đẩy từng biến lên jsp
				req.setAttribute("getUserByPagging", userModels); // Đẩy list User lên
				req.setAttribute("tag", index); //
				req.setAttribute("countPageUser", endP);
				req.getRequestDispatcher("/views/admin/list-user.jsp").forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + "/account/login");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/account/login");
		}

	}
}
