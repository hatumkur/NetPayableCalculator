package com.harsha.catalog;

public class Item {
	final private Integer id;
	final private double itemPrice;
	final private String type;
	
	public Item(Integer aid, double aprice, String atype) {
		id = aid;
		itemPrice = aprice;
		type = atype;
	}
	
	public Item(Item newItem) {
		id = newItem.id;
		itemPrice = newItem.itemPrice;
		type = newItem.type;
	}
	
	public Integer id() {
		return id;
	}

	public double price() {
		return itemPrice;
	}
	
	public String type() {
		return type;
	}
}
