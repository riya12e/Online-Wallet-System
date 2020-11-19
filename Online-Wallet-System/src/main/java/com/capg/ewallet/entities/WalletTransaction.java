package com.capg.ewallet.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name="WalletTransaction")
@Table
public class WalletTransaction {

	@Id
	@GeneratedValue(generator = "transaction_seq",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "transaction_seq",sequenceName = "transaction_seq",allocationSize = 1)
	@Column(length=5, name="transactionId")
	private int transactionId;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "dateOfTransaction")
	private LocalDateTime dateOfTransaction;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "receiverAccountId")
	private int receiverAccountId;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "WalletId")
	private WalletAccount senderAccountId;

	@Column(name = "accountBalance")
	private double accountBalance;
	
	

	public WalletTransaction(int transactionId, String description, LocalDateTime dateOfTransaction,
			 double amount, int receiverAccountId, WalletAccount senderAccountId, double accountBalance ) {
		super();
		this.transactionId = transactionId;
		this.description = description;
		this.dateOfTransaction = dateOfTransaction;
		this.amount = amount;
		this.receiverAccountId = receiverAccountId;
		this.senderAccountId = senderAccountId;
		this.accountBalance = accountBalance;
		
	}
	
	public WalletAccount getAccountId() {
		return senderAccountId;
	}

	public void setAccountId(WalletAccount accountId) {
		this.senderAccountId = accountId;
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
				+ receiverAccountId + ", accountId="
				+ ", accountBalance=" + accountBalance + "]";
	}
	
	
}