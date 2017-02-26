<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Teacher</title>
</head>
<body>

	<table border="1">
		<c:forEach items="${teacherList}" var="teacher">
			<tr>
				
				<td>${teacher.teacherId}</td>
				<td>${teacher.firstName}</td>
				<td>${teacher.lastName}</td>
				<td>${teacher.email}</td>
				
				<td><a href="editteacher.do?id=${teacher.keyString}">Edit</a></td>
				<td><a href="deleteTeacher.do?id=${teacher.keyString}">Remove</a></td>
				<td><a href="getTeacherProfile.do?id=${teacher.keyString}">View Profile</a></td>
			
			</tr>
		</c:forEach>
	</table>
	<a href="newTeacher.do">Add New Teacher</a>
	<a href="viewRoom.do?id="+Key">Back to Room</a>

</body>
</html>