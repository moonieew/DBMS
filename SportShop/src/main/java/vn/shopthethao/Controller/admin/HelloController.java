package vn.shopthethao.Controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.shopthethao.Model.UserModel;

@WebServlet(urlPatterns = {"/admin"})
public class HelloController extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2876935234770113412L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		if(session.getAttribute("user")!=null) {
			UserModel userModel = (UserModel)session.getAttribute("user");
			if(userModel!=null && userModel.getRoleId()==1) {
				req.getRequestDispatcher("/views/admin/index.jsp").forward(req, resp);
			}
			else {
				resp.sendRedirect(req.getContextPath()+"/account/login");
			}
		}
		else {
			resp.sendRedirect(req.getContextPath()+"/account/login");
		}

		
		
		
	}
}
