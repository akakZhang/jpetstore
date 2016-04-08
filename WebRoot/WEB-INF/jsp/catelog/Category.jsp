<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>
<%@ page import="myjpetstore.web.CatagoryViewServlet,myjpetstore.domain.Product,myjpetstore.domain.Category" %>
<div id="BackLink">
	<a href="mainView">Return to Main Menu</a>
</div>
<div id="Catalog">
	<!-- 显示大类的名称 -->
	<h2>
	 <%=request.getParameter("catagoryId") %>
	</h2>
	
	<table>
		<tr>
			<th>Product ID</th>
			<th>Name</th>
		</tr>
			<% 
			Category catagory = new Category();
			catagory.setCategoryId(request.getParameter("catagoryId"));
			List<Product> productList = (List<Product>)session.getAttribute("productList");
			Product product = null;
			session.setAttribute("catagory", catagory);
			for(int i=0;i<productList.size();i++){

			 %>
			<tr>
				<td>
					<% product = (Product)productList.get(i);
						String productid = product.getProductId();
					%>
					<a href="ProsuctViewServlet?productId=<%=productid%>">
						
						<%= product.getProductId()
						%>
					</a>
				</td>
				<td>
					<%=product.getName() %>
				</td>
			</tr>
		<%} %>
	</table>
</div>
<jsp:include page="../common/IncludeBottom.jsp"></jsp:include>

