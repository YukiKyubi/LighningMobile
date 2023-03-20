package DiamondShop.Service.User;

import org.springframework.stereotype.Service;

import DiamondShop.Dto.PaginationDto;

@Service
public interface IPaginationService {
	public PaginationDto getInfoPagination(int totalData, int limit, int currentPage);
}
