package com.dbs.payment.service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
	
import com.dbs.payment.beans.Transaction;
import com.dbs.payment.check.SDNCheck;
import com.dbs.payment.exception.ResourceFoundException;
import com.dbs.payment.repo.CustomerRepo;
import com.dbs.payment.repo.TransactionRepo;

@Service
public class TransactionService implements ITransactionService {

	
	@Autowired
	private TransactionRepo transactionRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	private SDNCheck sdnCheck;

	@Override
	public Transaction addTransaction(Transaction transaction) {
		boolean foo=false;
		if(transaction!=null) {
			transaction.setTransferdate( java.sql.Date.valueOf(LocalDate.now()));
			transaction.setStatus("paid");
			try {
				foo=SDNCheck.checkSDN(transaction.getReceiveraccountholdername());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(foo==false) {
				return transactionRepo.save(transaction);
			}
			else
			{
				throw new ResourceFoundException("found in sdn list");
			}
			}
			else
			{
				return null;
			}
	}

	@Override
	public List<Transaction> getAllTransactions() {
		
		return transactionRepo.findAll();
	}

	@Override
	public Transaction getTransaction(int id) {
		
			return transactionRepo.findById(id).get();
	}

	@Override
	public Transaction updateTransaction(int id, Transaction transaction) {
		Optional<Transaction> result=transactionRepo.findById(id);
		if(result.isPresent()) {
			return transactionRepo.save(transaction);
		}
		else
		{
		return null;
		}
	}

	@Override
	public Transaction deleteTransaction(int id) {
		Optional<Transaction> result=transactionRepo.findById(id);
		if(result.isPresent()) {
			transactionRepo.deleteById(id);
			return result.get();
		}
		else
		{
		return null;
		}
	}
}
