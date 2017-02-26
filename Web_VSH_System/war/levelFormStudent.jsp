<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Level</title>
</head>
<body>

	<form:form method="post" action="saveLevelStudent.do" commandName="level">
		<input type="hidden" name="keyString" value="${keyString }"><br />
		
		Level: <form:input path="level" /><br />
		
		<input type="submit" value="Save" />
	</form:form>
	
</body>
</html>