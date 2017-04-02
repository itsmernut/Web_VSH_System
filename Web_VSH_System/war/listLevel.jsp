<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Level_Information</title>
</head>
<body>
	<table border="1">
		<c:forEach items="${levelList}" var="level">
			<tr>
				
				<td>${level.level}</td>
				<td><a href="deleteLevelStudent.do?id=${level.keyString}">Remove</a></td>
				<td><a href="getRoombyLevelStudent.do?id=${level.keyString}">view Room</a></td>
			
			</tr>
		</c:forEach>
	</table>
	<a href="newlevel.do">Add New Room</a>
</body>
</html>