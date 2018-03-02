package com.rest.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rest.domain.Model;
import com.rest.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	@Query("select u from Product u ")
	List<Product> getAll();
//	@Query("INSERT INTO Product (name, price, quantity, origin, weight, describe, image, status, createdAt, updatedAt, model) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
//	void addProduct(String name, double price, int quant, String orgi, double weig, String desc, String image, String stau, Date create, Date update,Model model);
}
