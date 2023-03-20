package DiamondShop.Service.Admin;

import org.springframework.stereotype.Service;

import DiamondShop.Entity.User;

@Service
public interface IAdminAccountService {
	public int addAdminAccount(User user);
	public User checkAdminAccount(User user);
}
