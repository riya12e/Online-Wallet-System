package com.capg.ewallet.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import javax.persistence.Entity;

@Entity
@Table(name = "account_tbl")
public class BankAccount {
@Id
@Column(name="account_id")
@GeneratedValue(generator = "account_seq",strategy = GenerationType.SEQUENCE)
@SequenceGenerator(name = "account_seq",sequenceName = "account_seq",allocationSize = 1)
private long accountId;

@Column(name = "holder_name",length = 30)
private String holderName;
@Column(name = "bank_name",length = 30)
private String bankName;
@Column(name = "branch_ifsc",length = 10)
private String branchIfsc;
@Column(name = "account_type",length = 10)
private String accountType;
@Column(name = "account_status",length = 10)
private String accountStatus;
@Column(name = "account_balance")
private double accountBalance;

@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinColumn(name = "WalletId")
private WalletAccount walletAccount;

public BankAccount() {
super();
}

public BankAccount(long accountId, String holderName, String bankName, String branchIfsc, String accountType,
String accountStatus, double accountBalance, WalletAccount walletAccount) {
super();
this.accountId = accountId;
this.holderName = holderName;
this.bankName = bankName;
this.branchIfsc = branchIfsc;
this.accountType = accountType;
this.accountStatus = accountStatus;
this.accountBalance = accountBalance;
this.walletAccount = walletAccount;
}

public long getAccountId() {
return accountId;
}

public void setAccountId(long accountId) {
this.accountId = accountId;
}

public String getHolderName() {
return holderName;
}

public void setHolderName(String holderName) {
this.holderName = holderName;
}

public String getBankName() {
return bankName;
}

public void setBankName(String bankName) {
this.bankName = bankName;
}

public String getBranchIfsc() {
return branchIfsc;
}

public void setBranchIfsc(String branchIfsc) {
this.branchIfsc = branchIfsc;
}

public String getAccountType() {
return accountType;
}

public void setAccountType(String accountType) {
this.accountType = accountType;
}

public String getAccountStatus() {
return accountStatus;
}

public void setAccountStatus(String accountStatus) {
this.accountStatus = accountStatus;
}

public double getAccountBalance() {
return accountBalance;
}

public void setAccountBalance(double accountBalance) {
this.accountBalance = accountBalance;
}

public WalletAccount getWalletAccount() {
return walletAccount;
}

public void setWalletAccount(WalletAccount walletAccount) {
this.walletAccount = walletAccount;
}




}



