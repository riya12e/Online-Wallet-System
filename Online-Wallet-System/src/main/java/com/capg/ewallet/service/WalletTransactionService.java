package com.capg.ewallet.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capg.ewallet.entities.WalletTransaction;

@Service
public interface WalletTransactionService {


	public void createTransaction(WalletTransaction transaction);
	
	public double checkUpdatedBalance(int walletId);
	
	public List<WalletTransaction> showTransactionsById(int transactionId);
	
	public List<WalletTransaction> showTransactionsByDate(LocalDate date);
	
	public List<WalletTransaction> getTransactionList(int walletId);

}
