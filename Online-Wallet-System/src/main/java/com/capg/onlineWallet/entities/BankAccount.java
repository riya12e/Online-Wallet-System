package com.capg.onlineWallet.entities;
//import javax.persistence.Entity;



public class BankAccount {
	
	
	private int bankAccountNo;
	private String holderName;
	private String ifscCode;
	private WalletAccount walletAccount;
	private String bankName;

	
	public BankAccount() {
		super();
	}
	
	
	public BankAccount(int accountNo, String holderName, String ifscCode, String bankName,
			WalletAccount walletAccount) {
		super();
		this.bankAccountNo = accountNo;
		this.holderName = holderName;
		this.ifscCode = ifscCode;
		this.bankName = bankName;
		this.walletAccount = walletAccount;
	}

	public WalletAccount getWalletAccount() {
		return walletAccount;
	}

	public void setWalletAccount(WalletAccount walletAccount) {
		this.walletAccount = walletAccount;
	}

	
	public int getAccountNo() {
		return bankAccountNo;
	}

	public void setAccountNo(int i) {
		this.bankAccountNo = i;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	
	
	


	
	

}
