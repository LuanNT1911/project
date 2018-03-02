package com.rest.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rest.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
	@Query("select u from Role u ")
	Iterable<Role> getAll();
}
