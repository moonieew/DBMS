package vn.shopthethao.Controller.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.shopthethao.Model.CartDetailModel;
import vn.shopthethao.Model.CartModel;
import vn.shopthethao.Model.OrderModel;
import vn.shopthethao.Service.CartDetailService;
import vn.shopthethao.Service.CartService;
import vn.shopthethao.Service.OrderDetailService;
import vn.shopthethao.Service.OrderService;
import vn.shopthethao.Service.Impl.CartDetailServiceImpl;
import vn.shopthethao.Service.Impl.CartServiceImpl;
import vn.shopthethao.Service.Impl.OrderDetailServiceImpl;
import vn.shopthethao.Service.Impl.OrderServiceImpl;

@WebServlet(urlPatterns = {"/order-add"})
public class AddOrderController extends HttpServlet{

	
	private static final long serialVersionUID = 662517952497709317L;
	OrderService orderService = new OrderServiceImpl();
	OrderDetailService orderDetaiService = new OrderDetailServiceImpl();
	CartService cartService = new CartServiceImpl();
	CartDetailService cartDetailService = new CartDetailServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		CartModel cartModel = new CartModel();
		HttpSession session = req.getSession();
		cartModel = (CartModel)session.getAttribute("cart");
		
		orderService.insert(cartModel);
		int orderid = orderService.getNewID(cartModel.getUserId());
		
		
		List<CartDetailModel> listCartDetail = cartModel.getListcartdetail();
		CartDetailModel cartDetailModel = new CartDetailModel();
		
		for(int i=0; i < listCartDetail.size(); i++) {
			cartDetailModel = listCartDetail.get(i);
			orderDetaiService.insert(orderid,cartDetailModel);
			
			
		}
		
		List<CartDetailModel> newlist = new ArrayList<CartDetailModel>();
		cartModel.setListcartdetail(newlist);
		cartModel.setQuantity(0);
		cartModel.setTotal(0);
		cartModel.setGrandTotal(0);
		
		
		cartDetailService.deleteAll(cartModel.getId());
		cartService.edit(cartModel.getId(), 0, cartModel.getShipping(), 0, 0);
		
		
		
		session.setAttribute("cart", cartModel);
		resp.sendRedirect(req.getContextPath()+"/cart");
	}

}
