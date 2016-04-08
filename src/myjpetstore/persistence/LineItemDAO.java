package myjpetstore.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myjpetstore.domain.LineItem;

public class LineItemDAO {
	
	private static final String insertLineItemSQL = "INSERT INTO LINEITEM (ORDERID, LINENUM, ITEMID, QUANTITY, UNITPRICE) VALUES (?, ?, ?, ?, ?)";
	private static final String getLineItemsByOrderIdSQL = "SELECT ORDERID, LINENUM AS lineNumber, ITEMID, QUANTITY, UNITPRICE FROM LINEITEM WHERE ORDERID = ?";
	
	public List<LineItem> getLineItemsByOrderId(int orderId){
		Connection connection = DBUtil.getConnection();
		List<LineItem> result = new ArrayList<LineItem>();
		try {
			PreparedStatement pStatement = connection.prepareStatement(getLineItemsByOrderIdSQL);
			pStatement.setInt(1, orderId);
			LineItem lineItem = new LineItem();
			ResultSet resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				lineItem.setItemId(resultSet.getString("itemid"));
				lineItem.setLineNumber(resultSet.getInt("lineNumber"));
				lineItem.setOrderId(resultSet.getInt("orderid"));
				lineItem.setQuantity(resultSet.getInt("quantity"));
				lineItem.setUnitPrice(resultSet.getBigDecimal("unitprice"));
				
				result.add(lineItem);
				
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public void insertLineItem(LineItem lineItem){
		
	}
	
}
