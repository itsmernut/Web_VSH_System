<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Student</title>
</head>
<body>

	<table border="1">
		<c:forEach items="${studentList}" var="student">
			<tr>
				<td><input type="checkbox" checked></td>
				<td>${student.studentId}</td>
				<td>${student.firstName}</td>
				<td>${student.lastName}</td>
				<td>${student.email}</td>
				
				<td><a href="editStudent.do?id=${student.keyString}">Edit</a></td>
				<td><a href="deleteStudent.do?id=${student.keyString}">Remove</a></td>
				<td><a href="getStudentProfile.do?id=${student.keyString}">View Profile</a></td>
			
			</tr>
		</c:forEach>
	</table>
	<a href="newStudent.do">Add New Student</a>
	<a href="viewRoom.do?id="+Key">Back to Room</a>

</body>
</html>