<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Room</title>
</head>
<body>

	<table border="1">
		<c:forEach items="${roomList}" var="room">
			<tr>
				
				<td>${room.room}</td>
				
				<td><a href="editRoomStudent.do?id=${room.keyString}">Edit</a></td>
				<td><a href="deleteRoomStudent.do?id=${room.keyString}">Remove</a></td>
				<td><a href="getStudentByRoom.do?id=${room.keyString}">view Student</a></td>
			
			</tr>
		</c:forEach>
	</table>
	<a href="newRoomStudent.do">Add New Room</a>
	<a href="listLevel.do">Back to Level</a>

</body>
</html>