<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog"><form action="EditAccountServlet" method="post">

	<h3>User Information</h3>

	<table>
		<tr>
			<td>User ID:</td>
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<td>New password:</td>
			<td><input type="password" name="newPassword" ></td>
		</tr>
		<tr>
			<td>Repeat password:</td>
			<td><input type="password" name="repeatedPassword"></td>
		</tr>
	</table>
	<jsp:include page="IncludeAccountFields.jsp"></jsp:include>

	<input type="submit" name="editAccount" value="Save Account Information" >

</form> <a href="#">My Orders</a></div>

<%@ include file="../common/IncludeBottom.jsp"%>

