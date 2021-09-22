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

import com.dbs.payment.beans.Bank;
import com.dbs.payment.beans.Customer;
import com.dbs.payment.service.IBankService;

@RestController
@RequestMapping("api")
public class BankController {

	
	@Autowired
	private IBankService bankService;
	
	@PostMapping("/bank")
	public ResponseEntity<Bank>  addBank(@RequestBody Bank bank) {
		Bank result=bankService.addBank(bank);
		return new ResponseEntity<Bank>(result, HttpStatus.OK); 
	}
	
	@GetMapping("/banks")
	public ResponseEntity<List<Bank>> getAllBanks(){
		List<Bank> banks=bankService.getAllBanks();
		return new ResponseEntity<List<Bank>>(banks, HttpStatus.OK); 
	}
	
	@GetMapping("/bank/{id}")
	public ResponseEntity<Bank> getBank(@PathVariable String id){
		Bank bank=bankService.getBank(id);
		return new ResponseEntity<Bank>(bank, HttpStatus.OK); 
	}
	
	@PutMapping("/bank/{id}")
	public ResponseEntity<Bank> updateCustomer(@PathVariable String id,@RequestBody Bank bank){
		Bank res=bankService.updateBank(id,bank);
		return new ResponseEntity<Bank>(res, HttpStatus.OK); 
	}
	
//	@DeleteMapping("/bank/{id}")
//	public ResponseEntity<Bank> deleteCustomer(@PathVariable String id){
//		Bank bank=bankService.deleteBank(id);
//		return new ResponseEntity<Bank>(bank, HttpStatus.OK); 
//	}
}
