package vn.shopthethao.Controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.shopthethao.Model.CategoryModel;
import vn.shopthethao.Model.ProductModel;
import vn.shopthethao.Service.CategoryService;
import vn.shopthethao.Service.ProductService;
import vn.shopthethao.Service.Impl.CategoryServiceImpl;
import vn.shopthethao.Service.Impl.ProductServiceImpl;
@WebServlet(urlPatterns = {"/logout"})
public class LogoutController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4655323855872061357L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		session.removeAttribute("user");
		session.removeAttribute("cart");
		
		ProductService productService = new ProductServiceImpl();
		CategoryService categoryService = new CategoryServiceImpl();
		
		List<ProductModel> top4product = productService.getTop4();
		ProductModel topProduct = productService.getTop1();
		List<CategoryModel> listCategory = categoryService.getAllCategory();
		
		req.setAttribute("listCategory", listCategory);
		req.setAttribute("list4product", top4product);
		req.setAttribute("topProduct", topProduct);
		
		RequestDispatcher rq = req.getRequestDispatcher("/views/web/home.jsp");
		rq.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
