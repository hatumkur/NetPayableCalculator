package com.harsha.user;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.harsha.catalog.Item;
import com.harsha.discount.IDiscountCalculator;
import com.harsha.exception.InvalidApiUseException;

public class TestUserDiscount {
	private IUserDiscount userDiscount = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
		userDiscount = null;
	}

	@Test
	public void test_discount_null_discount_calc() {
		userDiscount = new UserDiscount(null);		
		try {
			userDiscount.discount();
			fail();
		} catch (InvalidApiUseException e) {
			return;
		}
	}
	
	@Test
	public void test_discount_null_order() {
		IDiscountCalculator discountCalc = Mockito.mock(IDiscountCalculator.class);
		userDiscount = new UserDiscount(discountCalc);		
		try {
			userDiscount.discount();
			fail();
		} catch (InvalidApiUseException e) {
			return;
		}		
	}	

	@Test
	public void test_discount_valid() {
		userDiscount = UserDiscountFactory.createUserDiscount(EUserType.NORMAL);		
		LinkedList<Item> orderedItems = new LinkedList<Item>();
		try {
			userDiscount.setOrderedItems(orderedItems)
						.discount();
		} catch (InvalidApiUseException e) {
			fail();
		}			
	}	
	
	@Test
	public void test_setOrderedItems_null_order() {
		IDiscountCalculator discountCalc = Mockito.mock(IDiscountCalculator.class);
		userDiscount = new UserDiscount(discountCalc);		
		try {
			userDiscount.setOrderedItems(null);
			fail();
		} catch (InvalidApiUseException e) {
			return;
		}
	}	

	@Test
	public void test_setOrderedItems_valid() {
		userDiscount = new UserDiscount(null);		
		LinkedList<Item> orderedItems = new LinkedList<Item>();
		try {
			userDiscount.setOrderedItems(orderedItems);
		} catch (InvalidApiUseException e) {
			fail();
		}		
	}		
}
