package com.harsha.bill;

import com.harsha.exception.InvalidApiUseException;
import com.harsha.user.IUserDiscount;
import com.harsha.user.IUserOrder;

public class PurchaseBill {
	private IUserOrder userOrder = null;
	private IUserDiscount userDiscount = null;

	public PurchaseBill() {
	}
	
	public PurchaseBill addUserOrder(IUserOrder order) throws InvalidApiUseException {
		if(order == null) {
			throw new InvalidApiUseException("Invalid argument");
		}
		this.userOrder = order;
		return this;
	}
	
	public PurchaseBill addUserDiscount(IUserDiscount userDiscount) throws InvalidApiUseException {
		if(userOrder == null || userDiscount == null) {
			throw new InvalidApiUseException("UserOrder/UserDiscount is not valid");
		}
		this.userDiscount = userDiscount;

		userDiscount.setOrderedItems(userOrder.orderedItems());

		return this;
	}
	
	public String generateBill() throws InvalidApiUseException {
		if(userOrder == null || userDiscount == null ) {
			throw new InvalidApiUseException("UserOrder/UserDiscount is not added");
		}	
		
		double netPayable = userOrder.totalOrderPrice() - userDiscount.discount();
		
		String strBill = "ORDER PRICE = " +  userOrder.totalOrderPrice() +
				      "\n DISCOUNTED AMOUNT = " +  userDiscount.discount() + 
				      "\n -------------------------------------------------" +
				      "\n NET PAYABLE = " + netPayable + "\n";
		
		return strBill;
	}

}
