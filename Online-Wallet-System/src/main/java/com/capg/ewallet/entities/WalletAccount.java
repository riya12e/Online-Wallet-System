package com.capg.ewallet.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "wallet_tbl")
public class WalletAccount {
	
	@Id
	@Column(length=10,name="wallet_id")
	@GeneratedValue(generator = "wallet_seq",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "wallet_seq",sequenceName = "wallet_seq",allocationSize = 1)
	private int walletId;
	
	//@Enumerated(EnumType.STRING)
	@Column(name = "wallet_status")
	private String status;
	
	@Column(name="account_balance")
    private double accountBalance;
	
	@JsonIgnore
	@OneToMany(mappedBy = "walletAccount",cascade = CascadeType.REMOVE)
	private List<BankAccount> bankAccounts=new ArrayList<BankAccount>();
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	@JsonBackReference
    private WalletUser walletUser;

	public WalletAccount() {
		super();
	}

	public WalletAccount(int walletId, String status, double accountBalance, List<BankAccount> bankAccounts,
			WalletUser walletUser) {
		super();
		this.walletId = walletId;
		this.status = status;
		this.accountBalance = accountBalance;
		this.bankAccounts = bankAccounts;
		this.walletUser = walletUser;
	}

	public int getWalletId() {
		return walletId;
	}

	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public WalletUser getWalletUser() {
		return walletUser;
	}

	public void setWalletUser(WalletUser walletUser) {
		this.walletUser = walletUser;
	}

	
	
}