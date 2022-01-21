package vn.shopthethao.Controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/admin/order/list"})
public class OrderListController extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 866576196686994986L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		
		req.getRequestDispatcher("/views/admin/list-order.jsp").forward(req, resp);
	}
}
