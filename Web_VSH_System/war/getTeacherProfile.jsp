<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Profile Teacher</title>
</head>
<body>

	<table border="1">
		<c:forEach items="${teacherList}" var="teacher">
			<tr>
				
				<td>${teacher.teacherId}</td>
				<td>${teacher.firstName}</td>
				<td>${teacher.lastName}</td>
				<td>${teacher.email}</td>
				
			</tr>
		</c:forEach>
	</table>
	<a href="viewTeacherByRoom.do?id="+Key">Back to List Teacher</a>

</body>
</html>