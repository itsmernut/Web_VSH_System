<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Classroom</title>
</head>
<body>
	<table border="1">
		<c:forEach items="${roomList}" var="room">
			<tr>
				<td>${room.room}</td>
				
				<td><a href="listStudentStu.do?id=${room.keyString}">view Student</a></td>
			
			</tr>
		</c:forEach>
	</table>
</body>
</html>