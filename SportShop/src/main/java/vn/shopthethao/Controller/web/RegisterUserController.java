package vn.shopthethao.Controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.shopthethao.Model.CartModel;
import vn.shopthethao.Model.UserModel;
import vn.shopthethao.Service.UserService;
import vn.shopthethao.Service.Impl.UserServiceImpl;

@WebServlet(urlPatterns= {"/account/register"})
public class RegisterUserController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4130115307089973753L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		req.getRequestDispatcher("/views/account/register.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String repassword = req.getParameter("repassword");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String gender = req.getParameter("gender");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		UserService uService = new UserServiceImpl();
		if(!uService.checkExistUsername(username)) {
			if(password.equals(repassword)) {
				UserModel uuUserModel = new UserModel(username, password, fname, lname, gender, phone, email, address);			
				System.out.print(uuUserModel.toString());
				uService.insert(uuUserModel);
				
				resp.sendRedirect(req.getContextPath()+"/account/login");
			}
			else {
				System.out.println("Mat khau nhap lai phai trung");
			}

		}
		else {
			System.out.println("Ten dang nhap ton tai");
		}
	}
}
