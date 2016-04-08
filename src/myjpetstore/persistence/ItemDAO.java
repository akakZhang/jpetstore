package myjpetstore.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import myjpetstore.domain.Item;
import myjpetstore.domain.Product;

public class ItemDAO {
	
	private static final String getInventoryQuantitySQL = "SELECT QTY AS value FROM INVENTORY WHERE ITEMID = ?";
	private static final String getItemSQL = "SELECT I.ITEMID,LISTPRICE,UNITCOST,SUPPLIER AS supplierId,I.PRODUCTID AS productId,NAME AS productName,DESCN AS productDescription,CATEGORY AS categoryId,STATUS,ATTR1 AS attribute1,ATTR2 AS attribute2,ATTR3 AS attribute3,ATTR4 AS attribute4,ATTR5 AS attribute5 FROM ITEM I, PRODUCT P WHERE P.PRODUCTID = I.PRODUCTID AND I.PRODUCTID = ?";
	private static final String getItemListByProductSQL = "SELECT I.ITEMID,LISTPRICE,UNITCOST,SUPPLIER AS supplierId,I.PRODUCTID AS productId,NAME AS productName,DESCN AS productDescription,CATEGORY AS categoryId,STATUS,ATTR1 AS attribute1,ATTR2 AS attribute2,ATTR3 AS attribute3,ATTR4 AS attribute4,ATTR5 AS attribute5 FROM ITEM I, PRODUCT P WHERE P.PRODUCTID = I.PRODUCTID AND I.PRODUCTID = ?";
	private static final String updateInventoryQuantitySQL = "UPDATE INVENTORY SET QTY = QTY - ? WHERE ITEMID = ?";
	
	
	public void updateInventoryQuantity(Map<String, Object> param){
		Connection connection = DBUtil.getConnection();
		try {
			PreparedStatement pStatement = connection.prepareStatement(updateInventoryQuantitySQL);
			String itemId = param.keySet().iterator().next();
			pStatement.setString(2, itemId);
			Integer increment = (Integer)param.get(itemId);
			pStatement.setInt(1,increment );
			pStatement.executeUpdate();
			DBUtil.closePreparedStatement(pStatement);
			DBUtil.closeConnection(connection);
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	  public int getInventoryQuantity(String itemId){
		  Connection connection = DBUtil.getConnection();
		  Item item = null;
		  try {
			  
			  PreparedStatement pStatement = connection.prepareStatement(getInventoryQuantitySQL);
			  pStatement.setString(1, itemId);
			  ResultSet resultSet = pStatement.executeQuery();
			  if(resultSet.next()){
				  item.setQuantity(resultSet.getInt(1));
			  }
			DBUtil.closeResultSet(resultSet);
			DBUtil.closePreparedStatement(pStatement);
			DBUtil.closeConnection(connection);
			  
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return item.getQuantity();
	  }

	 public List<Item> getItemListByProduct(String productId){
		 List<Item> result = new ArrayList<Item>();
		 Connection connection = DBUtil.getConnection();
		 try {
			 Item it = new Item();
			PreparedStatement pStatement = connection.prepareStatement(getItemListByProductSQL);
			pStatement.setString(1, productId);
			ResultSet resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				it.setItemId(resultSet.getString(1));
				it.setListPrice(resultSet.getBigDecimal(2));
				it.setUnitCost(resultSet.getBigDecimal(3));
				it.setSupplierId(resultSet.getInt(4));
				Product product = new Product();
				product.setProductId(resultSet.getString(5));
				product.setName(resultSet.getString(6));
				product.setDescription(resultSet.getString(7));
				product.setCategoryId(resultSet.getString(8));
				it.setProduct(product);
				it.setStatus(resultSet.getString(9));
				it.setAttribute1(resultSet.getString(10));
				it.setAttribute2(resultSet.getString(11));
				it.setAttribute3(resultSet.getString(12));
				it.setAttribute4(resultSet.getString(13));
				it.setAttribute5(resultSet.getString(14));
				result.add(it);
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

	 public Item getItem(String itemId){
		 Item it = new Item();
		 Connection connection = DBUtil.getConnection();
		 try {
			PreparedStatement pStatement = connection.prepareStatement(getItemSQL);
			pStatement.setString(1, itemId);
			ResultSet resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				it.setItemId(resultSet.getString(1));
				it.setListPrice(resultSet.getBigDecimal(2));
				it.setUnitCost(resultSet.getBigDecimal(3));
				it.setSupplierId(resultSet.getInt(4));
				Product product = new Product();
				product.setProductId(resultSet.getString(5));
				product.setName(resultSet.getString(6));
				product.setDescription(resultSet.getString(7));
				product.setCategoryId(resultSet.getString(8));
				it.setStatus(resultSet.getString(9));
				it.setAttribute1(resultSet.getString(10));
				it.setAttribute2(resultSet.getString(11));
				it.setAttribute3(resultSet.getString(12));
				it.setAttribute4(resultSet.getString(13));
				it.setAttribute5(resultSet.getString(14));
				it.setQuantity(resultSet.getInt(15));
			}
			DBUtil.closeResultSet(resultSet);
			DBUtil.closePreparedStatement(pStatement);
			DBUtil.closeConnection(connection);
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return it;
	 }
}
