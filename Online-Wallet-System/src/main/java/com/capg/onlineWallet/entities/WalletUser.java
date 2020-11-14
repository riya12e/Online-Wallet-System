package com.capg.onlineWallet.entities;

public class WalletUser {
	
	
	private int UserId;
	private String UserName;
	private String Password;
	private long PhoneNumber;
	private WalletAccount walletAccount;

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public long getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	
	/*@Override
	public String toString() {
		return "WalletUser [UserId=" + UserId + ", UserName=" + UserName + ", Password=" + Password + ", PhoneNumber="
				+ PhoneNumber +  ", walletAccount=" + walletAccount + "]";
	}*/
	
	
	

}
