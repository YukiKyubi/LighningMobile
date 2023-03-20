package DiamondShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.Dao.CategoryDao;
import DiamondShop.Dao.MenuDao;
import DiamondShop.Dao.ProductDao;
import DiamondShop.Dao.SlidesDao;
import DiamondShop.Dto.ProductDto;
import DiamondShop.Entity.Category;
import DiamondShop.Entity.Menu;
import DiamondShop.Entity.Slide;

@Service
public class HomeServiceImplement implements IHomeService {
	@Autowired
	private SlidesDao slidesDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private MenuDao menuDao;
	@Autowired
	private ProductDao productDao;

	public List<Slide> getDataSlide() {
		return slidesDao.getDataSlide();
	}

	public List<Category> getDataCategory() {
		return categoryDao.getDataCategory();
	}
	
	public List<Menu> getDataMenu() {
		return menuDao.getDataMenu();
	}

	public List<ProductDto> getDataProduct() {
		List<ProductDto> list = productDao.getDataProduct();
		return list;
	}

}
