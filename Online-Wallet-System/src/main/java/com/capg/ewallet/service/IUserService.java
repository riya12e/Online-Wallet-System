package com.capg.ewallet.service;

import org.springframework.stereotype.Service;

import com.capg.ewallet.entities.WalletUser;
import com.capg.ewallet.exception.WalletUserException;

public interface IUserService {

	public WalletUser addUser(WalletUser user) throws WalletUserException;
	
	public WalletUser showUserById(int userId) throws WalletUserException;

	public WalletUser loginUser(String userName, String password) throws WalletUserException;
	
	public WalletUser updatePassword(int userId,String password) throws WalletUserException;
	
	public String logoutUser(String userName, String password) throws WalletUserException;
	
	
}
