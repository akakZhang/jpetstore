package myjpetstore.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import myjpetstore.domain.Account;;

public class AccountDAO {
	
	private static final String getAccountByUsernameSQL = "SELECT SIGNON.USERNAME,ACCOUNT.EMAIL,ACCOUNT.FIRSTNAME,ACCOUNT.LASTNAME,ACCOUNT.STATUS,ACCOUNT.ADDR1 AS address1,ACCOUNT.ADDR2 AS address2,ACCOUNT.CITY,ACCOUNT.STATE,ACCOUNT.ZIP,ACCOUNT.COUNTRY,ACCOUNT.PHONE,PROFILE.LANGPREF AS languagePreference,PROFILE.FAVCATEGORY AS favouriteCategoryId,PROFILE.MYLISTOPT AS listOption,PROFILE.BANNEROPT AS bannerOption,BANNERDATA.BANNERNAME FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA WHERE ACCOUNT.USERID = ? AND SIGNON.USERNAME = ACCOUNT.USERID AND PROFILE.USERID = ACCOUNT.USERID AND PROFILE.FAVCATEGORY = BANNERDATA.FAVCATEGORY";
	private static final String getAccountByUsernameAndPasswordSQL = "SELECT SIGNON.USERNAME, ACCOUNT.EMAIL, ACCOUNT.FIRSTNAME, ACCOUNT.LASTNAME, ACCOUNT.STATUS, ACCOUNT.ADDR1 AS address1, ACCOUNT.ADDR2 AS address2, ACCOUNT.CITY, ACCOUNT.STATE, ACCOUNT.ZIP, ACCOUNT.COUNTRY, ACCOUNT.PHONE, PROFILE.LANGPREF AS languagePreference, PROFILE.FAVCATEGORY AS favouriteCategoryId, PROFILE.MYLISTOPT AS listOption, PROFILE.BANNEROPT AS bannerOption, BANNERDATA.BANNERNAME FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA WHERE ACCOUNT.USERID = ? AND SIGNON.PASSWORD = ? AND SIGNON.USERNAME = ACCOUNT.USERID AND PROFILE.USERID = ACCOUNT.USERID AND PROFILE.FAVCATEGORY = BANNERDATA.FAVCATEGORY";
	private static final String updateAccountSQL = "UPDATE ACCOUNT SET EMAIL = ?, FIRSTNAME = ?, LASTNAME = ?, STATUS = ?, ADDR1 = ?, ADDR2 = ?, CITY = ?, STATE = ?, ZIP = ?, COUNTRY = ?, PHONE = ? WHERE USERID = ?";
	private static final String insertAccountSQL = "INSERT INTO ACCOUNT (EMAIL, FIRSTNAME, LASTNAME, STATUS, ADDR1, ADDR2, CITY, STATE, ZIP, COUNTRY, PHONE, USERID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
	private static final String updateProfileSQL = "UPDATE PROFILE SET LANGPREF = ?, FAVCATEGORY = ? WHERE USERID = ?";
	private static final String insertProfileSQL = "INSERT INTO PROFILE (LANGPREF, FAVCATEGORY, USERID) VALUES (?, ?, ?)";
	private static final String updateSignonSQL = "UPDATE SIGNON SET PASSWORD = ? WHERE USERNAME = ?";
	private static final String insertSignonSQL ="INSERT INTO SIGNON (PASSWORD,USERNAME) VALUES (?, ?)";
	
