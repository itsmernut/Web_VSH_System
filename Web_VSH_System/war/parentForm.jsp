<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Parent Information</title>
</head>
<body>

	<form:form method="post" action="saveParent.do" commandName="parent">
		<input type="hidden" name="keyString" value="${keyString }"><br />
		
		ชื่อจริง: <form:input path="firstName" /><br />
		นามสกุล: <form:input path="lastName" /><br />
		อีเมล์: <form:input path="email" /><br />
		เบอร์โทร: <form:input path="phone" /><br />
		บ้านเลขที่: <form:input path="address" /><br />
		ตำบล: <form:input path="subDistrict" /><br />
		อำเภอ: <form:input path="district" /><br />
		จังหวัด: <form:input path="province" /><br />
		ไปรษณีย์: <form:input path="postalcode" /><br />
		ประเทศ: <form:input path="country" /><br />
		สถานะ: <form:input path="relationship" /><br />
		
		<input type="submit" value="Save" />
	</form:form>

</body>
</html>