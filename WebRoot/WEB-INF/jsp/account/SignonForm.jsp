<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog"><form action="CheckIsExistServlet" method="post" focus="">

	<p>Please enter your username and password.</p>
	<p>Username:<input type="text" name="username" value="j2ee" > <br >
	Password:<input type="password" name="password" value="j2ee" ></p>
	<input type="submit" name="signon" value="Login" >

</form> Need a user name and password? <a href="RegisterJumpServlet" >Register Now!</a>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>
