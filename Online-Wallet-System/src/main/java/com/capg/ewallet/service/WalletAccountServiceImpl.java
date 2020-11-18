package com.capg.ewallet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.capg.ewallet.entities.BankAccount;
import com.capg.ewallet.entities.WalletAccount;
import com.capg.ewallet.entities.WalletTransaction;
import com.capg.ewallet.exception.TransactionNotFoundException;
import com.capg.ewallet.exception.WalletAccountNotFoundException;
import com.capg.ewallet.repository.IBankAccountRepository;
import com.capg.ewallet.repository.IWalletAccountRepository;

public class WalletAccountServiceImpl implements IWalletAccountService {
	
	@Autowired
	IWalletAccountRepository walletAccountRepo;
	
	@Autowired
	IBankAccountRepository bankAccountRepo;
	
	//create wallet account
	@Override
	public WalletAccount createWalletAccount(WalletAccount account) {
		account.setAccountBalance(0);
		return walletAccountRepo.addWalletAccount(account);
	}

	
	@Override
	public WalletAccount showAccountById(int walletId) throws WalletAccountNotFoundException {
		WalletAccount walletAccount = walletAccountRepo.showAccountById(walletId);
		if(walletAccount==null)
			throw new WalletAccountNotFoundException("No walletAccount is found with given Id: "+walletId);
		return walletAccount;
		
	}

	@Override
	public double updateBalance(WalletAccount account) {
		/*int walletId=account.getAccountId();
	    List<BankAccount> bankAccounts=bankAccountRepo.viewAllBankAccountsByWalletId(walletId);
		double totalBalance = 0;*/
		
		return 0;
	}

	@Override
	public WalletAccount deleteWalletAccount(int walletId) throws WalletAccountNotFoundException {
		// TODO Auto-generated method stub
		WalletAccount walletAccount = walletAccountRepo.showAccountById(walletId);
		if(walletAccount==null)
			throw new WalletAccountNotFoundException("No walletAccount is found with given Id: "+walletId);
		walletAccountRepo.deleteWalletAccount(walletId);
		
		return walletAccount;
	}

}
