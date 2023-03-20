package DiamondShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamondShop.Dto.ProductDto;
import DiamondShop.Dto.ProductDtoMapper;

@Repository
public class ProductDao extends BaseDao {
	private final boolean YES = true;
	private final boolean NO = false;
	
	private StringBuffer sqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT product.id as id_product ");
		sql.append(", product.id_category ");
		sql.append(", product.sizes ");
		sql.append(", product.name ");
		sql.append(", product.price ");
		sql.append(", product.sale ");
		sql.append(", product.title ");
		sql.append(", product.highlight ");
		sql.append(", product.new_product ");
		sql.append(", product.details ");
		sql.append(", color.id as id_color ");
		sql.append(", color.name as name_color");
		sql.append(", color.code ");
		sql.append(", color.img ");
		sql.append(", product.created_at ");
		sql.append(", product.updated_at ");
		sql.append("FROM product ");
		sql.append("INNER JOIN color ");
		sql.append("ON product.id = color.id_product ");
		return sql;
	}
	
	public StringBuffer getAllProductSql() {
		StringBuffer sql = sqlString();
		sql.append("GROUP BY product.id, color.id_product ");
		return sql;
	}
	
	public List<ProductDto> searchProduct(String string) {
		StringBuffer sql = sqlString(); 
		sql.append("WHERE product.name LIKE '%" + string +"%' ");
		List<ProductDto> list = _jdbcTemplate.query(sql.toString(), new ProductDtoMapper());
		return list;
	}
	
	public List<ProductDto> getAllProduct() {
		String sql = getAllProductSql().toString();
		List<ProductDto> list = _jdbcTemplate.query(sql, new ProductDtoMapper());
		return list;
	}
	
	public String sqlProduct(boolean newProrducts, boolean featuredProducts) {
		StringBuffer sql = sqlString();
		sql.append("WHERE 1 = 1 ");
		if(newProrducts) {
			sql.append("AND new_product = true ");
		}
		if(featuredProducts) {
			sql.append("AND highlight = true ");
		}
		sql.append("GROUP BY product.id, color.id_product ");
		sql.append("ORDER BY RAND() ");
		if(newProrducts) {
			sql.append("LIMIT 12 ");
		}
		if(featuredProducts) {
			sql.append("LIMIT 9 ");
		}
		return sql.toString();
	}
	
	public StringBuffer sqlProductById(int id) {
		StringBuffer sql = sqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND id_category = " + id + " ");
		return sql;
	}
	
	public StringBuffer sqlProductPagination(int id, int start, int totalPage) {
		StringBuffer sql = sqlProductById(id);
		sql.append("LIMIT " + start + ", " + totalPage);
		return sql;
	}
	
	public StringBuffer sqlAllProductPagination(int start, int totalPage) {
		StringBuffer sql = getAllProductSql();
		sql.append("LIMIT " + start + ", " + totalPage);
		return sql;
	}
	
	public StringBuffer sqlSearchProductPagination(String string, int start, int totalPage) {
		StringBuffer sql = sqlString(); 
		sql.append("WHERE product.name LIKE '%" + string +"%'");
		sql.append("LIMIT " + start + ", " + totalPage);
		return sql;
	}

	public List<ProductDto> getDataProduct() {
		String sql = sqlProduct(YES, NO);
		List<ProductDto> list = _jdbcTemplate.query(sql, new ProductDtoMapper());
		return list;
	}
	
	public List<ProductDto> getDataProductById(int id) {
		String sql = sqlProductById(id).toString();
		List<ProductDto> list = _jdbcTemplate.query(sql, new ProductDtoMapper());
		return list;
	}
	
	public List<ProductDto> getDataProductPagination(int id, int start, int totalPage) {
		String sqlProductById = sqlProductById(id).toString();
		List<ProductDto> listProductById = _jdbcTemplate.query(sqlProductById, new ProductDtoMapper());
		List<ProductDto> list = new ArrayList<ProductDto>();
		if(listProductById.size() > 0) {
			if(listProductById.size() <= 9) {
				start = 0;
			}
			String sql = sqlProductPagination(id, start, totalPage).toString();
			list = _jdbcTemplate.query(sql, new ProductDtoMapper());
		}
		return list;
	}
	
	public List<ProductDto> getAllProductPagination(int start, int totalPage) {
		List<ProductDto> listAllProduct = _jdbcTemplate.query(getAllProductSql().toString(), new ProductDtoMapper());
		List<ProductDto> list = new ArrayList<ProductDto>();
		if(listAllProduct.size() > 0) {
			String sql = sqlAllProductPagination(start, totalPage).toString();
			list = _jdbcTemplate.query(sql, new ProductDtoMapper());
		}
		return list;
	}
	
	public List<ProductDto> getSearchProductPagination(String string, int start, int totalPage) {
		List<ProductDto> listSearchProduct = searchProduct(string);
		List<ProductDto> list = new ArrayList<ProductDto>();
		if(listSearchProduct.size() > 0) {
			if(listSearchProduct.size() <= 9) {
				start = 0;
			}
			String sql = sqlSearchProductPagination(string, start, totalPage).toString();
			list = _jdbcTemplate.query(sql, new ProductDtoMapper());
		}
		return list;
	}
	
	public String sqlProductByProId(long id) {
		StringBuffer sql = sqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND id_product = " + id + " ");
		sql.append("LIMIT 1 ");
		return sql.toString();
	}

	public List<ProductDto> getTheProductById(long id) {
		String sql = sqlProductByProId(id);
		List<ProductDto> product = _jdbcTemplate.query(sql, new ProductDtoMapper());
		return product;
	}
	
	public ProductDto getAProductById(long id) {
		String sql = sqlProductByProId(id);
		ProductDto product = _jdbcTemplate.queryForObject(sql, new ProductDtoMapper());
		return product;
	}
}
