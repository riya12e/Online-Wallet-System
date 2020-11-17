package com.capg.ewallet.repository;

import com.capg.ewallet.entities.WalletAccount;

public interface IWalletAccountRepository {

    public WalletAccount addWalletAccount(WalletAccount account);
	
	public WalletAccount showAccountById(int walletId);
	
	public WalletAccount updateBalance(WalletAccount account);
	
	public WalletAccount deleteWalletAccount(int walletId);
}
