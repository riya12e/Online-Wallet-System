package com.capg.ewallet.repository;

import com.capg.ewallet.entities.WalletUser;

public interface IUserRepository {

	public WalletUser addUser(WalletUser user);
	
	public WalletUser showUserById(int userId);
	
	public WalletUser logInUser(String userName, String password);
	
	public WalletUser updatePassword(int userId, String password);
	
	public String logOutUser(String userName, String password);
	
	
}