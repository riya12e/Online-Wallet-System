package com.capg.ewallet.service;

import org.springframework.stereotype.Service;

import com.capg.ewallet.entities.BankAccount;

@Service
public interface BankAccountService {

	

		public BankAccount addBankAccount(BankAccount bankAccount);

	    public BankAccount showAllBankAccounts(int walletId);
	    
	    public BankAccount deleteBankAccount(int walletId);
	    
	    public BankAccount updateBankAccount(int walletId);


	}

