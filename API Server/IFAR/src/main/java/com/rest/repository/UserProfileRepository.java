package com.rest.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.rest.domain.UserAccount;
import com.rest.domain.UserProfile;

public interface UserProfileRepository extends Repository<UserProfile, Long> {
	@Query(value = "select u from UserProfile u where u.userAccountUsername=:userAccountUsername")
	UserProfile getUserProfile(@Param("userAccountUsername") String userAccountUsername);
}
