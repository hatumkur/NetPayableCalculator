/**
 * 
 */
package com.harsha.catalog;

import java.util.HashMap;

import com.harsha.exception.InvalidApiUseException;


/**
 * @author harsha
 *
 */
public class Catalog {
	private static Catalog catalog = null;
	
	protected HashMap<Integer, Item> itemsCatalog = null;
	
	protected Catalog() {
		itemsCatalog = new HashMap<Integer, Item>();
	}
	
	/*
	 * Singleton instance
	 */
	public static Catalog getInstance() {
		if(catalog == null) {
			return new Catalog();
		}
		
		return catalog;
	}
	
	/*
	 * Updates the existing item if already exists
	 */
	public Catalog addItem(int id, double price, String type) throws InvalidApiUseException {
		if(id < 0 || price == 0.0 ) {
			throw new InvalidApiUseException("Invalid arguments");
		}
		
		Item newItem = new Item(id, price, type);
		itemsCatalog.put(new Integer(id), newItem);
		return this;
	}
	
	public Catalog removeItem(int id) {
		if(item(id) != null) { // Item present
			itemsCatalog.remove(id);
		}
		return this;
	}	
	
	public Item item(Integer id) {
		Item item = itemsCatalog.get(id);
		return item;
	}

}
