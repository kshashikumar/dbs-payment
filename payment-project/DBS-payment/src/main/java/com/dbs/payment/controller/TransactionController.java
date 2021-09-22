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
import com.dbs.payment.beans.Message;
import com.dbs.payment.beans.Transaction;
import com.dbs.payment.service.ITransactionService;

@RestController
@RequestMapping("api")
public class TransactionController {

	@Autowired
	private ITransactionService transactionService;
	
	@PostMapping("/transaction")
	public ResponseEntity<Transaction>  addTransaction(@RequestBody Transaction transaction) {
		Transaction result=transactionService.addTransaction(transaction);
		return new ResponseEntity<Transaction>(result, HttpStatus.OK); 
	}
	
	@GetMapping("/transactions")
	public ResponseEntity<List<Transaction>> getAllTransactions(){
		List<Transaction> transactions=transactionService.getAllTransactions();
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK); 
	}
	
	@GetMapping("/transaction/{id}")
	public ResponseEntity<Transaction> getTransaction(@PathVariable int id){
		Transaction transaction=transactionService.getTransaction(id);
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK); 
	}
	
	@PutMapping("/transaction/{id}")
	public ResponseEntity<Transaction> updateTransaction(@PathVariable int id,@RequestBody Transaction transaction){
		Transaction res=transactionService.updateTransaction(id,transaction);
		return new ResponseEntity<Transaction>(res, HttpStatus.OK); 
	}
	
//	@DeleteMapping("/transaction/{id}")
//	public ResponseEntity<Transaction> deleteTransaction(@PathVariable int id){
//		Transaction transaction=transactionService.deleteTransaction(id);
//		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK); 
//	}
}
