package DiamondShop.Controller.User;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import DiamondShop.Service.User.HomeServiceImplement;

@Controller
public class BaseController {
	@Autowired
	HomeServiceImplement _homeService;
	
	public ModelAndView _mvShare = new ModelAndView();
	
	@PostConstruct
	public ModelAndView init() {
		_mvShare.addObject("menu", _homeService.getDataMenu());
		return _mvShare;
	}
}
