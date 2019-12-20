package com.shop.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.shop.entities.Order;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Long> {

}
