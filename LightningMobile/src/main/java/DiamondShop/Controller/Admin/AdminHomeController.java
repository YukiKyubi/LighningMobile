package DiamondShop.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminHomeController extends AdminBaseController {
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView Index() {
		_mv.setViewName("admin/index");
		return _mv;
	}
}
