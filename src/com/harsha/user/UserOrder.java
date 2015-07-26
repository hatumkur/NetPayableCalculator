/**
 * 
 */
package com.harsha.user;

import java.util.LinkedList;

import com.harsha.catalog.Catalog;
import com.harsha.catalog.Item;
import com.harsha.exception.InvalidApiUseException;

/**
 * @author harsha
 *
 */
public class UserOrder implements IUserOrder {

	final private LinkedList<Item> orderedItems;
	final private Catalog catalog;
	final private int MAX_ITEM_BULK_COUNT = 10;

	public UserOrder(Catalog acatalog) {
		catalog = acatalog;
		orderedItems = new LinkedList<Item>();
	}
	
	public int orderItemsCount() {
		return orderedItems.size();
	}
	
	public IUserOrder addItem(Integer id) throws InvalidApiUseException {
		if(catalog == null) {
			throw new InvalidApiUseException("Catalog is not initialized!");
		}
		Item item = catalog.item(id);
		if(item != null){
			orderedItems.add(item);
		}
		return this;
	}
	
	public IUserOrder addItems(Integer id, int count) throws InvalidApiUseException {
		if(count < 0 || count > MAX_ITEM_BULK_COUNT) {
			throw new InvalidApiUseException("Invalid items count MAX allowed " +
												MAX_ITEM_BULK_COUNT );
		}
		for(int i = count; i > 0; i--) {
			addItem(id);
		}

		return this;		
	}
	
	public IUserOrder removeItem(Integer id) throws InvalidApiUseException {
		if(catalog == null) {
			throw new InvalidApiUseException("Catalog is not initialized!");
		}
		
		//boolean isValidItem = catalog.isFound(id);
		//if(isValidItem){
			remove(id);
		//}
		return this;
	}

	private int remove(Integer id) throws InvalidApiUseException {
		int index = findItem(id);
		if(index != -1) {
			orderedItems.remove(index);
		}
		return index;
	}
	
	public IUserOrder removeItems(Integer id, int count) throws InvalidApiUseException {

		if(count < 0 || count > MAX_ITEM_BULK_COUNT) {
			throw new InvalidApiUseException("Invalid items count MAX allowed " +
												MAX_ITEM_BULK_COUNT );
		}
		
		//boolean isValidItem = catalog.isFound(id);
		//if(isValidItem){
			for(int i = count; i > 0; i--) {
				int index = remove(id);
				if(index == -1) {
					break;
				}
			}
		//}
		return this;
	}	
	
	private int findItem(Integer id) {
		int index = -1;
		for(Item item : orderedItems) {
			index++;
			if(item.id() == id) {
				break;
			}
		}
		return index;
	}

	public double totalOrderPrice() {
		double totalPrice = 0.0;
		if(orderedItems != null) {
			for(Item item : orderedItems) {
				totalPrice += item.price();
			}
		}

		return totalPrice;
	}
	
	public LinkedList<Item> orderedItems() {
		return orderedItems;
	}

}
