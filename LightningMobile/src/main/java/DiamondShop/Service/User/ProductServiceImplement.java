package DiamondShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.Dao.ProductDao;
import DiamondShop.Dto.ProductDto;

@Service
public class ProductServiceImplement implements IProductService {
	@Autowired
	ProductDao productDao = new ProductDao();

	public ProductDto getTheProductById(long id) {
		List<ProductDto> product = productDao.getTheProductById(id); 
		return product.get(0);
	}

	public List<ProductDto> getDataProductById(int id) {
		return productDao.getDataProductById(id);
	}

	public List<ProductDto> getAllProduct() {
		return productDao.getAllProduct();
	}

	public List<ProductDto> getAllProductPagination(int start, int totalPage) {
			List<ProductDto> list = productDao.getAllProductPagination(start, totalPage);
			return list;
	}

	public List<ProductDto> searchProduct(String string) {
		return productDao.searchProduct(string);
	}

	public List<ProductDto> getSearchProductPagination(String string, int start, int totalPage) {
		return productDao.getSearchProductPagination(string, start, totalPage);
	}

}
