package DiamondShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamondShop.Entity.MapperSlides;
import DiamondShop.Entity.Slide;

@Repository
public class SlidesDao extends BaseDao {
	public List<Slide> getDataSlide() {
		List<Slide> list = new ArrayList<Slide>();
		String sql = "SELECT * FROM slides";
		list = _jdbcTemplate.query(sql, new MapperSlides());
		return list;
	}
}
