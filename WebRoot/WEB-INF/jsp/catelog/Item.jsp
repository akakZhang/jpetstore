<%@ include file="../common/IncludeTop.jsp"%>
<%@ page import="myjpetstore.domain.Product,myjpetstore.domain.Item" %>
<div id="BackLink">
<% Product product = (Product)session.getAttribute("product");
   Item item1 = (Item)request.getSession().getAttribute("ITEM");
   String itemId = (String)session.getAttribute("itemid");
 %><!-- 有问题 -->
<a href="ProsuctViewServlet?productId=<%=product.getProductId() %>">
	Return to <%=product.getProductId() %>
</a>
</div>

<div id="Catalog">
<table>
	<tr>
		<td><%=product.getDescription()%></td>
	</tr>
	<tr>
		<td><b> <%=itemId %> </b></td>
	</tr>
	<tr>
		<td><b><font size="4"> <%=item1.getAttribute1() %>
		<%=item1.getAttribute2() %> <%=item1.getAttribute3() %>
		<%=item1.getAttribute4() %> <%=item1.getAttribute5() %>
		<%=product.getName() %> </font></b></td>
	</tr>
	<tr>
		<td><%=product.getName() %> </td>
	</tr>
	<tr>
		<td><% if(item1.getQuantity() <= 0){ %>
        Back ordered.
        <% } %>
       <% if(item1.getQuantity() > 0) {%>
      	<%=item1.getQuantity() %>in stock.
	  <% } %>
	  </td>
	</tr>
	<tr>
		<td><%=item1.getListPrice() %>
		</td>
	</tr>

	<tr>
		<td><a href="#?itemId=<%=item1.getItemId()%>">
       	Add to Cart
       </a></td>
	</tr>
</table>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>



