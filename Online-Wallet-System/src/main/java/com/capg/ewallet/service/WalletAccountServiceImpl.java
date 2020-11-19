package com.capg.ewallet.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ewallet.entities.BankAccount;
import com.capg.ewallet.entities.WalletAccount;
import com.capg.ewallet.entities.WalletTransaction;
import com.capg.ewallet.exception.TransactionNotFoundException;
import com.capg.ewallet.exception.WalletAccountNotFoundException;
import com.capg.ewallet.repository.IBankAccountRepository;
import com.capg.ewallet.repository.IWalletAccountRepository;

@Transactional
@Service
public class WalletAccountServiceImpl implements IWalletAccountService {
	
	@Autowired
	IWalletAccountRepository walletAccountRepo;
	
	@Autowired
	IBankAccountRepository bankAccountRepo;
	
	//create wallet account
	@Override
	public WalletAccount createWalletAccount(WalletAccount account) {
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
		WalletAccount walletAccount =walletAccountRepo.updateBalance(account);
		return walletAccount.getAccountBalance();
	}

	@Override
	public Double getBalance(int walletId) throws WalletAccountNotFoundException {
		// TODO Auto-generated method stub
		WalletAccount walletAccount = walletAccountRepo.showAccountById(walletId);
		if(walletAccount==null)
			throw new WalletAccountNotFoundException("No walletAccount is found with given Id: "+walletId);
		return walletAccount.getAccountBalance();
	}

}
