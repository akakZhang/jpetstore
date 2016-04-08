<%@ include file="../common/IncludeTop.jsp"%>
<%@ page import="myjpetstore.domain.Product" %>
<div id="BackLink"><a href="mainView">
	Return to Main Menu
</a></div>

<div id="Catalog">

<table>
	<tr>
		<th>&nbsp;</th>
		<th>Product ID</th>
		<th>Name</th>
	</tr>
	<% List<Product> productList = (List<Product>)session.getAttribute("productList"); 
		
		Product product = null;	
	%>
	<% for(int i = 0;i < productList.size();i++){
		product = (Product)productList.get(i);	
	 %>
		<tr>
			<td><a href="ProsuctViewServlet?productId=<%=product.getProductId() %>">
				<%=product.getDescription() %>
			</a></td>
			<td><b> <a href="ProsuctViewServlet?productId=<%=product.getProductId() %>">
				<font color="BLACK"> <%=product.getProductId() %> </font>
			</a> </b></td>
			<td><%=product.getName() %></td>
		</tr>
	<% } %>
	<tr>
		<td></td>
	</tr>

</table>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>




