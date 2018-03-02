package com.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rest.domain.SellerRequest;

public interface SellerRequestRepository extends CrudRepository<SellerRequest, Integer> {
    @Query("select s from SellerRequest s where s.status =1")
    List<SellerRequest> getApprove();

    @Query("select s from SellerRequest s where s.status =0")
    List<SellerRequest> getPending();

    @Query("select s from SellerRequest s where s.status =-1")
    List<SellerRequest> getReject();
}
