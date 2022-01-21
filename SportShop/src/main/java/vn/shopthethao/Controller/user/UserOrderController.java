package vn.shopthethao.Controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.shopthethao.Model.CartModel;
import vn.shopthethao.Model.OrderDetailModel;
import vn.shopthethao.Model.OrderModel;
import vn.shopthethao.Model.ProductModel;
import vn.shopthethao.Model.UserModel;
import vn.shopthethao.Service.CartDetailService;
import vn.shopthethao.Service.CartService;
import vn.shopthethao.Service.CategoryService;
import vn.shopthethao.Service.OrderDetailService;
import vn.shopthethao.Service.OrderService;
import vn.shopthethao.Service.ProductService;
import vn.shopthethao.Service.Impl.CartDetailServiceImpl;
import vn.shopthethao.Service.Impl.CartServiceImpl;
import vn.shopthethao.Service.Impl.CategoryServiceImpl;
import vn.shopthethao.Service.Impl.OrderDetailServiceImpl;
import vn.shopthethao.Service.Impl.OrderServiceImpl;
import vn.shopthethao.Service.Impl.ProductServiceImpl;

@WebServlet(urlPatterns = {"/account/orders"})
public class UserOrderController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8210395359747663271L;
	
	ProductService productService = new ProductServiceImpl();
	OrderService orderService = new OrderServiceImpl();
	OrderDetailService orderDetaiService = new OrderDetailServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		UserModel userModel = (UserModel)session.getAttribute("user");
		
		List<OrderModel> listorder = new ArrayList<OrderModel>(); 
		listorder = orderService.getAll(userModel.getId());
		
		
		for (int i =0; i < listorder.size(); i++) {
			List<OrderDetailModel> listorderdetail = new ArrayList<OrderDetailModel>();
			listorderdetail = orderDetaiService.getAll(listorder.get(i).getId());
			for(int j=0; j < listorderdetail.size(); j++) {
				ProductModel product = new ProductModel();
				product = productService.get(listorderdetail.get(j).getProductid());
				listorderdetail.get(j).setProductmodel(product);
			}
			listorder.get(i).setListorderdetail(listorderdetail);
		}
		
		
		req.setAttribute("listorderModel", listorder);
		req.getRequestDispatcher("/views/account/orders.jsp").forward(req, resp);
	}
	
}
