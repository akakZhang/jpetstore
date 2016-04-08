<%@ include file="../common/IncludeTop.jsp"%>

<%@ page import="myjpetstore.web.ProsuctViewServlet,myjpetstore.domain.Item,myjpetstore.domain.Product,myjpetstore.domain.Category" %>

<% List<Item> itemList = (List<Item>)session.getAttribute("itemList");
	Category catagory = (Category)session.getAttribute("catagory");
	Product product = (Product)session.getAttribute("product");
	session.setAttribute("product", product);
 %>

<div id="BackLink"><a href="catagoryView?catagoryId=<%=catagory.getCategoryId() %>">
	Return to <%=catagory.getCategoryId() %>
</a></div>
<div id="Catalog">

<h2><%=product.getName()%></h2>

<table>
	<tr>
		<th>Item ID</th>
		<th>Product ID</th>
		<th>Description</th>
		<th>List Price</th>
		<th>&nbsp;</th>
	</tr>
	<% 
		Item item = null;											
	
	for(int i = 0;i<itemList.size();i++){ 
		item = (Item)itemList.get(i);
		session.setAttribute("ITEM", item);
		String itemid = item.getItemId();
	%>
		<tr>
			<td><a href="ItemViewServlet?itemId=<%=itemid%> ">
				
				<%= item.getItemId()%>
			</a></td>
			<td><%=product.getProductId() %></td>
			<td><%= item.getAttribute1() %> <%= item.getAttribute2() %> <%= item.getAttribute3() %>
			<%= item.getAttribute4() %> <%= item.getAttribute5() %> <%= product.getName() %></td>
			<td><%= item.getListPrice() %></td>
			<% item = null; %>
			<td><a href="#">
        	Add to Cart
        	</a></td>
		</tr>
	<% }%>
	<tr>
		<td>
		</td>
	</tr>
</table>

</div>

  
  
 <jsp:include page="../common/IncludeBottom.jsp"></jsp:include>
