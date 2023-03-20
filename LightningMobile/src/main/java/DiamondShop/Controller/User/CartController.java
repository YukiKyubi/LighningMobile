package DiamondShop.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamondShop.Dto.CartDto;
import DiamondShop.Dto.ProductDto;
import DiamondShop.Entity.Bill;
import DiamondShop.Entity.User;
import DiamondShop.Service.User.BillServiceImplement;
import DiamondShop.Service.User.CartServiceImplement;

@Controller
public class CartController extends BaseController {
	@Autowired
	private CartServiceImplement cartService = new CartServiceImplement();
	
	@Autowired
	private BillServiceImplement billService = new BillServiceImplement();
	
	@RequestMapping(value = { "/cart" })
	public ModelAndView Index() {
		_mvShare.addObject("slides", _homeService.getDataSlide());
		_mvShare.addObject("categories", _homeService.getDataCategory());
		_mvShare.addObject("products", _homeService.getDataProduct());
		_mvShare.addObject("productsearch", new ProductDto());
		_mvShare.setViewName("user/cart/cart");
		return _mvShare;
	}
	
	@RequestMapping("addtoCart/{id}")
	public String addToCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.addToCart(id, cart);
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantity", cartService.totalQuantity(cart));
		session.setAttribute("totalPrice", cartService.totalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping("editCart/{id}/{quantity}")
	public String editCart(HttpServletRequest request, HttpSession session, @PathVariable long id, @PathVariable int quantity) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.editCart(id, quantity, cart);
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantity", cartService.totalQuantity(cart));
		session.setAttribute("totalPrice", cartService.totalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping("deleteCart/{id}")
	public String deleteCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.deleteToCart(id, cart);
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantity", cartService.totalQuantity(cart));
		session.setAttribute("totalPrice", cartService.totalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView checkOut(HttpServletRequest request, HttpSession session) {
		_mvShare.setViewName("/user/bill/checkout");
		Bill bill = new Bill();
		User loginUser = (User)session.getAttribute("LoginSession");
		if(loginUser !=  null) {
			bill.setAddress(loginUser.getAddress());
			bill.setDisplay_name(loginUser.getDisplay_name());
			bill.setUsername(loginUser.getUsername());
		}
		_mvShare.addObject("bill", bill);
		return _mvShare;
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String checkOutBill(HttpServletRequest request, HttpSession session, @ModelAttribute("bill") Bill bill) {
		bill.setQuantity(Integer.parseInt(session.getAttribute("totalQuantity").toString()));
		bill.setTotal(Double.parseDouble(session.getAttribute("totalPrice").toString()));
		if(billService.addBill(bill) > 0) {
			HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("cart");
			billService.addBillDetails(cart);
		}
		session.removeAttribute("cart");
		return "redirect:cart";
	}
}
