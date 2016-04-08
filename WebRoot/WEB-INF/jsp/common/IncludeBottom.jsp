<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="myjpetstore.domain.Account" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
</div>

<div id="Footer">

<div id="PoweredBy"><a href="http://www.csu.edu.cn">Central South University</a>
</div>

<div id="Banner">
<% Account account1 = (Account)session.getAttribute("account"); %>
<!-- 显示account的bannerName -->
<% if(account1 != null && account1.isBannerOption() == true){ %>
<%=account1.getBannerName() %>
<% } %>

</div>

</div>

</body>
</html>

