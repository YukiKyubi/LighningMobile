package DiamondShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.Dto.ProductDto;
import DiamondShop.Entity.Category;
import DiamondShop.Entity.Menu;
import DiamondShop.Entity.Slide;

@Service
public interface IHomeService {
	@Autowired
	public List<Slide> getDataSlide();
	public List<Category> getDataCategory();
	public List<Menu> getDataMenu();
	public List<ProductDto> getDataProduct();
}
