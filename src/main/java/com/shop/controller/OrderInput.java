package com.shop.controller;

import java.util.ArrayList;
import java.util.List;

public class OrderInput {
    private List<OrderProduct> products=new ArrayList<>();

	public OrderInput() {
		super();
	}

	public OrderInput(List<OrderProduct> products) {
		super();
		this.products = products;
	}

	public List<OrderProduct> getProducts() {
		return products;
	}

	public void setProducts(List<OrderProduct> products) {
		this.products = products;
	}
}

class OrderProduct{
    private Long id;
    private int quantity;
	
    public OrderProduct() {
		super();
	}

	public OrderProduct(Long id, int quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
