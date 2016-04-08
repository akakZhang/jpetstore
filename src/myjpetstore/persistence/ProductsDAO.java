package myjpetstore.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myjpetstore.domain.Product;

public class ProductsDAO {
	private final String getProductListByCategorySQL = "SELECT PRODUCTID,NAME,DESCN as description,CATEGORY as categoryId FROM PRODUCT WHERE CATEGORY = ?";
	private final String getProductSQL = "SELECT PRODUCTID,NAME,DESCN as description,CATEGORY as categoryId FROM PRODUCT WHERE PRODUCTID = ?";
	private final String searchProductListSQL = "select PRODUCTID,NAME,DESCN as description,CATEGORY as categoryId from PRODUCT WHERE lower(name) like ?";
	
	public List<Product> getProductListByCategory(String categoryId){
	  List<Product> result = new ArrayList<Product>();
	  Connection connection = DBUtil.getConnection();
	  try {
		
		  PreparedStatement pStatement= connection.prepareStatement(getProductListByCategorySQL);
		  pStatement.setString(1, categoryId);
		  ResultSet resultSet = pStatement.executeQuery();
		  while(resultSet.next()){
			  Product product = new Product();
			  product.setCategoryId(resultSet.getString("categoryId"));
			  product.setDescription(resultSet.getString("description"));
			  product.setName(resultSet.getString("name"));
			  product.setProductId(resultSet.getString("productid"));
			  result.add(product);
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

	public Product getProduct(String productId){
	  Product result = new Product();
	  Connection connection = DBUtil.getConnection();
	  try {
		PreparedStatement pStatement = connection.prepareStatement(getProductSQL);
		pStatement.setString(1, productId);
		ResultSet resultSet = pStatement.executeQuery();
		if(resultSet.next()){
			result.setCategoryId(resultSet.getString("categoryId"));
			result.setDescription(resultSet.getString("description"));
			result.setName(resultSet.getString("name"));
			result.setProductId(resultSet.getString("productid"));
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

	public List<Product> searchProductList(String keywords){
	  List<Product> result = new ArrayList<Product>();
	  Connection connection = DBUtil.getConnection();
	  try {
		PreparedStatement pStatement = connection.prepareStatement(searchProductListSQL);
		pStatement.setString(1, keywords);
		ResultSet resultSet = pStatement.executeQuery();
		while(resultSet.next()){
			 while(resultSet.next()){
				  Product product = new Product();
				  product.setCategoryId(resultSet.getString("categoryId"));
				  product.setDescription(resultSet.getString("description"));
				  product.setName(resultSet.getString("name"));
				  product.setProductId(resultSet.getString("productid"));
				  result.add(product);
			  }
			 DBUtil.closeResultSet(resultSet);
			  DBUtil.closePreparedStatement(pStatement);
			  DBUtil.closeConnection(connection);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return result;
	  
  }

}
