package DiamondShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamondShop.Entity.Category;
import DiamondShop.Entity.MapperCategories;

@Repository
public class CategoryDao extends BaseDao {
	public List<Category> getDataCategory() {
		List<Category> list = new ArrayList<Category>();
		String sql = "SELECT * FROM category";
		list = _jdbcTemplate.query(sql, new MapperCategories());
		return list;
	}
}
