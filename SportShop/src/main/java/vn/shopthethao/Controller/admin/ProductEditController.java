package vn.shopthethao.Controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.shopthethao.Model.BrandModel;
import vn.shopthethao.Model.CategoryModel;
import vn.shopthethao.Model.ProductModel;
import vn.shopthethao.Model.UserModel;
import vn.shopthethao.Service.BrandService;
import vn.shopthethao.Service.CategoryService;
import vn.shopthethao.Service.ProductService;
import vn.shopthethao.Service.Impl.BrandServiceImpl;
import vn.shopthethao.Service.Impl.CategoryServiceImpl;
import vn.shopthethao.Service.Impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/admin/product/edit" })
public class ProductEditController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1948181445471275164L;

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
				BrandService brandService = new BrandServiceImpl();

				List<CategoryModel> categories = categoryService.getAllCategory();
				List<BrandModel> brands = brandService.getAllBrand();

				String id = req.getParameter("editId");

				req.setAttribute("categories", categories);
				req.setAttribute("brands", brands);
				req.setAttribute("productid", id);

				req.getRequestDispatcher("/views/admin/edit-product.jsp").forward(req, resp);
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

		String id = req.getParameter("productid");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String salePrice = req.getParameter("saleprice");
		String quantity = req.getParameter("quantity");
		String description = req.getParameter("description");
		String categoryId = req.getParameter("category");
		String brandId = req.getParameter("brand");
		String image = req.getParameter("image");
		System.out.println(id + name + price + salePrice + quantity + description + categoryId);
		ProductService productService = new ProductServiceImpl();
		try {
			ProductModel productModel = new ProductModel(Integer.parseInt(id), name, Double.parseDouble(price),
					Double.parseDouble(salePrice), Integer.parseInt(quantity), description, image,
					Integer.parseInt(brandId), Integer.parseInt(categoryId));
			System.out.println(productModel.toString());
			productService.edit(productModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect("list");
	}
}
