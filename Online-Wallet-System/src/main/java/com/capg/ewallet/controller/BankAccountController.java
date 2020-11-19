package com.capg.ewallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capg.ewallet.entities.BankAccount;
import com.capg.ewallet.exception.BankAccountException;
import com.capg.ewallet.service.IBankAccountService;





@RestController
public class BankAccountController {
	


		@Autowired
		IBankAccountService bankAccountService;
		
	    @GetMapping("bankAccount/{aid}")
		public ResponseEntity<BankAccount> findBankAccountById(@PathVariable("aid") int accountId) throws BankAccountException
		{
			BankAccount bankAccount = null;
			
		    bankAccount =bankAccountService.findBankAccountById(accountId);
			
			ResponseEntity<BankAccount> re = new ResponseEntity<BankAccount>(bankAccount,HttpStatus.OK);
		    return re;
		}
	    
	    
	    @PostMapping("bankAccount")
		public ResponseEntity<BankAccount> addBankAccount(@RequestBody BankAccount bankAccount) throws BankAccountException
		{
			BankAccount b= bankAccountService.addBankAccount(bankAccount);
			ResponseEntity<BankAccount> re = new ResponseEntity<BankAccount>(b,HttpStatus.OK);
			return re;
		}
	    
	    @PutMapping("bankAccount")
		public ResponseEntity<BankAccount> updateProduct(@RequestBody BankAccount bankAccount) throws BankAccountException
		{
			BankAccount b = bankAccountService.updateBankAccountDetails(bankAccount);
			ResponseEntity<BankAccount> re = new ResponseEntity<BankAccount>(b,HttpStatus.OK);
			return re;
		}
	    
	    @DeleteMapping("bankAccount/{aid}")
		public ResponseEntity<BankAccount> removeCustomer(@PathVariable("aid") int aid) throws BankAccountException
		{
			BankAccount b= bankAccountService.deleteBankAccountById(aid);
			ResponseEntity<BankAccount> re = new ResponseEntity<BankAccount>(b,HttpStatus.OK);
			return re;
		}
	    
	   @GetMapping("bankAccount")
		public ResponseEntity<List<BankAccount>> ViewAllBankAccounts() throws BankAccountException
		{
			List<BankAccount> list =bankAccountService.viewAllBankAccounts();
			ResponseEntity<List<BankAccount>> re = new ResponseEntity<List<BankAccount>>(list,HttpStatus.OK);
			return re;
		}
	    
	    @GetMapping("bankAccount/wid")
		public ResponseEntity<List<BankAccount>> ViewAllBankAccountsByWalletId(@PathVariable("wid") int wid) throws BankAccountException
		{
			List<BankAccount> list =bankAccountService.viewAllBankAccountsByWalletId(wid);
			ResponseEntity<List<BankAccount>> re = new ResponseEntity<List<BankAccount>>(list,HttpStatus.OK);
			return re;
		}
		
		
}
