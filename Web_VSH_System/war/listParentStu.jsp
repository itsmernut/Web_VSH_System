<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Parent</title>
</head>
<body>
	<table border="1">
		<c:forEach items="${parentList}" var="parent">
			<tr>
				
				<td>ชื่อขนามสกุล: ${parent.firstName}  ${parent.lastName}</td>
				<td>อีเมล์: ${parent.email}</td>
				<td>เบอร์โทร: ${parent.phone}</td>
				<td>บ้านเลขที่: ${parent.address}</td>
				<td>ตำบล: ${parent.subDistrict}</td>
				<td>อำเภอ: ${parent.district}</td>
				<td>จังหวัด: ${parent.province}</td>
				<td>ไปรษณีย์: ${parent.postalcode}</td>
				<td>ประเทศ: ${parent.country}</td>
				<td>สถานะ: ${parent.relationship}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>