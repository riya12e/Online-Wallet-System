
package com.capg.ewallet.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.ewallet.entities.WalletAccount;
import com.capg.ewallet.entities.WalletTransaction;
import com.capg.ewallet.exception.LowBalanceException;
import com.capg.ewallet.exception.TransactionNotFoundException;
import com.capg.ewallet.exception.WalletAccountNotFoundException;

import com.capg.ewallet.repository.IWalletAccountRepository;
import com.capg.ewallet.repository.IWalletTransactionRepository;

@Transactional
@Service
public class WalletTransactionServiceImpl implements IWalletTransactionService {
	
	@Autowired 
	IWalletTransactionRepository walletTransactionRepository;
	
	@Autowired
	IWalletAccountRepository walletAccountRepository;
	
	@Autowired 
	IWalletAccountService walletAccountService;
	
	WalletAccount senderAccount = new WalletAccount();
	WalletAccount receiverAccount = new WalletAccount();

	@Override
	public void createTransaction(WalletTransaction transaction) throws WalletAccountNotFoundException, LowBalanceException {
		// TODO Auto-generated method stub
		 double senderFinalBalance = 0,receiverfinalBalance = 0 ;
		LocalDateTime now = LocalDateTime.now();  
		
		    int recipientAccountId = transaction.getReceiverAccountId();
			 int senderAccountId=transaction.getAccountId().getWalletId();
		     double transferAmount = transaction.getAmount();
			
			 double senderPrevBalance = transaction.getAccountBalance();
			 boolean a=validate(senderPrevBalance);
			 receiverAccount = walletAccountService.showAccountById(transaction.getReceiverAccountId());
			 
			 double receiverPrevBalance = receiverAccount.getAccountBalance();
			 boolean b=validate(receiverPrevBalance);
			 
			 if(transferAmount < senderPrevBalance) {
			  senderFinalBalance  = senderPrevBalance - transferAmount;
			 receiverfinalBalance = receiverPrevBalance + transferAmount;
			 }
			 else
				 System.out.println("Transaction is not possible");
			 transaction.setAccountBalance(senderFinalBalance);
			 receiverAccount.setAccountBalance(receiverfinalBalance);
			 transaction.getAccountId().setAccountBalance(senderFinalBalance);
			
			 
		     transaction.setDateOfTransaction(now);
			
			 walletTransactionRepository.addTransaction(transaction);	
}

    private boolean validate(double PrevBalance) throws LowBalanceException {
		// TODO Auto-generated method stub
    	if(PrevBalance<500) {
    		throw new LowBalanceException("Balance is low to perform transaction"+PrevBalance);
    	}
		return true;
	}

	@Override
	public double checkUpdatedBalance(int walletId) throws WalletAccountNotFoundException {
		// TODO Auto-generated method stub
	 WalletAccount	walletAccount=walletAccountRepository.showAccountById(walletId);
	 if(walletAccount==null)
	 {
		 throw new WalletAccountNotFoundException("No transaction is performed with given Id: "+walletId);
	 }
		return walletAccount.getAccountBalance();
	
	}

	@Override
	public WalletTransaction showTransactionsById(int transactionId) throws TransactionNotFoundException {
		// TODO Auto-generated method stub
		WalletTransaction walletTransaction = walletTransactionRepository.getTransactionById(transactionId);
		if(walletTransaction==null)
			throw new TransactionNotFoundException("No transaction is performed with given Id: "+transactionId);
		return walletTransaction;
		
	}

	
    @Override
	public List<WalletTransaction> getTransactionList(int walletId) {
		// TODO Auto-generated method stub
		return walletTransactionRepository.getAllTransactionById(walletId);
		
	}

}
