package com.shop.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double totalAmount;
    @OneToMany(mappedBy = "order")
    private Collection<OrderItem> orderItems;
	
	public double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public Collection<OrderItem> getOrderItems() {
		return orderItems;
	}


	public void setOrderItems(Collection<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
}
