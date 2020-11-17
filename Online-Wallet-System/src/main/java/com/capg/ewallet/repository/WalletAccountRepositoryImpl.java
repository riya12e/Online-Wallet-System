package com.capg.ewallet.repository;

import com.capg.ewallet.entities.BankAccount;
import com.capg.ewallet.entities.WalletAccount;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


public class WalletAccountRepositoryImpl implements IWalletAccountRepository {

	@PersistenceContext
    EntityManager entityManager;
	
	@Override
	public WalletAccount addWalletAccount(WalletAccount account) {
		// TODO Auto-generated method stub
		 entityManager.persist(account);
         return account;
	}

	@Override
	public WalletAccount showAccountById(int walletId) {
		// TODO Auto-generated method stub
		WalletAccount walletAccount = entityManager.find(WalletAccount.class, walletId);
	    return walletAccount;	
	}

	@Override
	public WalletAccount updateBalance(WalletAccount account) {
		entityManager.merge(account);
		return account;
		
	}

	@Override
	public WalletAccount deleteWalletAccount(int walletId) {
		// TODO Auto-generated method stub
		WalletAccount account = entityManager.find(WalletAccount.class, walletId);
		if(account != null)
		{
		entityManager.remove(account);
		}
		return account;
		
	}

	
}
