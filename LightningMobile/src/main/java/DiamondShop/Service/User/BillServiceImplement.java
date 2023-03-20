package DiamondShop.Service.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.Dao.BillDao;
import DiamondShop.Dto.CartDto;
import DiamondShop.Entity.Bill;
import DiamondShop.Entity.BillDetails;

@Service
public class BillServiceImplement implements IBillService {
	@Autowired
	private BillDao billDao = new BillDao();

	public int addBill(Bill bill) {
		return billDao.addBill(bill);
	}

	public void addBillDetails(HashMap<Long, CartDto> cart) {
		long idBill = billDao.getTheLastBill();
		
		for(Map.Entry<Long, CartDto> item : cart.entrySet()) {
			BillDetails billDetails = new BillDetails();
			billDetails.setId_bill(idBill);
			billDetails.setId_product(item.getValue().getProduct().getId_product());
			billDetails.setQuantity(item.getValue().getQuantity());
			billDetails.setTotal(item.getValue().getTotalPrice());
			billDao.addBillDetails(billDetails);
		}
	}

}
