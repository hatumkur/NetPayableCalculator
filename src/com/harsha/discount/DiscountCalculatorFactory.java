package com.harsha.discount;

import com.harsha.user.EUserType;

public class DiscountCalculatorFactory {

	public static IDiscountCalculator createUserDiscountCalculator(EUserType type) {
		switch(type) {
		case NORMAL:
			return new NormalUserDiscountCalcImpl();
		case EMPLOYEE:
			return new EmployeeUserDiscountCalcmpl();
		case AFFLIATED:
			return new AffiliatedUserDiscountCalcImpl();
		case PREFERED:
			return new PreferredUserDiscountCalcImpl();
		default:
			return new NormalUserDiscountCalcImpl();
		}
	}

}
