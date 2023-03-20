package DiamondShop.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import DiamondShop.Dto.CartDto;

@Service
public interface ICartService {
	public HashMap<Long, CartDto> addToCart(long id, HashMap<Long, CartDto> cart);
	public HashMap<Long, CartDto> editCart(long id, int quantity, HashMap<Long, CartDto> cart);
	public HashMap<Long, CartDto> deleteToCart(long id, HashMap<Long, CartDto> cart);
	public int totalQuantity(HashMap<Long, CartDto> cart);
	public double totalPrice(HashMap<Long, CartDto> cart);
}
