package DiamondShop.Service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.Entity.User;

@Service
public interface IAccountService {
	public int addAccount(User user);
	public User checkAccount(User user);
}
