package DiamondShop.Service.User;

import org.springframework.stereotype.Service;

import DiamondShop.Dto.PaginationDto;

@Service
public class PaginationServiceImplement {
	public PaginationDto getInfoPagination(int totalData, int limit, int currentPage) {
		PaginationDto pagination = new PaginationDto();
		pagination.setLimit(limit);
		pagination.setTotalPages(setInfoTotalPage(totalData, limit));
		pagination.setCurrentPage(checkCurrenPage(currentPage, setInfoTotalPage(totalData, limit)));
		pagination.setStart(findStart(pagination.getCurrentPage(), limit));
		pagination.setEnd(findEnd(pagination.getStart(), limit, totalData));
		return pagination;
	}

	private int findEnd(int start, int limit, int totalData) {
		return start + limit > totalData ? totalData  : start + limit - 1;
	}

	private int findStart(int currentPage, int limit) {
		return (currentPage - 1) * limit + 1;
	}

	private int checkCurrenPage(int currentPage, int totalPage) {
		if(currentPage < 1) {
			return 1;
		}
		if(currentPage > totalPage) {
			return totalPage;
		}
		return currentPage;
	}

	private int setInfoTotalPage(int totalData, int limit) {
		int totalPage = 0;
		totalPage = totalData / limit;
		totalPage = totalPage * limit < totalData ? totalPage + 1 : totalPage;
		return totalPage;
	}
}
