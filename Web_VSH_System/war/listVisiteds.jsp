<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>list Visited</title>
</head>
<body>

	<table border="1">
		<c:forEach items="${AllStudentWithVisited}" var="checkedStudent">
			<tr>
				<td>${checkedStudent.visited.visited}</td>
				<td>${checkedStudent.student.classroom}</td>
				<td>${checkedStudent.student.firstName}</td>
				<td>${checkedStudent.student.lastName}</td>
				<td>${checkedStudent.visited.date}</td>
				
				<td><a href="deleteVisited.do?id=${checkedStudent.visited.key}">Remove</a></td>
			
			</tr>
		</c:forEach>
	</table>

</body>
</html>