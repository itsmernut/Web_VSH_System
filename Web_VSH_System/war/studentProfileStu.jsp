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
				<c:choose>
					<c:when test="${student.visited == true}">
						<td><input type="checkbox" checked></td>
					</c:when>
					<c:otherwise>
						<td><input type="checkbox" ></td>
					</c:otherwise>
				</c:choose>
				<td>รหัสนัเรียน: ${student.studentId}</td>
				<td>ชื่อขนามสกุล: ${student.firstName}  ${student.lastName}</td>
				<td>ห้อง: ${student.classroom}</td>
				<td>อีเมล์: ${student.email}</td>
				<td>วันเกิด: ${student.birthday}</td>
				<td>เบอร์โทร: ${student.phone}</td>
				<td>บ้านเลขที่: ${student.address}</td>
				<td>ตำบล: ${student.subDistrict}</td>
				<td>อำเภอ: ${student.district}</td>
				<td>จังหวัด: ${student.province}</td>
				<td>ไปรษณีย์: ${student.postalcode}</td>
				<td>ประเทศ: ${student.country}</td>
				
				<td><a href="checkStudent.do?id=${student.keyString}">Check Student</a></td>
				<td><a href="checkVisited.do?id=${student.keyString}">Record Time</a></td>
				<td><a href="listLocationStu.do?id=${student.keyString}">View Location</a></td>
				<td><a href="listParentStu.do?id=${student.keyString}">View Parent</a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>