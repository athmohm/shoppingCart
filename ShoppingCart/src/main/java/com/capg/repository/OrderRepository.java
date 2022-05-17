package com.capg.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capg.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}