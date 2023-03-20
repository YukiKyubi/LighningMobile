package DiamondShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamondShop.Dto.ProductDto;

@Service
public interface IProductService {
	
	public List<ProductDto> getAllProduct();
	
	public List<ProductDto> searchProduct(String string);
	
	public ProductDto getTheProductById(long id);
	
	public List<ProductDto> getDataProductById(int id);
	
	public List<ProductDto> getAllProductPagination(int start, int totalPage);
	
	public List<ProductDto> getSearchProductPagination(String string, int start, int totalPage);
}
