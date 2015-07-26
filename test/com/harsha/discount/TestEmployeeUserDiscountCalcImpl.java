package com.harsha.discount;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.harsha.catalog.Item;
import com.harsha.user.EUserType;

public class TestEmployeeUserDiscountCalcImpl {
	public IDiscountCalculator discountCalc = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		discountCalc = DiscountCalculatorFactory.createUserDiscountCalculator(EUserType.EMPLOYEE);
	}

	@After
	public void tearDown() throws Exception {
		discountCalc = null;
	}

	@Test
	public void test_calculateDiscount_null() {
		double discount = discountCalc.calculateDiscount(null);
		assertTrue(discount == 0.0);
	}
	
	@Test
	public void test_calculateDiscount_valid_but_empty_order() {
		LinkedList<Item> orderedItems = new LinkedList<Item>();
		double discount = discountCalc.calculateDiscount(orderedItems);
		assertTrue(discount == 0.0);
	}	
	
	@Test
	public void test_calculateDiscount_valid_nonempty_order() {
		LinkedList<Item> orderedItems = new LinkedList<Item>();
		
		Item item1 = new Item(111, 200.0, "books");
		Item item2 = new Item(1, 105.0, "books");
		Item item3 = new Item(2, 258.8, "books");
		Item item4 = new Item(2001, 28.7, "grossery");
		Item item5 = new Item(2002, 30.9, "grossery");
		Item item6= new Item(3001, 1078.0, "apparels");
		Item item7 = new Item(3003, 2500.0, "apparels");
		Item item8 = new Item(5001, 8800.8, "electronic");
		Item item9 = new Item(5004, 2300.99, "electronic");
		Item item10 = new Item(111, 200.0, "books"); // repeated
		
		orderedItems.add(item1);
		orderedItems.add(item2);
		orderedItems.add(item3);
		orderedItems.add(item4);
		orderedItems.add(item5);
		orderedItems.add(item6);
		orderedItems.add(item7);
		orderedItems.add(item8);
		orderedItems.add(item9);	
		orderedItems.add(item10);	
		
		double discount = discountCalc.calculateDiscount(orderedItems);
		assertTrue(discount != 0.0);
		assertTrue(discount == 4633.08);
	}		
}
