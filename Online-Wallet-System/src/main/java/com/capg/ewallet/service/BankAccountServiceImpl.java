
	package com.capg.ewallet.service;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.capg.ewallet.entities.BankAccount;
	import com.capg.ewallet.exception.BankAccountException;
	import com.capg.ewallet.repository.IBankAccountRepository;



	@Service
	public class BankAccountServiceImpl implements IBankAccountService {

		@Autowired
		IBankAccountRepository bankAccountRepo;

		@Override
		public BankAccount findBankAccountById(long accountId) throws BankAccountException {
			BankAccount bankAccount=bankAccountRepo.findBankAccountById(accountId);
			
			 if(bankAccount==null)
			 {
				 throw new BankAccountException(accountId +" Not found");
			 }

			 return bankAccount;
		}

		@Override
		public BankAccount addBankAccount(BankAccount bankAccount) throws BankAccountException {
			
			bankAccountRepo.addBankAccount(bankAccount);
			
			return bankAccount;
		}

		@Override
		public BankAccount updateBankAccountDetails(BankAccount bankAccount) throws BankAccountException {
			if(bankAccountRepo.findBankAccountById(bankAccount.getAccountId())!=null)
			{
			bankAccountRepo.updateBankAccountDetails(bankAccount);
			}
			else
			{
				throw new BankAccountException(bankAccount.getAccountId()+" Id not Found");
			}
			return bankAccount;	
			}
		

		@Override
		public BankAccount deleteBankAccountById(long accountId) throws BankAccountException {
			
			BankAccount bankAccount = bankAccountRepo.deleteBankAccountById(accountId);
			
			 if(bankAccount==null)
			 {
				 throw new BankAccountException(accountId+" Id not Found");
			 }
			 return bankAccount;
		}

		@Override
		public List<BankAccount> viewAllBankAccounts() throws BankAccountException {
			 List<BankAccount> list =	bankAccountRepo.viewAllBankAccounts();
			    if(list.isEmpty())
			    {
			    	throw new BankAccountException(" Empty Record");
			    }
				 return list;
		}

		@Override
		public List<BankAccount> viewAllBankAccountsByWalletId(int walletId) throws BankAccountException {
			
			List<BankAccount> list =	bankAccountRepo.viewAllBankAccountsByWalletId(walletId);
				if(list.isEmpty())
				{
					throw new BankAccountException("Empty Record");
				}
				
				return list;
		}

		

	}


