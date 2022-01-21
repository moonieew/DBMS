package vn.shopthethao.Controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.shopthethao.Model.CartDetailModel;
import vn.shopthethao.Model.CartModel;
import vn.shopthethao.Service.CartDetailService;
import vn.shopthethao.Service.CartService;
import vn.shopthethao.Service.CategoryService;
import vn.shopthethao.Service.ProductService;
import vn.shopthethao.Service.Impl.CartDetailServiceImpl;
import vn.shopthethao.Service.Impl.CartServiceImpl;
import vn.shopthethao.Service.Impl.CategoryServiceImpl;
import vn.shopthethao.Service.Impl.ProductServiceImpl;

@WebServlet(urlPatterns = {"/cart-remove"})
public class CartRemoveController extends HttpServlet {


	private static final long serialVersionUID = 3398451706388715466L;
	
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
		int pid = Integer.parseInt(productid);
		
		
		
		HttpSession session = req.getSession();
		CartModel cartModel = new CartModel();
		cartModel = (CartModel)session.getAttribute("cart");
		
		List<CartDetailModel> listCartDetail = cartModel.getListcartdetail();
		
		for(int i=0; i < listCartDetail.size(); i++) {
			if (listCartDetail.get(i).getProductid() == pid) {
				CartDetailModel cartDetailModel = listCartDetail.get(i);
				listCartDetail.remove(i);
				
				double price = cartDetailModel.getPrice();
				double new_cart_total = cartModel.getTotal() - price;
				double new_cart_grandtotal = new_cart_total + cartModel.getShipping();
				int new_cart_quantity = cartModel.getQuantity() - 1;
				
				cartModel.setQuantity(new_cart_quantity);
				cartModel.setTotal(new_cart_total);
				cartModel.setGrandTotal(new_cart_grandtotal);
				cartModel.setListcartdetail(listCartDetail);
				
				cartDetailService.delete(pid, cartModel.getId());
				cartService.edit(cartModel.getId(), new_cart_quantity, cartModel.getShipping(), new_cart_total, new_cart_grandtotal);
				break;
			}
		}
		
		
		session.setAttribute("cart", cartModel);
		resp.sendRedirect(req.getContextPath()+"/cart");
	}
	
}
