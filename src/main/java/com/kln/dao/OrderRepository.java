package com.kln.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kln.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
