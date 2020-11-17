package com.capg.ewallet.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.capg.ewallet.entities.WalletTransaction;


public class  WalletTransactionRepositoryImpl implements IWalletTransactionRepository {
	
	
	@PersistenceContext
    EntityManager entityManager;
	
	
	@Override
	public WalletTransaction addTransaction(WalletTransaction transaction) {
		// TODO Auto-generated method stub
		entityManager.persist(transaction);
		return transaction;
		
		
	}

	@Override
	public WalletTransaction getTransactionById(int transId) {
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("select b from WalletTransaction b where b.transactionId="+transId,WalletTransaction.class);
		WalletTransaction transaction=(WalletTransaction)query.getResultList().get(0);
		return transaction;
		
	}

	@Override
	public List<WalletTransaction> getTransactionByDate(int date) {
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("select b from WalletTransaction b where b.dateOfTransaction="+date);
		List<WalletTransaction> transactions=query.getResultList();
	        return transactions;
	}
	

	@Override
	public List<WalletTransaction> getAllTransactionById(int walletId) {
		Query query=entityManager.createQuery("select b from WalletTransaction b where b.walletId="+walletId);
		List<WalletTransaction> transactions=query.getResultList();
	        return transactions;
	}
		// TODO Auto-generated constructor stub
		
		
	}


