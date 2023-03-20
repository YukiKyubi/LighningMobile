package DiamondShop.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.Dao.CartDao;
import DiamondShop.Dto.CartDto;

@Service
public class CartServiceImplement implements ICartService {
	@Autowired
	private CartDao cartDao = new CartDao();

	public HashMap<Long, CartDto> addToCart(long id, HashMap<Long, CartDto> cart) {
		return cartDao.addToCart(id, cart);
	}

	public HashMap<Long, CartDto> editCart(long id, int quantity, HashMap<Long, CartDto> cart) {
		return cartDao.editCart(id, quantity, cart);
	}

	public HashMap<Long, CartDto> deleteToCart(long id, HashMap<Long, CartDto> cart) {
		return cartDao.deleteCart(id, cart);
	}

	public int totalQuantity(HashMap<Long, CartDto> cart) {
		return cartDao.totalQuantity(cart);
	}

	public double totalPrice(HashMap<Long, CartDto> cart) {
		return cartDao.totalPrice(cart);
	}
}
