package vn.shopthethao.Controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.shopthethao.Model.CategoryModel;
import vn.shopthethao.Model.ProductModel;
import vn.shopthethao.Service.CategoryService;
import vn.shopthethao.Service.ProductService;
import vn.shopthethao.Service.Impl.CategoryServiceImpl;
import vn.shopthethao.Service.Impl.ProductServiceImpl;

@WebServlet(urlPatterns = {"/search"})
public class SearchProductController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1215379351714297228L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String search = req.getParameter("search");
		ProductService productService = new ProductServiceImpl();
		CategoryService categoryService = new CategoryServiceImpl();

		// Xử lí lấy Parameter từ url xuống
		String indexPage = req.getParameter("index");
		if (indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);

		// Bắt đầu phân trang
		int countProduct = productService.countBySearch(search);
		int endP = countProduct / 6;
		if (countProduct % 6 != 0) {
			endP++;
		}
		// List chứa sản phẩm theo kết quả (đã phân trang)

		List<ProductModel> listProduct = productService.getBySearchAndPaging(index, 6, search);

		///// Xử lí danh mục trang
		List<CategoryModel> listCategory = categoryService.getAllCategory();
		ProductModel topProduct = productService.getTop1();
		
		///// Đưa các đối tượng lên jsp
		req.setAttribute("topProduct", topProduct);
		req.setAttribute("listCategory", listCategory);
		req.setAttribute("listProduct", listProduct);
		req.setAttribute("searchValue", search);
		req.setAttribute("pageOfProduct", endP); // Tổng số trang của sản phẩm theo Category||Tất cả
		req.setAttribute("tagIndex", index);// Trang hiện tại của web
		req.getRequestDispatcher("/views/web/product.jsp").forward(req, resp);
	}

}
