package com.dbs.payment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.payment.beans.Customer;
import com.dbs.payment.repo.CustomerRepo;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public Customer addCustomer(Customer customer) {
		if(customer!=null) {
		return customerRepo.save(customer);
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public Customer getCustomer(String id) {
		if(id!=null) {
		return customerRepo.findById(id).get();
		}
		else
		{
			return null;
		}
	}

	public Customer updateCustomer(String id, Customer customer) {
		Optional<Customer> result=customerRepo.findById(id);
		if(result.isPresent()) {
			return customerRepo.save(customer);
		}
		else
		{
		return null;
		}
	}

	
	public Customer deleteCustomer(String id) {
		Optional<Customer> result=customerRepo.findById(id);
		if(result.isPresent()) {
			customerRepo.deleteById(id);
			return result.get();
		}
		else
		{
		return null;
		}
	}
	
}
