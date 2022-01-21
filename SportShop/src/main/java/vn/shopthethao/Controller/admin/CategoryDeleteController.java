package vn.shopthethao.Controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.shopthethao.Model.CategoryModel;
import vn.shopthethao.Model.UserModel;
import vn.shopthethao.Service.CategoryService;
import vn.shopthethao.Service.UserService;
import vn.shopthethao.Service.Impl.CategoryServiceImpl;
import vn.shopthethao.Service.Impl.UserServiceImpl;

@WebServlet(urlPatterns= {"/admin/category/delete"})
public class CategoryDeleteController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("deleteId");// Lấy biến Id trên url
		CategoryService categoryService = new CategoryServiceImpl();
		

		try {
			CategoryModel categoryModel = new CategoryModel(Integer.parseInt(id));// Lấy cate theo id
			categoryService.delete(categoryModel); // Xoá category
		} catch (Exception e) {
			
		}
		resp.sendRedirect("list");
	}

}
