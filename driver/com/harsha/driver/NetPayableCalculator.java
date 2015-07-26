/**
 * 
 */
package com.harsha.driver;

import com.harsha.bill.PurchaseBill;
import com.harsha.catalog.Catalog;
import com.harsha.exception.InvalidApiUseException;
import com.harsha.user.IUserDiscount;
import com.harsha.user.IUserOrder;
import com.harsha.user.EUserType;
import com.harsha.user.UserDiscountFactory;
import com.harsha.user.UserOrder;

/**
 * @author harsha
 *
 */
public class NetPayableCalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Populate catalog of items
		Catalog catalog = Catalog.getInstance();

		try {
			catalog.addItem(1, 105.0, "books")
					.addItem(2, 258.8, "books")
					.addItem(2001, 28.7, "grossery")
					.addItem(2002, 30.9, "grossery")
					.addItem(3001, 1078.0, "apparels")
					.addItem(3003, 2500.0, "apparels")
					.addItem(5001, 8800.8, "electronic")
					.addItem(5004, 2300.99, "electronic");


			// Create User order
			IUserOrder order = new UserOrder(catalog);
			
			order.addItem(1)
				.addItem(3001)
				.addItems(5001, 5)
				.addItem(2002);


			// Create User Discount
			IUserDiscount userDiscount = UserDiscountFactory.createUserDiscount(EUserType.AFFLIATED);

			// 
			PurchaseBill bill = new PurchaseBill();

			String strBill = "";

			strBill = bill.addUserOrder(order)
					.addUserDiscount(userDiscount)
					.generateBill();

			System.out.println(strBill);
		} catch (InvalidApiUseException e) {
			e.printStackTrace();
		}

	}

}
