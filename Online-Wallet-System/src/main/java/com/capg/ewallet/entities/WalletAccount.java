package com.capg.ewallet.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "wallet_tbl")
public class WalletAccount {
	
	@Id
	@Column(length=5,name="WalletId")
	private int walletId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Status")
	Status status;
	
	@Column(name="AccountBalance")
    private double accountBalance;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "UserId")
	@JsonBackReference
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
