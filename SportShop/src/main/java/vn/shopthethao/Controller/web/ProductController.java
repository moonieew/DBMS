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

@WebServlet(urlPatterns = { "/product" })
public class ProductController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -725363688494302392L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		ProductService productService = new ProductServiceImpl();
		CategoryService categoryService = new CategoryServiceImpl();

		String indexPage = req.getParameter("index");
		String cid = req.getParameter("cid");

		if (indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);

		int endP = 0;
		int countProduct = 0;

		if ("0".equals(cid)) {

			countProduct = productService.countAll();
			endP = countProduct / 6;
			if (countProduct % 6 != 0) {
				endP++;
			}

			List<ProductModel> listAllProduct = productService.getAllByPaging(index, 6);
			req.setAttribute("listProduct", listAllProduct);
		} else {

			try {
				countProduct = productService.countByCategory(Integer.parseInt(cid));
				endP = countProduct / 6;
				if (countProduct % 6 != 0) {
					endP++;
				}
				List<ProductModel> listProductByCategoryId = productService.getByCategoryAndPaging(index, 6,
						Integer.parseInt(cid));
				req.setAttribute("listProduct", listProductByCategoryId);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		ProductModel topProduct = productService.getTop1();
		List<CategoryModel> listCategory = categoryService.getAllCategory();

		req.setAttribute("topProduct", topProduct);
		req.setAttribute("listCategory", listCategory);
		req.setAttribute("pageOfProduct", endP);
		req.setAttribute("tagCategory", cid);
		req.setAttribute("tagIndex", index);

		req.getRequestDispatcher("/views/web/product.jsp").forward(req, resp);
	}
}
