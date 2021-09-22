package com.dbs.payment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.dbs.payment.beans.Message;

@Repository
public interface MessageRepo extends JpaRepository<Message, String> {

}
