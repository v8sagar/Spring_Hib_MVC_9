<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${requestScope.mesg}</h3>
	<h3>${sessionScope.cust_dtls}</h3>
	<a href="<spring:url value='/cust/update'/>">Update Details</a>
	<a href="<spring:url value='/cust/logout'/>">Log Out</a>
</body>
</html>