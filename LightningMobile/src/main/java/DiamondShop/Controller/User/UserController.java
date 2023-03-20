package DiamondShop.Controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamondShop.Dto.ProductDto;
import DiamondShop.Entity.User;
import DiamondShop.Service.User.AccountServiceImplement;

@Controller
public class UserController extends BaseController {
	@Autowired
	AccountServiceImplement accountService = new AccountServiceImplement();
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView Register() {
		_mvShare.setViewName("user/account/register");
		_mvShare.addObject("user", new User());
		_mvShare.addObject("productsearch", new ProductDto());
		_mvShare.addObject("categories", _homeService.getDataCategory());
		return _mvShare;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView Create(@ModelAttribute("user") User user) {
		int count = accountService.addAccount(user);
		if(count > 0) {
			_mvShare.addObject("status", "Đăng ký thành công!");
		}
		else {
			_mvShare.addObject("status", "Đăng ký thất bại!");
		}
		_mvShare.setViewName("user/account/register");
		return _mvShare;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView Login(HttpSession session, @ModelAttribute("user") User user) {
		user = accountService.checkAccount(user);
		if(user != null && user.getRole().equals("user") == true) {
			_mvShare.setViewName("redirect:homepage");
			session.setAttribute("LoginSession", user);
		}
		else if(user != null && user.getRole().equals("user") == false) {
			_mvShare.setViewName("redirect:/admin");
			session.setAttribute("LoginSession", user);
		}
		else {
			_mvShare.addObject("login", "Đăng nhập thất bại!");
		}
		return _mvShare;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String Logout(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("LoginSession");
		return "redirect:" + request.getHeader("Referer");
	}
}
