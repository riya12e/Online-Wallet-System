package com.capg.ewallet.entities;

public class WalletAccount {
	
	
	private int walletId;
	Status status;
    private double accountBalance;
    private WalletUser walletUser;
    
    
    public WalletAccount() {
		
	}
    
    public WalletAccount(int accountId, Status status, double accountBalance, WalletUser walletUser) {
		super();
		this.walletId = accountId;
		this.status = status;
		this.accountBalance = accountBalance;
		this.walletUser = walletUser;
		
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

	

	public WalletUser getWalletUser() {
		return walletUser;
	}

	public void setWalletUser(WalletUser walletUser) {
		this.walletUser = walletUser;
	}

	@Override
	public String toString() {
		return "WalletAccount [walletId=" + walletId + ", status=" + status + ", accountBalance=" + accountBalance
				+ ", walletUser=" + walletUser +  "]";
	}
	
	
}
