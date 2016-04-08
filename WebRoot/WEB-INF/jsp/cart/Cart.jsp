<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink"><a href="#">
	Return to Main Menu</a></div>

<div id="Catalog">

<div id="Cart">

<h2>Shopping Cart</h2>
<form action="#" method="post">
	<table>
		<tr>
			<th><b>Item ID</b></th>
			<th><b>Product ID</b></th>
			<th><b>Description</b></th>
			<th><b>In Stock?</b></th>
			<th><b>Quantity</b></th>
			<th><b>List Price</b></th>
			<th><b>Total Cost</b></th>
			<th>&nbsp;</th>
		</tr>

		<%if(#){ %>
			<tr>
				<td colspan="8"><b>Your cart is empty.</b></td>
			</tr>
		<% }%>

		<%for(){%>
			<tr>
				<td><a href="#">
				<%=${cartItem.item.itemId} %>
			  </a></td>
				<td>${cartItem.item.product.productId}</td>
				<td>${cartItem.item.attribute1} ${cartItem.item.attribute2}
				${cartItem.item.attribute3} ${cartItem.item.attribute4}
				${cartItem.item.attribute5} ${cartItem.item.product.name}</td>
				<td>${cartItem.inStock}</td>
				<td><input type="text" size="3" name="<%=item.getName()%>"
					value="<%=item.getQuantity()%>" /></td>
				<td>
					${cartItem.item.listPrice}
				</td>
				<td>
					${cartItem.total}
				</td>
				<td><a href="#" class="Button">
					Remove
            		</a>
            	</td>
			</tr>
		<% }%>
		<tr>
			<td colspan="7">Sub Total: ${actionBean.cart.subTotal}
				<input type="submit" name="updateCartQuantities" value="Update Cart" >
			</td>
			<td>&nbsp;</td>
		</tr>
	</table>

</form>
<%if (actionBean.cart.numberOfItems > 0){%>
	<a href="org.mybatis.jpetstore.web.actions.OrderActionBean" class="Button">
      	Proceed to Checkout
      </a>
<%}%>
</div>

<div id="MyList">
  <%if (sessionScope.accountBean != null && !sessionScope.accountBean.authenticated && !empty sessionScope.accountBean.account.listOption){%>
  <jsp:include page="IncludeMyList.jsp">
  <%}%>
</div>

<div id="Separator">&nbsp;</div>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>