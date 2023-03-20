package DiamondShop.Dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import DiamondShop.Dto.CartDto;
import DiamondShop.Dto.ProductDto;

@Repository
public class CartDao extends BaseDao {
	@Autowired
	ProductDao productDao = new ProductDao();
	
	public HashMap<Long, CartDto> addToCart(long id, HashMap<Long, CartDto> cart) {
		CartDto cartItem = new CartDto();
		ProductDto product = productDao.getAProductById(id);
		if(product != null && cart.containsKey(id)) {
			cartItem = cart.get(id);
			cartItem.setQuantity(cartItem.getQuantity() + 1);
			cartItem.setTotalPrice(cartItem.getProduct().getPrice() * cartItem.getQuantity());
		}
		else {
			cartItem.setProduct(product);
			cartItem.setQuantity(1);
			cartItem.setTotalPrice(product.getPrice());
		}
		cart.put(id, cartItem);
		return cart;
	}
	
	public HashMap<Long, CartDto> editCart(long id, int quantity, HashMap<Long, CartDto> cart) {
		if(cart == null) {
			return cart;
		}
		CartDto item = new CartDto();
		if(cart.containsKey(id)) {
			item = cart.get(id);
			item.setQuantity(quantity);
			double totalPrice = item.getProduct().getPrice() * quantity;
			item.setTotalPrice(totalPrice);
		}
		cart.put(id, item);
		return cart;
	}
	
	public HashMap<Long, CartDto> deleteCart(long id, HashMap<Long, CartDto> cart) {
		if(cart == null) {
			return cart;
		}
		if(cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}
	
	public int totalQuantity(HashMap<Long, CartDto> cart) {
		int totalQuantity = 0;
		for(Map.Entry<Long, CartDto> itemCart : cart.entrySet()) {
			totalQuantity += itemCart.getValue().getQuantity();
		}
		return totalQuantity;
	}
	
	public double totalPrice(HashMap<Long, CartDto> cart) {
		double totalPrice = 0;
		for(Map.Entry<Long, CartDto> cartItem : cart.entrySet()) {
			totalPrice += cartItem.getValue().getTotalPrice();
		}
		return totalPrice;
	}
}
