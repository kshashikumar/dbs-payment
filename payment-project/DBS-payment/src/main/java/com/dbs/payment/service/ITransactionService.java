package com.dbs.payment.service;

import java.util.List;

import com.dbs.payment.beans.Transaction;

public interface ITransactionService {

	Transaction addTransaction(Transaction transaction);

	List<Transaction> getAllTransactions();

	Transaction getTransaction(int id);

	Transaction updateTransaction(int id, Transaction transaction);

	Transaction deleteTransaction(int id);

}