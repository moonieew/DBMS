package vn.shopthethao.Controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.shopthethao.Model.CategoryModel;
import vn.shopthethao.Service.CategoryService;
import vn.shopthethao.Service.ProductService;
import vn.shopthethao.Service.Impl.CategoryServiceImpl;
import vn.shopthethao.Service.Impl.ProductServiceImpl;

@WebServlet(urlPatterns = {"/cart"})
public class CartController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7359167047819586609L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		
		ProductService productService = new ProductServiceImpl();
		CategoryService categoryService = new CategoryServiceImpl();
		
		
		List<CategoryModel> listCategory = categoryService.getAllCategory();
		
		
		req.setAttribute("listCategory", listCategory);
		
		
		req.getRequestDispatcher("/views/web/cart-list.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
