package com.dbs.payment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.payment.beans.Bank;

@Repository
public interface BankRepo extends JpaRepository<Bank, String> {

}
