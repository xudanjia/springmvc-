<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<td>Tid</td>
		<td>departure_add</td>
		<td>destination_add</td>
		<td>departure_time</td>
		<td>arrival_time</td>
		<td>price</td>
		<td>uname_code</td>
	</tr>
	<c:forEach items="${tickets}" var="ticket">
		<tr>
			<td>${ticket.tid }</td>
			<td>${ticket.departure_add }</td>
			<td>${ticket.destination_add }</td>
			<td>${ticket.departure_time }</td>
			<td>${ticket.arrival_time }</td>
			<td>${ticket.price }</td>
			<td>${ticket.uname_code }</td>
		</tr>
	</c:forEach>
</table>
<br><hr><br>
<h1>模糊查询</h1>
<form action="findTicketByUnameCode">
	uname_code：<input type="text" name="uname_code"><input type="submit" value="查询">
</form>
<table border="1">
	<tr>
		<td>Tid</td>
		<td>departure_add</td>
		<td>destination_add</td>
		<td>departure_time</td>
		<td>arrival_time</td>
		<td>price</td>
		<td>uname_code</td>
	</tr>
	<c:forEach items="${ticketCondition}" var="ticket">
		<tr>
			<td>${ticket.tid }</td>
			<td>${ticket.departure_add }</td>
			<td>${ticket.destination_add }</td>
			<td>${ticket.departure_time }</td>
			<td>${ticket.arrival_time }</td>
			<td>${ticket.price }</td>
			<td>${ticket.uname_code }</td>
		</tr>
	</c:forEach>
</table>
<br><hr><br>
<h1>插入操作--------${msg}</h1>
<form action="insert" method="post">
	tid：<input type="text" name="tid"><br>
	departure_add：<input type="text" name="departure_add"><br>
	destination_add：<input type="text" name="destination_add"><br>
	departure_time：<input type="text" name="departure_time"><br>
	arrival_time：<input type="text" name="arrival_time"><br>
	price：<input type="text" name="price"><br>
	uname_code：<input type="text" name="uname_code"><br>
	<input type="submit" value="添加">
</form>
</body>
</html>