/**
 * 
 */
package com.harsha.catalog;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.harsha.exception.InvalidApiUseException;

/**
 * @author harsha
 *
 */
public class TestCatalog {

	public Catalog catalog = null;
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
		catalog = Catalog.getInstance();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		catalog = null;
	}

	@Test
	public void test_addItem_invalid_item_id() {
		try {
			catalog.addItem(-1, 100.0, "");
			fail();
		} catch (InvalidApiUseException e) {
			return;
		}
	}
	
	@Test
	public void test_addItem_invalid_item_price() {
		try {
			catalog.addItem(123, 0.0, "")
				   .addItem(111, 0.0, "grossery");
			fail();
		} catch (InvalidApiUseException e) {
			return;
		}		
	}
	
	@Test
	public void test_addItem_valid_item() {
		try {
			catalog.addItem(123, 100.0, "")
				   .addItem(111, 200.0, "grossery");
			
		} catch (InvalidApiUseException e) {
			fail();
		}
	}	
	
	@Test
	public void test_addItem_update_existing_item() {
		try {
			catalog.addItem(123, 100.0, "")
				   .addItem(111, 200.0, "grossery");
			
			catalog.addItem(123, 150.0, "books")
			   .addItem(111, 250.0, "grossery");	
			
			assertTrue(catalog.item(123).price() == 150.0);
			assertTrue(catalog.item(123).type().compareToIgnoreCase("books") == 0);
			
			assertTrue(catalog.item(111).price() == 250.0);
			assertTrue(catalog.item(111).type().compareToIgnoreCase("grossery") == 0);
			
		} catch (InvalidApiUseException e) {
			fail();
		}		
	}	
	
	@Test
	public void test_removeItem_invalid_item() {
		try {
			catalog.addItem(123, 150.0, "books")
			   .addItem(111, 250.0, "grossery");
			
			catalog.removeItem(2000);
			
		} catch (InvalidApiUseException e) {
			fail();
		}
	}

	@Test
	public void test_removeItem_valid_item() {
		try {
			catalog.addItem(123, 150.0, "books")
			   .addItem(111, 250.0, "grossery");
			
			catalog.removeItem(123);
			
			assertNull(catalog.item(123));
			
		} catch (InvalidApiUseException e) {
			fail();
		}		
	}	
}
