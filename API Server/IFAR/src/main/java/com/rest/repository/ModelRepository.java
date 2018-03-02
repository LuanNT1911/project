package com.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rest.domain.Model;

public interface ModelRepository extends CrudRepository<Model, Long> {
	@Query("select u from Model u")
	 List<Model> getAll();
	@Query("select m.link from Model m where m.sellerRequest.id =:id")
	String getLinkBySellerRequestId(@Param("id") Integer id);
}
