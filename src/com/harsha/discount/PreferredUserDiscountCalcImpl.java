package com.harsha.discount;

import java.util.LinkedList;

import com.harsha.catalog.Item;
import com.harsha.util.Utils;
/*
 * 3. If the user has been a customer for over 2 years, he gets a 5% discount.	
 * 5. The percentage based discounts do not apply on groceries. 
 * 6. A user can get only one of the percentage based discounts on a bill.
 */
public class PreferredUserDiscountCalcImpl implements IDiscountCalculator {

	public PreferredUserDiscountCalcImpl() {
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
		
		discount = eligibleOrderAmount * 0.05;
		
		discount = Utils.round(discount, 2);			
		
		return discount;
	}

}
