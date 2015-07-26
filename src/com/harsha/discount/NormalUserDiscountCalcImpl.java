package com.harsha.discount;

import java.util.LinkedList;

import com.harsha.catalog.Item;
import com.harsha.util.Utils;
/*
 * 4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45 as a discount). 
 * 5. The percentage based discounts do not apply on groceries. 
 * 6. A user can get only one of the percentage based discounts on a bill.
 */
public class NormalUserDiscountCalcImpl implements IDiscountCalculator{

	public NormalUserDiscountCalcImpl() {
		
	}

	public double calculateDiscount(LinkedList<Item> orderedItems) {
		double eligibleAmountForDiscount = 0.0;
		double discount = 0.0;
		
		if(orderedItems == null) {
			return discount;
		}
		
		for(Item item : orderedItems) {
			if(item.type().compareToIgnoreCase("grossery") != 0) {
				eligibleAmountForDiscount += item.price();
			}
		}
		
		int amount = (int)(eligibleAmountForDiscount / 100 );
		discount = amount * 5;
		
		discount = Utils.round(discount, 2);	
		
		return discount;
	}

}