	public Account getAccountByUsername(String username){
		
		Connection connection = DBUtil.getConnection();
		Account result = new Account();
		
		try {
			PreparedStatement pStatement = connection.prepareStatement(getAccountByUsernameSQL);
			pStatement.setString(1, username);
			ResultSet resultSet = pStatement.executeQuery();
			if(resultSet.next()){
				result.setUsername(resultSet.getString("username"));
				result.setEmail(resultSet.getString("email"));
				result.setFirstName(resultSet.getString("firstname"));
				result.setLastName(resultSet.getString("lastname"));
				result.setAddress1(resultSet.getString(6));
				result.setAddress2(resultSet.getString(7));
				result.setBannerName(resultSet.getString("bannername"));
				result.setBannerOption(resultSet.getInt("bannerOption") == 1 ? true : false);
				result.setCity(resultSet.getString(8));
				result.setCountry(resultSet.getString(11));
				result.setFavouriteCategoryId(resultSet.getString("favouriteCategoryId"));
				result.setLanguagePreference(resultSet.getString("languagePreference"));
				result.setListOption(resultSet.getInt("listOption") == 1 ? true : false);
				result.setPhone(resultSet.getString(12));
				result.setState(resultSet.getString(9));
				result.setStatus(resultSet.getString(5));
				result.setZip(resultSet.getString(10));
			}
			DBUtil.closeResultSet(resultSet);
			DBUtil.closePreparedStatement(pStatement);
			DBUtil.closeConnection(connection);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

	 public Account getAccountByUsernameAndPassword(Account account){
		  
		  Connection connection = DBUtil.getConnection();
		  Account result = new Account();
		  try {
			PreparedStatement pStatement = connection.prepareStatement(getAccountByUsernameAndPasswordSQL);
			pStatement.setString(1, account.getUsername());
			pStatement.setString(2, account.getPassword());
			ResultSet resultSet = pStatement.executeQuery();
			if(resultSet.next()){
				result.setAddress1(resultSet.getString("address1"));
				result.setAddress2(resultSet.getString("address2"));
				result.setBannerName(resultSet.getString("bannername"));
				result.setBannerOption(resultSet.getInt("bannerOption") == 1 ? true : false);
				result.setCity(resultSet.getString("city"));
				result.setCountry(resultSet.getString("country"));
				result.setEmail(resultSet.getString("email"));
				result.setFavouriteCategoryId(resultSet.getString("favouriteCategoryId"));
				result.setFirstName(resultSet.getString("firstname"));
				result.setLanguagePreference(resultSet.getString("languagePreference"));
				result.setLastName(resultSet.getString("lastname"));
				result.setListOption(resultSet.getInt("listOption") == 1 ? true : false);
				result.setPassword(resultSet.getString("password"));
				result.setPhone(resultSet.getString("phone"));
				result.setState(resultSet.getString("state"));
				result.setStatus(resultSet.getString("status"));
				result.setUsername(resultSet.getString("username"));
				result.setZip(resultSet.getString("zip"));
				
			}
			DBUtil.closeResultSet(resultSet);
			DBUtil.closePreparedStatement(pStatement);
			DBUtil.closeConnection(connection);
		  
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return result;
		  
	  }

	 public void insertAccount(Account account){
		  
		  Account insert = null;
		  Connection connection = DBUtil.getConnection();
		  try {
			PreparedStatement pStatement = connection.prepareStatement(insertAccountSQL);
			pStatement.setString(1, account.getEmail());
			pStatement.setString(2, account.getFirstName());
			pStatement.setString(3, account.getLastName());
			pStatement.setString(4, account.getStatus());
			pStatement.setString(5, account.getAddress1());
			pStatement.setString(6, account.getAddress2());
			pStatement.setString(7, account.getCity());
			pStatement.setString(8, account.getState());
			pStatement.setString(9, account.getZip());
			pStatement.setString(10, account.getCountry());
			pStatement.setString(11, account.getPhone());
			pStatement.setString(12, account.getUsername());
			
			int result = pStatement.executeUpdate();
			if(result == 1){
				insert = account;
			}
			
			DBUtil.closePreparedStatement(pStatement);
			DBUtil.closeConnection(connection);
		  
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }
	  
	 public void insertProfile(Account account){
		  Connection connection = DBUtil.getConnection();
		  Account insert = null;
		  try {
			PreparedStatement pStatement = connection.prepareStatement(insertProfileSQL);
			pStatement.setString(1, account.getLanguagePreference());
			pStatement.setString(2, account.getFavouriteCategoryId());
			pStatement.setString(3, account.getUsername());
			
			int result = pStatement.executeUpdate();
			if(result == 1){
				insert = account;
			}
			
			DBUtil.closePreparedStatement(pStatement);
			DBUtil.closeConnection(connection);
			
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }
	  
	 public void insertSignon(Account account){
		  
		  Connection connection = DBUtil.getConnection();
		  Account insert = null;
		  try {
			PreparedStatement pStatement = connection.prepareStatement(insertSignonSQL);
			pStatement.setString(1, account.getPassword());
			pStatement.setString(2, account.getUsername());
			
			int result = pStatement.executeUpdate();
			if(result == 1){
				 insert = account;
			}
			
			DBUtil.closePreparedStatement(pStatement);
			DBUtil.closeConnection(connection);
		  
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }

	 public void updateAccount(Account account){
		  
		  Connection connection = DBUtil.getConnection();
		  try {
			PreparedStatement pStatement = connection.prepareStatement(updateAccountSQL);
			pStatement.setString(1, account.getEmail());
			pStatement.setString(2, account.getFirstName());
			pStatement.setString(3, account.getLastName());
			pStatement.setString(4, account.getStatus());
			pStatement.setString(5, account.getAddress1());
			pStatement.setString(6, account.getAddress2());
			pStatement.setString(7, account.getCity());
			pStatement.setString(8, account.getState());
			pStatement.setString(9, account.getZip());
			pStatement.setString(10, account.getCountry());
			pStatement.setString(11, account.getPhone());
			pStatement.setString(12, account.getUsername());
			
			pStatement.executeUpdate();
			
			DBUtil.closePreparedStatement(pStatement);
			DBUtil.closeConnection(connection);
		  
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }

	 public void updateProfile(Account account){
		  
		  Connection connection = DBUtil.getConnection();
		  try {
			PreparedStatement pStatement = connection.prepareStatement(updateProfileSQL);
			pStatement.setString(1, account.getLanguagePreference());
			pStatement.setString(2, account.getFavouriteCategoryId());
			pStatement.setString(3, account.getUsername());
			
			pStatement.executeUpdate();
			
			DBUtil.closePreparedStatement(pStatement);
			DBUtil.closeConnection(connection);
			
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
	  }

	 public void updateSignon(Account account){
		  
		  Connection connection = DBUtil.getConnection();
		  try {
			PreparedStatement pStatement = connection.prepareStatement(updateSignonSQL);
			pStatement.setString(1, account.getPassword());
			pStatement.setString(2, account.getUsername());
			
			pStatement.executeUpdate();
			
			DBUtil.closePreparedStatement(pStatement);
			DBUtil.closeConnection(connection);
		  
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }


}
