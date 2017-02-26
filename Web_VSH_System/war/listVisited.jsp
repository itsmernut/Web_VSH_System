<%@page import="com.mfu.entity.Student_Information"%>
<%@page import="com.mfu.dao.Student_DAO"%>
<%@page import="com.mfu.entity.Visited_Information"%>
<%@page import="java.util.List"%>
<%@page import="com.mfu.dao.Visited_DAO"%>
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
		<%
				Visited_DAO visiteddao = new Visited_DAO();
				List<Visited_Information> visited = visiteddao.getAllVisiteds();
				visiteddao.closeEntityManager();
			
				for(Visited_Information visit : visited){
				
					Student_DAO studao = new Student_DAO();
					Student_Information stu = studao.findStudentByKey(visit.getStudentId());
		%>				
					<tr>
					<td><%=visit.isVisited() %></td>
					<td><%=stu.getFirstName()%></td>
					<td><%=stu.getLastName()%></td>
					<td><%=visit.getDate() %></td>

					<td><a href="deleteVisited.do?id=${visited.keyString}">Remove</a></td>

				</tr>
		<%		
				
				}
		%>
	</table>

</body>
</html>