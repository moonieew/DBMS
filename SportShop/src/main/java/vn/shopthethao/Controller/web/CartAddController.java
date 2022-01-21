package vn.shopthethao.Controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.shopthethao.DAO.CartDAO;
import vn.shopthethao.DAO.CartDetailDAO;
import vn.shopthethao.DAO.Impl.CartDAOImpl;
import vn.shopthethao.DAO.Impl.CartDetailDAOImpl;
import vn.shopthethao.Model.CartDetailModel;
import vn.shopthethao.Model.CartModel;
import vn.shopthethao.Model.CategoryModel;
import vn.shopthethao.Model.ProductModel;
import vn.shopthethao.Service.CartDetailService;
import vn.shopthethao.Service.CartService;
import vn.shopthethao.Service.CategoryService;
import vn.shopthethao.Service.ProductService;
import vn.shopthethao.Service.Impl.CartDetailServiceImpl;
import vn.shopthethao.Service.Impl.CartServiceImpl;
import vn.shopthethao.Service.Impl.CategoryServiceImpl;
import vn.shopthethao.Service.Impl.ProductServiceImpl;

@WebServlet(urlPatterns = {"/cart-add"})
public class CartAddController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6123093175183379188L;
	
	ProductService productService = new ProductServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();
	CartService cartService = new CartServiceImpl();
	CartDetailService cartDetailService = new CartDetailServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String productid = req.getParameter("pid");
		String qtity = req.getParameter("quantity");
		
		int pid = Integer.parseInt(productid);
		int quantity = Integer.parseInt(qtity);
		
		ProductModel product = productService.get(pid);
		
		CartModel cartModel = new CartModel();
		
		HttpSession session = req.getSession();
		cartModel = (CartModel)session.getAttribute("cart");
		
		List<CartDetailModel> listCartDetail = cartModel.getListcartdetail();
		int flag = -1;	// = -1 chua ton tai san pham trong gio hang
		for(int i=0; i < listCartDetail.size(); i++) {
			int productIDold = listCartDetail.get(i).getProductid();
			if (productIDold == pid) {
				flag=i;		// != -1 da ton tai san pham trong gio hang (vi tri thu i)
				break;
			}
		}
		
		if(flag == -1) {
			double price = (product.getPrice() - product.getSalePrice()) * quantity;
			listCartDetail.add(new CartDetailModel(pid,cartModel.getId(),price, quantity, product));
			
			
			int new_cart_quantity = cartModel.getQuantity() + 1;
			double new_cart_total = cartModel.getTotal() + price;
			double new_cart_grandtotal = new_cart_total + cartModel.getShipping();
			cartModel.setQuantity(new_cart_quantity);
			cartModel.setTotal(new_cart_total);
			cartModel.setGrandTotal(new_cart_grandtotal);
			cartModel.setListcartdetail(listCartDetail);
			
			cartService.edit(cartModel.getId(), new_cart_quantity, cartModel.getShipping(), new_cart_total, new_cart_grandtotal);
			cartDetailService.register(pid, cartModel.getId(), price, quantity);
			
			session.setAttribute("cart", cartModel);
			resp.sendRedirect(req.getContextPath()+"/cart");
		}
		else {
			
			int new_quantity = listCartDetail.get(flag).getQuantity() + quantity;
			listCartDetail.get(flag).setQuantity(new_quantity);
			
			double new_price = (product.getPrice() - product.getSalePrice()) * new_quantity;
			
			double gia_chenh_lech = new_price - listCartDetail.get(flag).getPrice();
			listCartDetail.get(flag).setPrice(new_price);
			
			double new_cart_total = cartModel.getTotal() + gia_chenh_lech;
			double new_cart_grandtotal = new_cart_total + cartModel.getShipping();
			
			cartModel.setTotal(new_cart_total);
			cartModel.setGrandTotal(new_cart_grandtotal);
			cartModel.setListcartdetail(listCartDetail);
			
			
			cartDetailService.edit(pid, cartModel.getId(), new_price, new_quantity);
			
			cartService.edit(cartModel.getId(), cartModel.getQuantity(), cartModel.getShipping(), new_cart_total, new_cart_grandtotal);
			
			session.setAttribute("cart", cartModel);
			resp.sendRedirect(req.getContextPath()+"/cart");
		}
		
		
		
		//req.getRequestDispatcher("/views/web/product.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	

}
