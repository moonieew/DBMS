package vn.shopthethao.Controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.shopthethao.Model.UserModel;

@WebServlet(urlPatterns = {"/account/information"})
public class UserInformationController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3441435891298977314L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
resp.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		if(session.getAttribute("user")!=null) {
			UserModel userModel = (UserModel)session.getAttribute("user");
			System.out.println(userModel.toString());
			if(userModel!=null && userModel.getRoleId()==2) {
				req.getRequestDispatcher("/views/account/information.jsp").forward(req, resp);
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
