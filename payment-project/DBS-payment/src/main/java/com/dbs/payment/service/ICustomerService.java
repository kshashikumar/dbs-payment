package com.dbs.payment.service;

import java.util.List;

import com.dbs.payment.beans.Customer;

public interface ICustomerService {

	Customer addCustomer(Customer customer);

	List<Customer> getAllCustomers();
	Customer getCustomer(String id);
	Customer updateCustomer(String id, Customer customer);
	Customer deleteCustomer(String id);
}