package com.capg.ewallet.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capg.ewallet.entities.BankAccount;
import com.capg.ewallet.entities.WalletTransaction;
import com.capg.ewallet.exception.BankAccountException;





@Repository
@Transactional
public class BankAccountRepositoryImpl implements IBankAccountRepository{

@PersistenceContext
EntityManager entityManager;

@Override
public BankAccount findBankAccountById(int accountId) throws BankAccountException {
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
public BankAccount deleteBankAccountById(int accountId) throws BankAccountException {
BankAccount bankAccount = entityManager.find(BankAccount.class, accountId);
bankAccount.setWalletAccount(null);
if(bankAccount != null)
{
entityManager.remove(bankAccount);
}
return bankAccount;
}

@Override
public BankAccount viewBankAccountById(int accountId) throws BankAccountException {

	BankAccount bankAccount = entityManager.find(BankAccount.class, accountId);
    return bankAccount;
}


@Override
public List<BankAccount> viewAllBankAccountsByWalletId(int walletId) throws BankAccountException {
// TODO Auto-generated method stub
	Query query=entityManager.createQuery("select b from BankAccount b where b.walletId="+walletId);
	List<BankAccount> bankAccounts=query.getResultList();
        return bankAccounts;
}
}



