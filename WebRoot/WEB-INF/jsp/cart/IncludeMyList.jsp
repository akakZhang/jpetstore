<%if () { %>
	<p>Pet Favorites <br />
	Shop for more of your favorite pets here.</p>
	<ul>
		<%for()"{%>
			<li><a href="#">
			<%=product.name %>
		</a> <%=product.productId%></li>
		<%} %>
	</ul>

<% }%>
