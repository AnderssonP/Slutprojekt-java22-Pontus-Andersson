<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.weatherBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Weather</title>
<link rel="stylesheet" href="style.css">
<script type="text/javascript" src="PopUp.js"></script>
</head>
<body>
	<h1>Check the weather</h1>
	<form action="OWservlet" method="get" class="flex-container">
		Country:<input type="text" name="country" size="30" /><br /> City:<input
			type="text" name="city" /><br /> <input type="submit" value="go"
			name="submit" />
	</form>
	<%weatherBean wBean = (weatherBean) request.getSession().getAttribute("wBeanTwo");
	if (wBean != null) {
		if(request.getCookies().length < 2){ %>
	<jsp:include page="views/allowCookies.jsp" />
	<% }
	} else {
	
		if(request.getCookies().equals("wBeanTwo")) %>
	<%-- Check if allow or deny exists in cookies. Include if doesnt --%>
	<jsp:include page="views/allowCookies.jsp" />
	<%
	}
	%>
</body>
</html>