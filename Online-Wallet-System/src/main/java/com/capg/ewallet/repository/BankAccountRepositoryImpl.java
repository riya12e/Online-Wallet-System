package com.capg.ewallet.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capg.ewallet.entities.BankAccount;
import com.capg.ewallet.entities.WalletAccount;
import com.capg.ewallet.exception.BankAccountException;


@Repository
@Transactional
public class BankAccountRepositoryImpl implements IBankAccountRepository{

	@PersistenceContext
	EntityManager entityManager;
	WalletAccount walletAccount;
	
	@Override
	public BankAccount findBankAccountById(long accountId) throws BankAccountException {
		BankAccount bankAccount = entityManager.find(BankAccount.class, accountId);
		
		return bankAccount;
	}

	

	@Override
	public BankAccount addBankAccount(BankAccount bankAccount) throws BankAccountException {
		entityManager.persist(bankAccount);
		
		return bankAccount;
	}

	@Override
	public BankAccount updateBankAccountDetails(BankAccount bankAccount) throws BankAccountException {
		entityManager.merge(bankAccount);
		return bankAccount;
	}

	@Override
	public BankAccount deleteBankAccountById(long accountId) throws BankAccountException {
		BankAccount bankAccount = entityManager.find(BankAccount.class, accountId);
		bankAccount.setWalletAccount(null);
		if(bankAccount != null)
		{
			entityManager.remove(bankAccount);
		}
		return bankAccount;
	}

	
	@Override
	public List<BankAccount> viewAllBankAccounts() throws BankAccountException {
		String qry = "SELECT b FROM BankAccount b";
		TypedQuery<BankAccount> query = entityManager.createQuery(qry,BankAccount.class);
		List<BankAccount> list = query.getResultList();
		return list;
	}
	@Override
	public List<BankAccount> viewAllBankAccountsByWalletId(int walletId) throws BankAccountException {
	// TODO Auto-generated method stub
		walletId=walletAccount.getWalletId();
		Query query=entityManager.createQuery("select b from BankAccount b where b.walletId="+walletId);
		List<BankAccount> bankAccounts=query.getResultList();
	        return bankAccounts;
	}

	

}
