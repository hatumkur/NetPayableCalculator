package com.harsha.discount;

import java.util.LinkedList;

import com.harsha.catalog.Item;
import com.harsha.util.Utils;
/*
 * 2. If the user is an affiliate of the store, he gets a 10% discount 	
 * 5. The percentage based discounts do not apply on groceries. 
 * 6. A user can get only one of the percentage based discounts on a bill.
 */
public class AffiliatedUserDiscountCalcImpl implements IDiscountCalculator {

	public AffiliatedUserDiscountCalcImpl() {
	}

	public double calculateDiscount(LinkedList<Item> orderedItems) {
		double eligibleOrderAmount = 0.0;
		double discount = 0.0;
		
		if(orderedItems == null) {
			return discount;
		}
		
		for(Item item : orderedItems) {
			if(item.type().compareToIgnoreCase("grossery") != 0) {
				eligibleOrderAmount += item.price();
			}
		}
		
		discount = eligibleOrderAmount * 0.10;
		
		discount = Utils.round(discount, 2);
		
		return discount;
	}
	


}
