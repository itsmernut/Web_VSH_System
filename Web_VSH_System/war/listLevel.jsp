<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Level_Information</title>
</head>
<body>
	<table border="1">
		<c:forEach items="${levelList}" var="level">
			<tr>
				
				<td>${level.level}</td>
				<td><a href="listRoom.do?id=${level.keyString}">View Room</a></td>
			
			</tr>
		</c:forEach>
	</table>
	<a href="newLevel.do">Add New Level</a><br>
	<a href="manageUser.jsp">Back to Manage</a>
</body>
</html>