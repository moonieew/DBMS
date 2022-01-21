package vn.shopthethao.Controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import vn.shopthethao.Model.ProductModel;
import vn.shopthethao.Model.UserModel;
import vn.shopthethao.Service.ProductService;

import vn.shopthethao.Service.Impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/admin/product/list" })
public class ProductListController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		if (session.getAttribute("user") != null) {
			UserModel userModel = (UserModel) session.getAttribute("user");
			System.out.println(userModel.toString());
			if (userModel != null && userModel.getRoleId() == 1) {
				String indexPage = req.getParameter("index");
				ProductService productService = new ProductServiceImpl();
				// Xử lí lấy Parameter từ url xuống
				if (indexPage == null) {
					indexPage = "1";
				}
				int index = Integer.parseInt(indexPage);

				// Xử lí phân trang
				int countAllUser = productService.countAll();
				int endP = countAllUser / 5;
				if (countAllUser % 5 != 0) {
					endP++;
				}

				List<ProductModel> productModels = productService.getAllByPaging(index, 5);
				// Xử lí đẩy từng biến lên jsp
				req.setAttribute("getProductByPagging", productModels); // Đẩy list User lên
				req.setAttribute("tag", index); //
				req.setAttribute("countPageProduct", endP);
				req.getRequestDispatcher("/views/admin/list-product.jsp").forward(req, resp);

			} else {
				resp.sendRedirect(req.getContextPath() + "/account/login");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/account/login");
		}

	}
}
