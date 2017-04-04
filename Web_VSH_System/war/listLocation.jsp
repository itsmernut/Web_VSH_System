<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Location_Information</title>
</head>
<body>
	<table border="1">
		<c:forEach items="${locationList}" var="location">
			<tr>
				<td>${location.xpoint}</td>
				<td>${location.ypoint}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="newLocation.do">Add New Location</a><br>
</body>
</html>