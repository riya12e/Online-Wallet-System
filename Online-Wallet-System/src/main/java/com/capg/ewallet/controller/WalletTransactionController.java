package com.capg.ewallet.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ewallet.entities.WalletTransaction;
import com.capg.ewallet.exception.TransactionNotFoundException;
import com.capg.ewallet.exception.WalletAccountNotFoundException;
import com.capg.ewallet.service.IWalletAccountService;
import com.capg.ewallet.service.IWalletTransactionService;

@RestController

public class WalletTransactionController {

	    @Autowired
		private IWalletTransactionService walletTransactionService;
		@Autowired
		private IWalletAccountService walletAccountService;

	// transfer the fund from one account to the other account
	@PostMapping("/transaction/{id}/amount/{amt}")
	public String transferFund(@PathVariable("id") int receiverId,@PathVariable("amt") double transferAmount) throws WalletAccountNotFoundException 
	{
			    WalletTransaction transaction=new WalletTransaction();
			    transaction.setReceiverAccountId(receiverId);
			    transaction.setAmount(transferAmount);
				walletTransactionService.createTransaction(transaction);
				
				return "Your Transaction is successful";
			
    }

	// this method is used to display the list of transactions done by a user
	@GetMapping("/transactionList/{walletId}")
	public List<WalletTransaction> getTransactionList(@PathVariable int walletId){
			List<WalletTransaction> list = walletTransactionService.getTransactionList(walletId);
			if(list == null)
				return new ArrayList<>();
			else
				return list;
		
	}
	
	@GetMapping("/transaction/{transactionId}")
	public WalletTransaction showTransactionsById(@PathVariable int transactionId) throws TransactionNotFoundException{
		WalletTransaction transaction;
		transaction=walletTransactionService.showTransactionsById(transactionId);
		return transaction;
		
	}
	
	
	
	
}
