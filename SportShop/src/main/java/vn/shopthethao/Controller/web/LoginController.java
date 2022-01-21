package vn.shopthethao.Controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.shopthethao.Model.CartDetailModel;
import vn.shopthethao.Model.CartModel;
import vn.shopthethao.Model.UserModel;
import vn.shopthethao.Service.CartDetailService;
import vn.shopthethao.Service.CartService;
import vn.shopthethao.Service.UserService;
import vn.shopthethao.Service.Impl.CartDetailServiceImpl;
import vn.shopthethao.Service.Impl.CartServiceImpl;
import vn.shopthethao.Service.Impl.UserServiceImpl;

@WebServlet(urlPatterns="/account/login")
public class LoginController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		req.getRequestDispatcher("/views/account/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UserService userService = new UserServiceImpl();
		CartService cartService = new CartServiceImpl();
		CartDetailService cartdetailService = new CartDetailServiceImpl();
		//Check login
		if(userService.checkLogin(username, password)) {
			UserModel userModel = userService.get(username);
			CartModel cartModel = cartService.get(userModel.getId());
			List<CartDetailModel> cartdetailModel = cartdetailService.get(cartModel.getId());
			cartModel.setListcartdetail(cartdetailModel);
			HttpSession session = req.getSession();
			session.setAttribute("user", userModel);
			session.setAttribute("cart", cartModel);
			//PhÃ¢n quyá»�n
			req.setAttribute("mess", "Đăng nhập thành công");
			if(userModel.getRoleId()==1) {
				resp.sendRedirect(req.getContextPath()+"/admin"); // Náº¿u admin thÃ¬ Ä‘Æ°a qua trang admin
			}
			else {
				resp.sendRedirect(req.getContextPath()+"/home");
			}
		}else {
			req.setAttribute("mess", "Tên đăng nhập hoặc mật khẩu không đúng");
			req.getRequestDispatcher("/views/account/login.jsp").forward(req, resp);
		}
	}
}
