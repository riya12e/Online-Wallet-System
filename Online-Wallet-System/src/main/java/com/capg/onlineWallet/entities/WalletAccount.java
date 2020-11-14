package com.capg.onlineWallet.entities;

public class WalletAccount {
	
	
	private int walletId;
	Status status;
    private double accountBalance;
    private WalletUser walletUser;
    private BankAccount bankAccount;
    
    public WalletAccount() {
		
	}
    
    public WalletAccount(int accountId, Status status, double accountBalance, WalletUser walletUser,
			BankAccount bankAccount) {
		super();
		this.walletId = accountId;
		this.status = status;
		this.accountBalance = accountBalance;
		this.walletUser = walletUser;
		this.bankAccount = bankAccount;
	}

	public int getAccountId() {
		return walletId;
	}

	public void setAccountId(int accountId) {
		this.walletId = accountId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public WalletUser getWalletUser() {
		return walletUser;
	}

	public void setWalletUser(WalletUser walletUser) {
		this.walletUser = walletUser;
	}

	@Override
	public String toString() {
		return "WalletAccount [walletId=" + walletId + ", status=" + status + ", accountBalance=" + accountBalance
				+ ", walletUser=" + walletUser + ", bankAccount=" + bankAccount + "]";
	}
	
	
}
