package DiamondShop.Dao;

import org.springframework.stereotype.Repository;

import DiamondShop.Entity.User;
import DiamondShop.Entity.UserMapper;

@Repository
public class UserDao extends BaseDao {
	public int addAccount(User user) {
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO user ");
		sql.append("( ");
		sql.append("	username, ");
		sql.append("    password, ");
		sql.append("    display_name, ");
		sql.append("    address, ");
		sql.append("    role ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("    '" + user.getUsername() + "', ");
		sql.append("    '"+ user.getPassword() +"', ");
		sql.append("    '"+ user.getDisplay_name() + "', ");
		sql.append("    '"+ user.getAddress() +"', ");
		sql.append("    '"+ user.getRole() +"' ");
		sql.append(")");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public User getUserByAccount(User user) {
		String sql = "SELECT * FROM user WHERE username = '" + user.getUsername() + "'";
		User uAccount = _jdbcTemplate.queryForObject(sql, new UserMapper());
		return uAccount;
	}
}
