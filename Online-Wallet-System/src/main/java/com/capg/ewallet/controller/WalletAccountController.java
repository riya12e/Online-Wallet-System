package com.capg.ewallet.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ewallet.entities.Status;
import com.capg.ewallet.entities.WalletAccount;
import com.capg.ewallet.entities.WalletUser;
import com.capg.ewallet.exception.WalletAccountNotFoundException;
import com.capg.ewallet.exception.WalletUserException;
import com.capg.ewallet.service.IWalletAccountService;
import com.capg.ewallet.service.IUserService;

@RestController
public class WalletAccountController {
	@Autowired
	private IWalletAccountService walletAccountService;

	@Autowired
	private IUserService userService;

	//create walletUser account
	@GetMapping(value = "/create/{userId}")
	public WalletAccount createWalletUser(@PathVariable int userId) throws WalletUserException {
		WalletAccount account = new WalletAccount();
		WalletUser user=new WalletUser();
		user=userService.showUserById(userId);
		account.setStatus("Active");
		account.setAccountBalance(0);
		account.setWalletUser(user);
		account = walletAccountService.createWalletAccount(account);
		return account;
	}

	//show account details on the basis of id
	@GetMapping("/seeWalletAccount/{id}")
	public WalletAccount showAccountById(@PathVariable("id") int walletId) throws WalletAccountNotFoundException 
	{
		WalletAccount wallet = new WalletAccount();
		wallet = walletAccountService.showAccountById(walletId);
	      if (wallet == null)
	      {
				//throw new UserNotFoundException("Record Not Found");
	    	  System.out.println("Record not Found");
	      }
		return wallet;
	} 


	
	// add money to wallet
	@GetMapping("/addMoney/{accountId}/{amount}")
	public double addMoney(@PathVariable int accountId, @PathVariable double amount) throws WalletAccountNotFoundException 
	{
		double finalBalance = 0;
			WalletAccount account = walletAccountService.showAccountById(accountId);
			double prevBalance = account.getAccountBalance();
			finalBalance  = prevBalance + amount;
			account.setAccountBalance(finalBalance);
			finalBalance = walletAccountService.updateBalance(account);
	return finalBalance;
	}
	
	//show account balance on the basis of id
		@GetMapping("/getBalance/{id}")
		public Double getWalletAccountBalance(@PathVariable("id") int walletId) throws WalletAccountNotFoundException 
		{
			Double balance = walletAccountService.getBalance(walletId);
		    return balance;
		}



}
