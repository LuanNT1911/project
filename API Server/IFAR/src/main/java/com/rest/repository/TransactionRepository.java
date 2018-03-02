package com.rest.repository;

import org.springframework.data.repository.CrudRepository;

import com.rest.domain.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}
