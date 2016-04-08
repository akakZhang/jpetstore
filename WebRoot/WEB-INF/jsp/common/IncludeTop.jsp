<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="myjpetstore.domain.Account" %>
<%-- 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    
    
    <title>JPetStore Demo</title>
    
	<meta content="text/html; charset=windows-1252"
		http-equiv="Content-Type" />
	<meta http-equiv="Cache-Control" content="max-age=0" />
	<meta http-equiv="Cache-Control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
	<meta http-equiv="Pragma" content="no-cache" />
	<!-- 指定样式表-->
	<link rel="stylesheet" type="text/css" href="css/jpetstore.css">
	

  </head>
  
  <body>
  	<div id="Header">
  		<div id="Logo">
  			<div id="LogoContent">
  				<a href="mainView"><img src="images/logo-topbar.gif"/></a>
  			</div>  
  		</div> 
  		<div id="Menu">
  			<div id="MenuContent">
  				<a href="#"><img align="middle" name = "view cart" src="images/cart.gif"/></a>
  					<img align="middle" src="images/separator.gif"/>
  			<% if(session.getAttribute("account") == null){%>
  				<a href="SignServlet">Sign in</a>
  				<img align="middle" src="images/separator.gif"/>
  			<% }%>
  			<% Account account = (Account)session.getAttribute("account"); %>
  			
  			<% if((session.getAttribute("account") != null)){ %>
  					<a href="SignoutServlet">Sign out</a>
  						<img align="middle" src="images/separator.gif"/>
  					<a href="EditAccountJumpServlet">My Account</a>
  						<img align="middle" src="images/separator.gif"/>
  			<%} %>
  				<a href="#">?</a>
  
  			</div>
  		</div>
  		<div id="Search">
  			<div id="SearchContent">
  			<form action="SearchServlet"><input type="text" name="keyword" size="14" align="right"/>&nbsp;<input type="submit" align="right" name="searchProducts" value="Search"/></form>
  			</div>
  		
  		
  		</div>
 		<div id="QuickLinks">
 			<a href="catagoryView?catagoryId=FISH"> 
 				<img src="images/sm_fish.gif" />
 			</a><img src="images/separator.gif">
 			<a href="catagoryView?catagoryId=DOGS"> 
 				<img src="images/sm_dogs.gif" />
 			</a><img src="images/separator.gif">
 			<a href="catagoryView?catagoryId=REPTILES"> 
 				<img src="images/sm_reptiles.gif" />
 			</a><img src="images/separator.gif">
 			<a href="catagoryView?catagoryId=CATS"> 
 				<img src="images/sm_cats.gif" />
 			</a><img src="images/separator.gif">
 			<a href="catagoryView?catagoryId=BIRDS"> 
 				<img src="images/sm_birds.gif" />
 			</a>	
 		</div>
  
 	 </div>  
  <div id="Content">

