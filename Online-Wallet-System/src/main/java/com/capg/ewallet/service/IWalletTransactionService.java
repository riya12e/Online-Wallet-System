package com.capg.ewallet.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capg.ewallet.entities.WalletTransaction;
import com.capg.ewallet.exception.TransactionNotFoundException;
import com.capg.ewallet.exception.WalletAccountNotFoundException;

@Service
public interface IWalletTransactionService {


	public void createTransaction(WalletTransaction transaction) throws WalletAccountNotFoundException;
	
	public double checkUpdatedBalance(int walletId) throws WalletAccountNotFoundException;
	
	public WalletTransaction showTransactionsById(int transactionId) throws TransactionNotFoundException;
	
	public List<WalletTransaction> getTransactionList(int walletId);

}
