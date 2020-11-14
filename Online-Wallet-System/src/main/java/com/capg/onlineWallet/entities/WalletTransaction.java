package com.capg.onlineWallet.entities;

import java.time.LocalDateTime;

public class WalletTransaction {

	
	int transactionId;
	String description;
	LocalDateTime dateOfTransaction;
	double amount;
	int receiverAccountId;
	int accountId;
	double accountBalance;
	

	public WalletTransaction(int transactionId, String description, LocalDateTime dateOfTransaction,
			 double amount, int receiverAccountId, int accountId, double accountBalance) {
		super();
		this.transactionId = transactionId;
		this.description = description;
		this.dateOfTransaction = dateOfTransaction;
		this.amount = amount;
		this.receiverAccountId = receiverAccountId;
		this.accountId = accountId;
		this.accountBalance = accountBalance;
	}
	
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public WalletTransaction() {
	}

	public int getReceiverAccountId() {
		return receiverAccountId;
	}

	public void setReceiverAccountId(int receiverAccountId) {
		this.receiverAccountId = receiverAccountId;
	}

    public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(LocalDateTime dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "WalletTransaction [transactionId=" + transactionId + ", description=" + description
				+ ", dateOfTransaction=" + dateOfTransaction + ", amount=" + amount + ", receiverAccountId="
				+ receiverAccountId + ", accountId=" + accountId + ", accountBalance=" + accountBalance + "]";
	}
	
	
}