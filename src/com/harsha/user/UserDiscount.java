package com.harsha.user;

import java.util.LinkedList;

import com.harsha.catalog.Item;
import com.harsha.discount.IDiscountCalculator;
import com.harsha.exception.InvalidApiUseException;

public class UserDiscount implements IUserDiscount {

	final IDiscountCalculator discountCalc;
	LinkedList<Item> orderedItems = null;
	
	public UserDiscount(IDiscountCalculator discountCalc) {
		this.discountCalc = discountCalc;
	}

	public double discount() throws InvalidApiUseException {
		if(discountCalc == null || orderedItems == null) {
			throw new InvalidApiUseException("DiscountCalc / Order / both not initialized!");
		}
		return discountCalc.calculateDiscount(orderedItems);
	}

	public IUserDiscount setOrderedItems(LinkedList<Item> orderedItems) throws InvalidApiUseException  {
		if(orderedItems == null) {
			throw new InvalidApiUseException("Order is not initialized!");
		}		
		this.orderedItems = orderedItems;
		return this;
	}

}
