package com.rest.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.domain.UserAccount;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Integer> {
	@Query("select u from UserAccount u where u.username=:username and u.password=:password ")
	UserAccount login(@Param("username") String username, @Param("password") String password);

	@Query("select u from UserAccount u where u.username=:username ")
	UserAccount test(@Param("username") String username);

	@Query("select u from UserAccount u ")
	Iterable<UserAccount> getAll();
}
