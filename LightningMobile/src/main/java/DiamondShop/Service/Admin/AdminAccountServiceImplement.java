package DiamondShop.Service.Admin;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.Dao.UserDao;
import DiamondShop.Entity.User;

@Service
public class AdminAccountServiceImplement implements IAdminAccountService {
	
	@Autowired
	UserDao userDao = new UserDao();

	public int addAdminAccount(User user) {
		user.setRole("admin");
		user.setAddress("");
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
		return userDao.addAccount(user);
	}
	

	public User checkAdminAccount(User user) {
		String password = user.getPassword();
		user = userDao.getUserByAccount(user);
		String role = user.getRole();
		if(role == "admin") {
			return null;
		}
		if(user != null) {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return user;
			}
			return null;
		}
		return null;
	}

}
