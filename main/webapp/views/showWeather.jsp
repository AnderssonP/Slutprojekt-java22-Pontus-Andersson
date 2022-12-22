<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.weatherBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="style.css">
<body>
<jsp:include page="../index.jsp"/>
<div class ="container">
      <div class="input">
<%
	weatherBean wBean = (weatherBean) request.getSession().getAttribute("wBean");
	out.print("The weather in " + wBean.getCityStr() + " is now a " + wBean.getCloudsStr()+".");%>
	<br>
	<% 
	out.print("The tempeture is " + wBean.getTempStr()+" celsius.");
	%>
	</div>
	<div class="input">
	 <h2>Your recent search</h2> <br>
	 <% if(wBean.getCookieK() != null)
	 for(int i = 0; i<=wBean.getCookieK().length-1; i++){
		 out.print("<p>"+wBean.getCookieK()[i] +"</p>");
	}%>
    </div>
 </div>
 <div class="date">
 <% 
	out.print("The date is " + wBean.getDateStr());
	%>
	</div>
</body>
</html>