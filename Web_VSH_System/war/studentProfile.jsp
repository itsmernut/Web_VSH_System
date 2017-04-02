<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Profile</title>
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
				<td><a href="checkVisited.do?id=${student.keyString}">Check Student</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>