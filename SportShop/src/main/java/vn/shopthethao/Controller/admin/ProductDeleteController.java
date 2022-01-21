package vn.shopthethao.Controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.shopthethao.Model.ProductModel;

import vn.shopthethao.Service.ProductService;

import vn.shopthethao.Service.Impl.ProductServiceImpl;

@WebServlet(urlPatterns = "/admin/product/delete")
public class ProductDeleteController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String id = req.getParameter("deleteId");// Lấy biến Id trên url
		ProductService productService = new ProductServiceImpl();

		try {
			ProductModel productModel = productService.get(Integer.parseInt(id));// Lấy người dùng cần xoá
			productService.delete(productModel); // Xoá người dùng
		} catch (Exception e) {

		}
		resp.sendRedirect("list");
	}
}
