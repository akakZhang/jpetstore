package myjpetstore.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import myjpetstore.domain.Category;

public class CategoryDAO {
	
	private final String getCategoryListSQL = "SELECT CATID AS categoryId,NAME,DESCN AS description FROM CATEGORY";
	private final String getCategorySQL="SELECT CATID AS categoryId,NAME,DESCN AS description FROM CATEGORY WHERE CATID = ?";
	
	public List<Category> getCategoryList(){
		List<Category> result = new ArrayList<Category>();
		Connection connection = DBUtil.getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(getCategoryListSQL);
			while(resultSet.next()){
				Category cate = new Category();
				cate.setCategoryId(resultSet.getString("categoryId"));
				cate.setName(resultSet.getString("name"));
				cate.setDescription(resultSet.getString("description"));
				result.add(cate);
			}
			
			DBUtil.closeResultSet(resultSet);
			DBUtil.closeStatement(statement);
			DBUtil.closeConnection(connection);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public Category getCategory(String categoryId){
		Connection connection = DBUtil.getConnection();
		Category cate = new Category();
		try {
			PreparedStatement pStatement = connection.prepareStatement(getCategorySQL);
			pStatement.setString(1, categoryId);
			ResultSet resultSet = pStatement.executeQuery(getCategorySQL);
			if(resultSet.next()){
				cate.setCategoryId(resultSet.getString("categoryId"));
				cate.setName(resultSet.getString("name"));
				cate.setDescription(resultSet.getString("description"));
			}
			DBUtil.closeResultSet(resultSet);
			  DBUtil.closePreparedStatement(pStatement);
			  DBUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cate;
	}

}
