package com.harsha.user;

import java.util.LinkedList;

import com.harsha.catalog.Item;
import com.harsha.exception.InvalidApiUseException;

public interface IUserOrder {
	
	public IUserOrder addItem(Integer id) throws InvalidApiUseException; 
	
	public IUserOrder addItems(Integer id, int count) throws InvalidApiUseException;
	
	public IUserOrder removeItem(Integer id) throws InvalidApiUseException; 
	
	public IUserOrder removeItems(Integer id, int count) throws InvalidApiUseException; 

	public double totalOrderPrice(); 
	
	public LinkedList<Item> orderedItems();
	
	public int orderItemsCount();

}
