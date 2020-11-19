package com.capg.ewallet.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_tbl")
public class WalletUser {
	
	@Id
	@GeneratedValue(generator = "user_seq",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "user_seq",sequenceName = "user_seq",allocationSize = 1)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_password")
	private String password;
	
	@Column(name="user_email")
	private String email;
	
	@Column(name="user_aadhar")
	private long aadharNo;
	
	@Column(name="user_contact")
	private long contact;
	
	@Column(name="user_dob")
	private LocalDate dob;
	
	@JsonIgnore
	@OneToOne(mappedBy = "walletUser",cascade = CascadeType.REMOVE)
	private WalletAccount walletAccount;

	public WalletUser() {
		super();
	}

	public WalletUser(int userId, String userName, String password, String email, long aadharNo, long contact,
			LocalDate dob, WalletAccount walletAccount) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.aadharNo = aadharNo;
		this.contact = contact;
		this.dob = dob;
		this.walletAccount = walletAccount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public WalletAccount getWalletAccount() {
		return walletAccount;
	}

	public void setWalletAccount(WalletAccount walletAccount) {
		this.walletAccount = walletAccount;
	}
	
	
}