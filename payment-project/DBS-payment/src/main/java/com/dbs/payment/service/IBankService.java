package com.dbs.payment.service;

import java.util.List;

import com.dbs.payment.beans.Bank;

public interface IBankService {

	Bank addBank(Bank bank);

	List<Bank> getAllBanks();

	Bank getBank(String id);

	Bank updateBank(String id, Bank bank);

	Bank deleteBank(String id);
}