package vn.shopthethao.Controller.admin;

import java.io.IOException;
import java.util.List;

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

@WebServlet(urlPatterns = {"/admin/category/list"})
public class CategoryListController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5772019834814689296L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		if (session.getAttribute("user") != null) {
			UserModel userModel = (UserModel) session.getAttribute("user");
			System.out.println(userModel.toString());
			if (userModel != null && userModel.getRoleId() == 1) {
				CategoryService categoryService = new CategoryServiceImpl();
				
				List<CategoryModel> listCategory = categoryService.getAllCategory();
				
				req.setAttribute("listCategory", listCategory);
				req.getRequestDispatcher("/views/admin/list-category.jsp").forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + "/account/login");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/account/login");
		}
		

	}
}
