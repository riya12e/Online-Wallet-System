package com.capg.ewallet.service;

import org.springframework.stereotype.Service;

import com.capg.ewallet.entities.WalletUser;

@Service
public interface UserService {

	public WalletUser addUser(WalletUser user);
	
	public WalletUser showUserById(int userId);

	public WalletUser loginUser(String userName, String password);
	
	public Boolean updatePassword(int userId,String password);
	
	public String logoutUser(String userName, String password);
	
	
}
