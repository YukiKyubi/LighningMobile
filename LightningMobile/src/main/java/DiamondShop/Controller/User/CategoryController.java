package DiamondShop.Controller.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamondShop.Dto.PaginationDto;
import DiamondShop.Dto.ProductDto;
import DiamondShop.Service.User.CategoryServiceImplement;
import DiamondShop.Service.User.PaginationServiceImplement;

@Controller
public class CategoryController extends BaseController {
	@Autowired
	private CategoryServiceImplement categoryService;
	
	@Autowired
	private PaginationServiceImplement paginationService;
	
	private int totalPage = 9;
	
	@RequestMapping("/products/{id}")
	public ModelAndView Category(@PathVariable String id) {
		_mvShare.setViewName("user/products/category");
		int totalData = categoryService.getDataProductById(Integer.parseInt(id)).size();
		PaginationDto paginationInfo = paginationService.getInfoPagination(totalData, totalPage, 1);
		_mvShare.addObject("catId", id);
		_mvShare.addObject("productsearch", new ProductDto());
		_mvShare.addObject("paginationInfo", paginationInfo);
		List<ProductDto> list = categoryService.getDataProductPagination(Integer.parseInt(id), paginationInfo.getStart(), totalPage);
		_mvShare.addObject("pagination", list);
		return _mvShare;
	}
	
	@RequestMapping("/products/{id}/{currentPage}")
	public ModelAndView Category(@PathVariable String id, @PathVariable String currentPage) {
		_mvShare.setViewName("user/products/category");
		int totalData = categoryService.getDataProductById(Integer.parseInt(id)).size();
		PaginationDto paginationInfo = paginationService.getInfoPagination(totalData, totalPage, Integer.parseInt(currentPage));
		_mvShare.addObject("catId", id);
		_mvShare.addObject("paginationInfo", paginationInfo);
		_mvShare.addObject("pagination", categoryService.getDataProductPagination(Integer.parseInt(id), paginationInfo.getStart(), totalPage));
		return _mvShare;
	}
}