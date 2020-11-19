package com.capg.ewallet.service;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ewallet.entities.WalletUser;
import com.capg.ewallet.exception.WalletUserException;
import com.capg.ewallet.repository.IUserRepository;

@Transactional
@Service
public class UserServiceImpl implements IUserService {

	
        @Autowired
	    private IUserRepository walletUser;
		
		@Override
		public WalletUser addUser(WalletUser user) throws WalletUserException{
			// TODO Auto-generated method stub
			walletUser.addUser(user);
			return user;
		}

		@Override
		public WalletUser showUserById(int userId) throws WalletUserException {
			// TODO Auto-generated method stub
			WalletUser user = walletUser.showUserById(userId);
			if(user==null)
			{
				throw new WalletUserException(userId+" Id not found");
			}
			return user;
		}

		@Override
		public WalletUser loginUser(String userName, String password) throws WalletUserException{
			WalletUser user = walletUser.logInUser(userName, password);
			if(user==null)
			{
				throw new WalletUserException(user.getUserId()+" Id not found");
			}
			return user;
		}

		@Override
		public WalletUser updatePassword(int userId, String password) throws WalletUserException {
			// TODO Auto-generated method stub
			WalletUser user = walletUser.updatePassword(userId, password);
			if(user==null)
			{
				throw new WalletUserException(user.getUserId()+" Id not found");
			}
			return user;
		}

		@Override
		public String logoutUser(String userName, String password) throws WalletUserException {
			// TODO Auto-generated method stub
			return null;
		}
}
