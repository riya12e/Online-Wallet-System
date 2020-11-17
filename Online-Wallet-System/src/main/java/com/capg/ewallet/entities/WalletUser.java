package com.capg.ewallet.entities;

public class WalletUser {
	
	
	private int userId;
	private String userName;
	private String password;
	private String email;
	private long aadharNo;
	private long contact;
	private String dob;
	private WalletAccount walletAccount;
	
	public WalletUser() {
		
	}
	
	public WalletUser(int userId, String userName, String password, String email, long aadharNo, long contact,
			String dob, WalletAccount walletAccount) {
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public WalletAccount getWalletAccount() {
		return walletAccount;
	}

	public void setWalletAccount(WalletAccount walletAccount) {
		this.walletAccount = walletAccount;
	}

	
    
	
	
	/*@Override
	public String toString() {
		return "WalletUser [UserId=" + UserId + ", UserName=" + UserName + ", Password=" + Password + ", PhoneNumber="
				+ PhoneNumber +  ", walletAccount=" + walletAccount + "]";
	}*/
	
	
	

}
