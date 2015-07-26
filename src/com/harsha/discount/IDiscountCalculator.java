package com.harsha.discount;

import java.util.LinkedList;

import com.harsha.catalog.Item;

public interface IDiscountCalculator {
	public double calculateDiscount(LinkedList<Item> items);
}
