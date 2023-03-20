package DiamondShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.Dao.ProductDao;
import DiamondShop.Dto.ProductDto;

@Service
public class CategoryServiceImplement implements ICategoryService {
	@Autowired
	private ProductDao productDao;
	
	public List<ProductDto> getDataProductById(int id) {
		return productDao.getDataProductById(id);
	}

	public List<ProductDto> getDataProductPagination(int id, int start, int totalPage) {
		List<ProductDto> list = productDao.getDataProductPagination(id, start, totalPage);
		return list;
	}
}
