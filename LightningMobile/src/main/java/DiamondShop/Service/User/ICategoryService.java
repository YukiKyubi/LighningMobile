package DiamondShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamondShop.Dto.ProductDto;

@Service
public interface ICategoryService {
	public List<ProductDto> getDataProductById(int id);
	
	public List<ProductDto> getDataProductPagination(int id, int start, int totalPage);
}
