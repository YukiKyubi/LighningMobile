package DiamondShop.Service.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.Dao.UserDao;
import DiamondShop.Entity.User;


@Service
public class AccountServiceImplement implements IAccountService {
	@Autowired
	UserDao userDao = new UserDao();

	public int addAccount(User user) {
		user.setRole("user");
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
		return userDao.addAccount(user);
	}

	public User checkAccount(User user) {
		String password = user.getPassword();
		user = userDao.getUserByAccount(user);
		if(user != null) {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return user;
			}
			return null;
		}
		return null;
	}

}
