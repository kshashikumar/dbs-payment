package com.dbs.payment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.payment.beans.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {

}
