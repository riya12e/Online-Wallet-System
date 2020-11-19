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

import com.capg.ewallet.entities.WalletAccount;
import com.capg.ewallet.entities.WalletTransaction;
import com.capg.ewallet.exception.LowBalanceException;
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
	@PostMapping("/transaction/id/{senderid}/id/{receiverid}/amount/{amt}")
	public String transferFund(@PathVariable("senderid") int receiverId,@PathVariable("receiverid") int senderId,@PathVariable("amt") double transferAmount) throws WalletAccountNotFoundException, LowBalanceException 
	{
		WalletAccount account=new WalletAccount();
		account=walletAccountService.showAccountById(senderId); 
		if(account==null) {
			throw new WalletAccountNotFoundException("Wallet Account is not found with the given id:"+senderId);
		}
		WalletTransaction transaction=new WalletTransaction();
		transaction.setAccountId(account);
	    transaction.setReceiverAccountId(receiverId);
	    transaction.setAmount(transferAmount);
		walletTransactionService.createTransaction(transaction);
		
		return "Your Transaction is successful";	    
			
    }

	// this method is used to display the list of transactions done by a user
	@GetMapping("/transactionList/{walletId}")
	public List<WalletTransaction> getTransactionList(@PathVariable int walletId) throws WalletAccountNotFoundException{
		System.out.println(walletId);
		WalletAccount account=new WalletAccount();
		account=walletAccountService.showAccountById(walletId);
		if(account==null) {
			throw new WalletAccountNotFoundException("Wallet Account is not found with the given id:"+walletId);
			
		}
		else {
			List<WalletTransaction> list = walletTransactionService.getTransactionList(walletId);
			if(list == null)
				return new ArrayList<>();
			else
				return list;
		}
}
	
	
	@GetMapping("/transaction/{transactionId}")
	public WalletTransaction showTransactionsById(@PathVariable int transactionId) throws TransactionNotFoundException{
		WalletTransaction transaction;
		transaction=walletTransactionService.showTransactionsById(transactionId);
		if(transaction==null)
		{
			throw new TransactionNotFoundException("No Transaction is performed with the given id:"+transactionId);
		}
		return transaction;
		
	}
	
	
	
	
}
