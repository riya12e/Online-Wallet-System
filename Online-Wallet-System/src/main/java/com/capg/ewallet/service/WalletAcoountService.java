package com.capg.ewallet.service;

import com.capg.ewallet.entities.WalletAccount;

public interface WalletAcoountService {

	public WalletAccount createWalletAccount(WalletAccount account);
	
	public WalletAccount showAccountById(int walletId);
	
	public double updateBalance(WalletAccount account);
	
	public WalletAccount deleteWalletAccount(int walletId);
	


}
