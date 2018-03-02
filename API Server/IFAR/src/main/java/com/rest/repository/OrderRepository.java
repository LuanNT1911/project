package com.rest.repository;

import org.springframework.data.repository.CrudRepository;

import com.rest.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
