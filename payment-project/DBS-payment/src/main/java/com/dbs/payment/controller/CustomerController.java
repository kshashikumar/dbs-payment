package com.dbs.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.dbs.payment.beans.Customer;

import com.dbs.payment.service.ICustomerService;

@RestController
@RequestMapping("api")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer>  addCustomer(@RequestBody Customer customer) {
		Customer result=customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(result, HttpStatus.OK); 
	}
    
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> customers=customerService.getAllCustomers();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK); 
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable String id){
		Customer customer=customerService.getCustomer(id);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK); 
	}
	
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable String id,@RequestBody Customer customer){
		Customer cust=customerService.updateCustomer(id,customer);
		return new ResponseEntity<Customer>(cust, HttpStatus.OK); 
	}
	
//	@DeleteMapping("/customer/{id}")
//	public ResponseEntity<Customer> deleteCustomer(@PathVariable String id){
//		Customer customer=customerService.deleteCustomer(id);
//		return new ResponseEntity<Customer>(customer, HttpStatus.OK); 
//	}
}
