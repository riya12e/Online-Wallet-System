package com.capg.ewallet.service;

import com.capg.ewallet.entities.WalletAccount;
import com.capg.ewallet.exception.WalletAccountNotFoundException;

public interface IWalletAccountService {

	public WalletAccount createWalletAccount(WalletAccount account);
	
	public WalletAccount showAccountById(int walletId) throws WalletAccountNotFoundException;
	
	public double updateBalance(WalletAccount account);
	
	public Double getBalance(int walletId) throws WalletAccountNotFoundException;
	
     

}
