package myjpetstore.service;

import myjpetstore.domain.Account;
import myjpetstore.persistence.AccountDAO;

public class AccountService {
	
	AccountDAO accountDAO = new AccountDAO();
	
	 public Account getAccount(String username) {
		    return accountDAO.getAccountByUsername(username);
		  }

		  public Account getAccount(String username, String password) {
		    Account account = new Account();
		    account.setUsername(username);
		    account.setPassword(password);
		    return accountDAO.getAccountByUsernameAndPassword(account);
		  }

		  public void insertAccount(Account account) {
		    accountDAO.insertAccount(account);
		    accountDAO.insertProfile(account);
		    accountDAO.insertSignon(account);
		  }

		  public void updateAccount(Account account) {
		    accountDAO.updateAccount(account);
		    accountDAO.updateProfile(account);

		    if (account.getPassword() != null && account.getPassword().length() > 0) {
		      accountDAO.updateSignon(account);
		    }
		  }

}
