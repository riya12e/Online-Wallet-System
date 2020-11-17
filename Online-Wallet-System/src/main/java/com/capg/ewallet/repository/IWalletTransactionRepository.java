package com.capg.ewallet.repository;

import java.util.List;

import com.capg.ewallet.entities.WalletTransaction;


public interface IWalletTransactionRepository {

	public WalletTransaction addTransaction(WalletTransaction transaction);
	public WalletTransaction getTransactionById(int transId);
	public List<WalletTransaction> getTransactionByDate(int date);
	public List<WalletTransaction> getAllTransactionById(int walletId);
	
	
}
