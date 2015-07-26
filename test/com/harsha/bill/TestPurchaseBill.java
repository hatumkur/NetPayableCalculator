/**
 * Unit test PurchaseBill class
 */
package com.harsha.bill;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.harsha.exception.InvalidApiUseException;
import com.harsha.user.IUserDiscount;
import com.harsha.user.IUserOrder;

/**
 * @author harsha
 *
 */
public class TestPurchaseBill {
	
	private PurchaseBill purchaseBill; 

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		purchaseBill = new PurchaseBill();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		purchaseBill = null;
	}

	@Test
	public void test_addUserOrder_null() {
		try {
			purchaseBill.addUserOrder(null);
			fail();
		} catch (InvalidApiUseException e) {
			return;
		}
	}
	
	@Test
	public void test_addUserOrder() {
		try {
			IUserOrder userOrder = Mockito.mock(IUserOrder.class);
			purchaseBill.addUserOrder(userOrder);
		} catch (InvalidApiUseException e) {
			fail();
		}		
	}	

	@Test
	public void test_addUserDiscount_null() {
		try {
			IUserOrder userOrder = Mockito.mock(IUserOrder.class);
			purchaseBill.addUserOrder(userOrder);
			
			purchaseBill.addUserDiscount(null);
			fail();
		} catch (InvalidApiUseException e) {
			return;
		}		
	}
	
	@Test
	public void test_addUserDiscount_before_addUserOrder() {
		try {
			IUserOrder userOrder = Mockito.mock(IUserOrder.class);
			IUserDiscount userDiscount = Mockito.mock(IUserDiscount.class);
			purchaseBill.addUserDiscount(userDiscount)
						.addUserOrder(userOrder);
			fail();
		} catch (InvalidApiUseException e) {
			return;
		}	
	}	
	
	@Test
	public void test_addUserDiscount() {
		try {
			IUserOrder userOrder = Mockito.mock(IUserOrder.class);
			IUserDiscount userDiscount = Mockito.mock(IUserDiscount.class);
			purchaseBill.addUserOrder(userOrder)
						.addUserDiscount(userDiscount);
		} catch (InvalidApiUseException e) {
			fail();
		}	
	}	
	
	@Test
	public void test_generateBill_before_addUserOrder() {
		try {
			IUserOrder userOrder = Mockito.mock(IUserOrder.class);
			IUserDiscount userDiscount = Mockito.mock(IUserDiscount.class);
			purchaseBill.generateBill();
			purchaseBill.addUserOrder(userOrder)
						.addUserDiscount(userDiscount);
			fail();
		} catch (InvalidApiUseException e) {
			return;
		}		
	}	
	
	@Test
	public void test_generateBill_before_addUserDiscount() {
		try {
			IUserOrder userOrder = Mockito.mock(IUserOrder.class);
			IUserDiscount userDiscount = Mockito.mock(IUserDiscount.class);
			purchaseBill.addUserOrder(userOrder);
			purchaseBill.generateBill();
			purchaseBill.addUserDiscount(userDiscount);
			fail();
		} catch (InvalidApiUseException e) {
			return;
		}	
	}		
	
	@Test
	public void test_generateBill() {
		try {
			IUserOrder userOrder = Mockito.mock(IUserOrder.class);
			IUserDiscount userDiscount = Mockito.mock(IUserDiscount.class);
			
			String str = purchaseBill.addUserOrder(userOrder)
						.addUserDiscount(userDiscount)
						.generateBill();
			
			assertTrue(str.length() > 0);
			
		} catch (InvalidApiUseException e) {
			fail();
		}			
	}		
}
