package com.rest.repository;

import org.springframework.data.repository.CrudRepository;

import com.rest.domain.OrderDetail;

public interface OrderDetailRepository extends CrudRepository<OrderDetail, Long> {

}
