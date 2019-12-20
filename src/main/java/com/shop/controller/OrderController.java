package com.shop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dao.OrderItemRepository;
import com.shop.dao.OrderRepository;
import com.shop.dao.ProductRepository;
import com.shop.entities.Order;
import com.shop.entities.OrderItem;
import com.shop.entities.Product;

@RestController
public class OrderController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @PostMapping("/orders")
    public Order saveOrder(@RequestBody OrderInput orderInput){

    	Order order=new Order();
    	order=orderRepository.save(order);
    	double total=0;
        for(OrderProduct p:orderInput.getProducts()){
            OrderItem orderItem=new OrderItem();
            orderItem.setOrder(order);
            Product product=productRepository.findById(p.getId()).get();
            orderItem.setProduct(product);
            orderItem.setPrice(product.getPrice());
            orderItem.setQuantity(p.getQuantity());
            orderItemRepository.save(orderItem);
           total+=p.getQuantity()*product.getPrice();
        }
        order.setTotalAmount(total);
        return orderRepository.save(order);
    }
}
