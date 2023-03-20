package DiamondShop.Controller.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamondShop.Entity.User;
import DiamondShop.Service.Admin.AdminAccountServiceImplement;
import DiamondShop.Service.Admin.IAdminAccountService;

@Controller
public class AdminAccountController extends AdminBaseController {
	@Autowired
	IAdminAccountService accService;
	
	@RequestMapping(value = "/admin/add-admin", method = RequestMethod.GET)
	public ModelAndView AddAdminAccount() {
		_mv.setViewName("admin/account/addadmin");
		_mv.addObject("admin", new User());
		return _mv;
	}
	
	@RequestMapping(value = "/admin/login", method = RequestMethod.GET)
	public ModelAndView AdminLogin() {
		_mv.setViewName("admin/account/login");
		_mv.addObject("admin", new User());
		return _mv;
	}
	
	@RequestMapping(value = "/admin/add-admin", method = RequestMethod.POST)
	public ModelAndView AddAdmin(@ModelAttribute("admin") User admin) {
		int count = accService.addAdminAccount(admin);
		if(count > 0) {
			_mv.addObject("status", "Đăng ký thành công!");
		}
		else {
			_mv.addObject("status", "Đăng ký thất bại!");
		}
		_mv.setViewName("admin/account/addadmin");
		return _mv;
	}
	
	@RequestMapping(value = "/admin/login", method = RequestMethod.POST)
	public ModelAndView AdminLogin(HttpSession session, @ModelAttribute("admin") User admin) {
		admin = accService.checkAdminAccount(admin);
		if(admin != null) {
				_mv.setViewName("redirect:/admin");
				session.setAttribute("AdminSession", admin);
		}
		else {
			_mv.addObject("login", "Đăng nhập thất bại!");
		}
		return _mv;
	}
	
	@RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
	public String AdminLogout(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("AdminSession");
		return "redirect:" + request.getHeader("Referer");
	}
}
