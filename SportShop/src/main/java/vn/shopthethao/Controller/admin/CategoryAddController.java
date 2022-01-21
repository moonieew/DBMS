package vn.shopthethao.Controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.shopthethao.Model.CategoryModel;
import vn.shopthethao.Model.UserModel;
import vn.shopthethao.Service.CategoryService;
import vn.shopthethao.Service.Impl.CategoryServiceImpl;


@WebServlet(urlPatterns = {"/admin/category/add"})
public class CategoryAddController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1539422996739265693L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		if (session.getAttribute("user") != null) {
			UserModel userModel = (UserModel) session.getAttribute("user");
			System.out.println(userModel.toString());
			if (userModel != null && userModel.getRoleId() == 1) {
				req.getRequestDispatcher("/views/admin/add-category.jsp").forward(req, resp);
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
		
		String name = req.getParameter("categoryname");
		System.out.println(name);
		CategoryService categoryService = new CategoryServiceImpl();
		if(!name.equals(null)) {
			CategoryModel categoryModel = new CategoryModel(name);
			System.out.print(categoryModel.toString());
			categoryService.insert(categoryModel);
			resp.sendRedirect(req.getContextPath()+"/admin/category/list");
		}
		else {
			
		}
	}
	
}
