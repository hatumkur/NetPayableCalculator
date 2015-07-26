/**
 * 
 */
package com.harsha.user;

import java.util.LinkedList;

import com.harsha.catalog.Item;
import com.harsha.exception.InvalidApiUseException;

/**
 * @author SYSTEM
 *
 */
public interface IUserDiscount {

	//public EUserType type();
	
	public double discount() throws InvalidApiUseException;
	
	public IUserDiscount setOrderedItems(LinkedList<Item> orderedItems) throws InvalidApiUseException;
	
}
