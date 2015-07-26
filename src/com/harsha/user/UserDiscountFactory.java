package com.harsha.user;

import com.harsha.discount.DiscountCalculatorFactory;
import com.harsha.discount.IDiscountCalculator;

public class UserDiscountFactory {

	public static IUserDiscount createUserDiscount(EUserType userType) {
		IDiscountCalculator discountCalc = DiscountCalculatorFactory.createUserDiscountCalculator(userType);
		
		UserDiscount userDiscount = new UserDiscount(discountCalc);
		
		return userDiscount;
		
	}

}
