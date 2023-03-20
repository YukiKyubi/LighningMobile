package DiamondShop.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamondShop.Dto.ProductDto;
import DiamondShop.Entity.User;

@Controller
public class HomeController extends BaseController {

	@RequestMapping(value = { "/", "/homepage" })
	public ModelAndView Index() {
		_mvShare.addObject("slides", _homeService.getDataSlide());
		_mvShare.addObject("categories", _homeService.getDataCategory());
		_mvShare.addObject("products", _homeService.getDataProduct());
		_mvShare.addObject("user", new User());
		_mvShare.addObject("productsearch", new ProductDto());
		_mvShare.setViewName("user/index");
		return _mvShare;
	}
}
