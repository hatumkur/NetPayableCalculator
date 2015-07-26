package com.harsha.user;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.harsha.catalog.Catalog;
import com.harsha.exception.InvalidApiUseException;

public class TestUserOrder {
	
	private IUserOrder userOrder = null;
	private Catalog validCatalog = null;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		validCatalog = Catalog.getInstance();

		try {
			validCatalog.addItem(1, 105.0, "books")
			.addItem(2, 258.8, "books")
			.addItem(2001, 28.7, "grossery")
			.addItem(2002, 30.9, "grossery")
			.addItem(3001, 1078.0, "apparels")
			.addItem(3003, 2500.0, "apparels")
			.addItem(5001, 8800.8, "electronic")
			.addItem(5004, 2300.99, "electronic");
			
		} catch (InvalidApiUseException e) {
			
		}
		
	}

	@After
	public void tearDown() throws Exception {
		userOrder = null;
		validCatalog = null;
	}

	@Test
	public void test_addItem_null_catalog() {
		userOrder = new UserOrder(null);
		try {
			userOrder.addItem(1);
			fail();
		} catch (InvalidApiUseException e) {
			return;
		}
	}
	
	@Test
	public void test_addItem_invalid_itemid() {
		Catalog catalog = Mockito.mock(Catalog.class);
		userOrder = new UserOrder(catalog);
		try {
			userOrder.addItem(111);
		} catch (InvalidApiUseException e) {
			fail();
		}		
	}
	
	@Test
	public void test_addItem_valid() {
		userOrder = new UserOrder(validCatalog);
		try {
			userOrder.addItem(1)
					 .addItem(3001);
		} catch (InvalidApiUseException e) {
			fail();
		}		
	}	
	
	@Test
	public void test_addItems_null_catalog() {
		userOrder = new UserOrder(null);
		try {
			userOrder.addItems(1, 5);
			fail();
		} catch (InvalidApiUseException e) {
			return;
		}
	}
	
	@Test
	public void test_addItems_invalid_itemid() {
		Catalog catalog = Mockito.mock(Catalog.class);
		userOrder = new UserOrder(catalog);
		try {
			userOrder.addItems(111, 6);
		} catch (InvalidApiUseException e) {
			fail();
		}	
	}
	
	@Test
	public void test_addItems_invalid_count_negative() {
		Catalog catalog = Mockito.mock(Catalog.class);
		userOrder = new UserOrder(catalog);
		try {
			userOrder.addItems(111, Integer.MIN_VALUE);
			fail();
		} catch (InvalidApiUseException e) {
			return;
		}
	}	
	
	@Test
	public void test_addItems_invalid_count_large() {
		Catalog catalog = Mockito.mock(Catalog.class);
		userOrder = new UserOrder(catalog);
		try {
			userOrder.addItems(111, Integer.MAX_VALUE);
			fail();
		} catch (InvalidApiUseException e) {
			return;
		}
	}	
		

	@Test
	public void test_addItems_valid() {
		userOrder = new UserOrder(validCatalog);
		try {
			userOrder.addItems(1, 6)
					 .addItems(2001, 0);
		} catch (InvalidApiUseException e) {
			fail();
		}	
	}
	
	@Test
	public void test_removeItem_null_catalog() {
		userOrder = new UserOrder(null);
		try {
			userOrder.removeItem(1);
			fail();
		} catch (InvalidApiUseException e) {
			return;
		}		
	}

	@Test
	public void test_removeItem_valid() {
		userOrder = new UserOrder(validCatalog);
		try {
			userOrder.addItems(1, 6)
			 		 .addItems(2001, 0)			
			         .removeItem(1);
		} catch (InvalidApiUseException e) {
			fail();
		}
	}	
	
	@Test
	public void test_removeItems_null_catalog() {
		userOrder = new UserOrder(null);
		try {
			userOrder.removeItems(1, 1);			
		} catch (InvalidApiUseException e) {
			fail();
		}	
	}

	@Test
	public void test_removeItems_invalid_itemid() {
		userOrder = new UserOrder(validCatalog);
		try {
			userOrder.addItems(1, 6)
					 .addItems(2001, 10)			
					 .removeItems(111,1);
		} catch (InvalidApiUseException e) {
			fail();
		}
	}
	
	@Test
	public void test_removeItems_invalid_count_negative() {
		userOrder = new UserOrder(validCatalog);
		try {
			userOrder.addItems(1, 6)
			 .addItems(2001, 0)
			 .removeItems(1,Integer.MIN_VALUE);
			fail();
		} catch (InvalidApiUseException e) {
			return;
		}
	}	
	
	@Test
	public void test_removeItems_invalid_count_large() {
		userOrder = new UserOrder(validCatalog);
		try {
			userOrder.addItems(1, 6)
			 		 .addItems(2001, 10)
			 		 .removeItems(1,Integer.MAX_VALUE);			
			fail();
		} catch (InvalidApiUseException e) {
			return;
		}
	}	
	
	@Test
	public void test_removeItems_valid_count_zero() {
		userOrder = new UserOrder(validCatalog);
		try {
			userOrder.addItems(1, 6)
			 		 .addItems(2001, 10)
			         .removeItems(1,0)
			         .removeItems(2001, 5);	
		} catch (InvalidApiUseException e) {
			fail();
		}
	}		

	@Test
	public void test_removeItems_valid() {
		userOrder = new UserOrder(validCatalog);
		try {
			userOrder.removeItems(1, 5);
		} catch (InvalidApiUseException e) {
			fail();
		}
	}
		
	@Test
	public void test_totalOrderPrice_order_empty() {
		userOrder = new UserOrder(validCatalog);
		assertTrue(userOrder.totalOrderPrice() == 0.0);
		
		try {
			double totalPrice = userOrder.addItems(1, 5)
					 			 .totalOrderPrice();
			assertTrue(totalPrice == 525.0);
		} catch (InvalidApiUseException e) {
			fail();
		}			
	}	
	
	@Test
	public void test_orderItemsCount_valid() {
		userOrder = new UserOrder(validCatalog);
		assertTrue(userOrder.orderItemsCount() == 0);
		try {
			int count = userOrder.addItems(1, 5)
					 			 .orderItemsCount();
			assertTrue(count == 5);
		} catch (InvalidApiUseException e) {
			fail();
		}		
	}		
}
