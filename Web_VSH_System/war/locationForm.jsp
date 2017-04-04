<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Location Information</title>
</head>
<body>

	<form:form method="post" action="saveLocation.do" commandName="location">
		<input type="hidden" name="keyString" value="${keyString }"><br />

		X point: <form:input path="xpoint" /><br />
		Y point: <form:input path="ypoint" /><br />

	<input type="submit" value="Save" />
		</form:form>

</body>
</html>