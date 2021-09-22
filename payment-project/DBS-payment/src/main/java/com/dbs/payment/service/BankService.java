package com.dbs.payment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.payment.beans.Bank;
import com.dbs.payment.beans.Customer;
import com.dbs.payment.repo.BankRepo;

@Service
public class BankService implements IBankService {

	@Autowired
	private BankRepo bankRepo;
	
	@Override
	public Bank addBank(Bank bank) {
		if(bank!=null) {
		return bankRepo.save(bank);
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public List<Bank> getAllBanks() {
		return bankRepo.findAll();
	}
	
	@Override
	public Bank getBank(String id) {
		if(id!=null) {
		return bankRepo.findById(id).get();
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public Bank updateBank(String id,Bank bank) {
		Optional<Bank> result=bankRepo.findById(id);
		if(result.isPresent()) {
			return bankRepo.save(bank);
		}
		else
		{
		return null;
		}
	}

	@Override
	public Bank deleteBank(String id) {
		Optional<Bank> result=bankRepo.findById(id);
		if(result.isPresent()) {
			bankRepo.deleteById(id);
			return result.get();
		}
		else
		{
		return null;
		}
	}

}
