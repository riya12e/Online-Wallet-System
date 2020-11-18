package com.capg.ewallet.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_tbl")
public class WalletUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="UserId")
	private int userId;
	
	@Column(name="UserName")
	private String userName;
	
	@Column(name="UserPassword")
	private String password;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Aadhar")
	private long aadharNo;
	
	@Column(name="Contact")
	private long contact;
	
	@Column(name="DOB")
	private LocalDate dob;
	
	
	public WalletUser() {
		
	}
	
	public WalletUser(int userId, String userName, String password, String email, long aadharNo, long contact,
			LocalDate dob) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.aadharNo = aadharNo;
		this.contact = contact;
		this.dob = dob;
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		password = password;
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

/*@Override
	public String toString() {
		return "WalletUser [UserId=" + UserId + ", UserName=" + UserName + ", Password=" + Password + ", PhoneNumber="
				+ PhoneNumber +  ", walletAccount=" + walletAccount + "]";
	}*/
	
	
	

}
