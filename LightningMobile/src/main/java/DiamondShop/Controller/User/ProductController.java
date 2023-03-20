package DiamondShop.Controller.User;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamondShop.Dto.PaginationDto;
import DiamondShop.Dto.ProductDto;
import DiamondShop.Service.User.PaginationServiceImplement;
import DiamondShop.Service.User.ProductServiceImplement;

@Controller
public class ProductController extends BaseController {
	@Autowired
	private ProductServiceImplement _productServie;
	
	@Autowired
	private PaginationServiceImplement _paginationService;
	
	private int totalPage = 9;
	
	@RequestMapping("all-product/page1")
	public ModelAndView AllProductFirstPage() {
		_mvShare.setViewName("user/products/allproduct");
		int totalData = _productServie.getAllProduct().size();
		PaginationDto paginationInfo = _paginationService.getInfoPagination(totalData, totalPage, 1);
		_mvShare.addObject("paginationInfo", paginationInfo);
		_mvShare.addObject("productsearch", new ProductDto());
		_mvShare.addObject("pagination", _productServie.getAllProductPagination(paginationInfo.getStart(), totalPage));
		return _mvShare;
	}
	
	@RequestMapping("all-product/page{currentPage}")
	public ModelAndView AllProductCurrentPage(@PathVariable String currentPage) {
		_mvShare.setViewName("user/products/allproduct");
		_mvShare.addObject("productsearch", new ProductDto());
		int totalData = _productServie.getAllProduct().size();
		PaginationDto paginationInfo = _paginationService.getInfoPagination(totalData, totalPage, Integer.parseInt(currentPage));
		_mvShare.addObject("paginationInfo", paginationInfo);
		_mvShare.addObject("pagination", _productServie.getAllProductPagination(paginationInfo.getStart(), totalPage));
		return _mvShare;
	}
	
	@RequestMapping("/product-details/{id}")
	public ModelAndView Product(@PathVariable long id) {
		_mvShare.setViewName("user/products/product");
		_mvShare.addObject("productsearch", new ProductDto());
		_mvShare.addObject("categories", _homeService.getDataCategory());
		_mvShare.addObject("product", _productServie.getTheProductById(id));
		int catId = _productServie.getTheProductById(id).getId_category();
		_mvShare.addObject("listProductByCatId", _productServie.getDataProductById(catId));
		return _mvShare;
	}
	
	@RequestMapping(value = "/search-results", method = RequestMethod.POST)
	public ModelAndView SearchProducts(@ModelAttribute("productsearch") ProductDto product) {
		_mvShare.setViewName("user/products/search");
		String query = product.getName();
		_mvShare.addObject("query", query);
		int totalData = _productServie.searchProduct(product.getName()).size();
		PaginationDto paginationInfo = _paginationService.getInfoPagination(totalData, totalPage, 1);
		_mvShare.addObject("paginationInfo", paginationInfo);
		List<ProductDto> list = _productServie.getSearchProductPagination(product.getName(), paginationInfo.getStart(), totalPage);
		_mvShare.addObject("pagination", list);
		return _mvShare;
	}
	
	@RequestMapping(value = "/search-results{query}/p{currentPage}", method = RequestMethod.GET)
	public ModelAndView CurrentSearchProducts(@PathVariable String query, @PathVariable String currentPage) {
		_mvShare.setViewName("user/products/search");
		_mvShare.addObject("productsearch", new ProductDto());
		int totalData = _productServie.searchProduct(query).size();
		PaginationDto paginationInfo = _paginationService.getInfoPagination(totalData, totalPage, Integer.parseInt(currentPage));
		_mvShare.addObject("paginationInfo", paginationInfo);
		_mvShare.addObject("pagination", _productServie.getSearchProductPagination(query, paginationInfo.getStart(), totalPage));
		return _mvShare;
	}
}
