package com.capg.ewallet.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capg.ewallet.entities.WalletTransaction;
import com.capg.ewallet.entities.WalletUser;

@Repository
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
		//Query query=entityManager.createQuery("select b from WalletTransaction b where b.transactionId=:transId"+transId,WalletTransaction.class);
		//WalletTransaction transaction=(WalletTransaction)query.getResultList().get(0);
		WalletTransaction transaction = entityManager.find(WalletTransaction.class,transId);
		return transaction;
		
	}


	@Override
	public List<WalletTransaction> getAllTransactionById(int walletId) {
		Query query=entityManager.createQuery("select b from WalletTransaction b where b.walletId="+walletId);
		List<WalletTransaction> transactions=query.getResultList();
	        return transactions;
	}
		// TODO Auto-generated constructor stub
		
		
	}


