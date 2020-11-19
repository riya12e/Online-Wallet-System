package com.capg.ewallet.service;

import java.util.List;

import com.capg.ewallet.entities.BankAccount;
import com.capg.ewallet.exception.BankAccountException;

public interface IBankAccountService {

	public BankAccount findBankAccountById(long accountId) throws BankAccountException;
	public BankAccount addBankAccount(BankAccount bankAccount) throws BankAccountException;
	public BankAccount updateBankAccountDetails(BankAccount bankAccount) throws BankAccountException;
	public BankAccount deleteBankAccountById(long accountId) throws BankAccountException;
	public List<BankAccount> viewAllBankAccounts() throws BankAccountException;
	public List<BankAccount> viewAllBankAccountsByWalletId(int walletId) throws BankAccountException;
	

}


