package com.capg.ewallet.repository;

import java.util.List;

import com.capg.ewallet.entities.BankAccount;
import com.capg.ewallet.exception.BankAccountException;

public interface IBankAccountRepository {


	public BankAccount findBankAccountById(int accountId) throws BankAccountException;
	public BankAccount addBankAccount(BankAccount bankAccount) throws BankAccountException;
	public BankAccount updateBankAccountDetails(BankAccount bankAccount) throws BankAccountException;
	public BankAccount deleteBankAccountById(int accountId) throws BankAccountException;
	public BankAccount viewBankAccountById(int accountId) throws BankAccountException;
	public List<BankAccount> viewAllBankAccountsByWalletId(int walletId) throws BankAccountException;

	}
